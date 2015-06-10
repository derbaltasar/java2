package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;

public class SampleController implements Initializable {

	@FXML
	private TableView<Person> personTable;

	@FXML
	private TextField vornameFeld;
	@FXML
	private TextField nachnameFeld;

	@FXML
	DatePicker datePicker;

	private ObservableList<Person> oPersonList = FXCollections
			.observableArrayList();

	// Event Listener on Button.onAction
	@FXML
	private void send(ActionEvent event) {
		Person p = new Person(vornameFeld.getText(), nachnameFeld.getText(),
				datePicker.getValue());

		oPersonList.add(p);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		personTable.setItems(oPersonList);

		 personTable.getSelectionModel().selectedItemProperty().addListener(new
		 ChangeListener<Person>() {
		
		 @Override
		 public void changed(ObservableValue<? extends Person> observable,
		 Person oldValue, Person newValue) {
		
		
		 Alert alert = new Alert(AlertType.INFORMATION);
		 alert.setHeaderText("Person");
		 alert.setContentText(newValue.getNachname());
		 alert.show();
		 }
		 });
		

		personTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> {
					// TODO Auto-generated method stub

						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setHeaderText("Person");
						alert.setContentText(newValue.getNachname());
						alert.show();
					}

				);

	}
}

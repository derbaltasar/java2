package de.cimdata.adressdb.ui;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import de.cimdata.adressdb.dao.PersonDAO;
import de.cimdate.adressdb.model.Person;

public class AdressController implements Initializable{
	private PersonDAO dao; 
	@FXML
	private TableView<Person> personTableView;
	
	@FXML
	private TextField vornameFeld;
	@FXML
	private TextField nachnameFeld;
	@FXML
	private TextField plzFeld;
	@FXML
	private TextField ortFeld;
	@FXML
	private TextField emailFeld;
	@FXML
	private TextField mobilFeld;
	@FXML
	private TextField telefonFeld;
	@FXML
	private TextField strasseFeld;
	
	@FXML
	private Label infoLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dao = new PersonDAO();
		List<Person> list = dao.findAllPersons();
		ObservableList<Person> oList = FXCollections.observableArrayList(list);
		personTableView.setItems(oList);

	}
	
	@FXML
	private void save(ActionEvent event){
		boolean ok = dao.savePerson(
				new Person(
						vornameFeld.getText(),
						nachnameFeld.getText(), 
						plzFeld.getText(), 
						ortFeld.getText(),
						strasseFeld.getText(), 
						telefonFeld.getText(), 
						mobilFeld.getText(), 
						emailFeld.getText()
				)
		);
		if(ok){
			setInfoText("Datensatz gespeichert!");
		}
	}
	
	
	@FXML
	public void editCommit(CellEditEvent<Person, String> e){
		
		Person p = e.getRowValue();
		
	}
	//Effekt
	
	private void setInfoText(String text){
		FadeTransition ft = new FadeTransition(Duration.millis(3000),infoLabel);
		ft.setFromValue(1);
		ft.setToValue(0);
		ft.play();
		infoLabel.setText(text);
		
	}
	
}

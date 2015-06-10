package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;


public class SampleController implements Initializable{
	
	@FXML
	TableView<Person> tableView ;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//
		ObservableList<Person> obsPersonList = FXCollections.observableArrayList();
		obsPersonList.add(new Person("Max", "Meier"));
		obsPersonList.add(new Person("Marta", "Schultz"));
		obsPersonList.add(new Person("Otto", "Lehmann"));
		
		tableView.setItems(obsPersonList);
		
	}
	
}

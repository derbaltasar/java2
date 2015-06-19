package application;

import java.net.URL;
import java.util.ResourceBundle;






import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

public class SampleController implements Initializable{
	
	@FXML TableColumn<Person, String> nameColumn;
	@FXML TableView<Person> table;
	@FXML Label label;
	
	
	ObservableList<Person> personenList = FXCollections.observableArrayList(
			new Person("Max"),
			new Person("Ina"),
			new Person("Olaf"),
			new Person("Emma")
			
			);

	
	@FXML
	public void editStart(CellEditEvent<Person, String> t){
	
		System.out.println("start");
		
	}
	@FXML
	public void editCommit(CellEditEvent<Person, String> t){
		System.out.println("commit");
		// Person p = tableView <- List <- Person
		Person p =t.getTableView().getItems().get(t.getTablePosition().getRow());
		
		System.out.println(table.getSelectionModel().getSelectedItems());
		p.setName(t.getNewValue());
	}
	@FXML
	public void editCancel(){
		System.out.println("cancel");
	}
	
	@FXML
	public void delete(){
		Person p =table.getSelectionModel().getSelectedItem();
		personenList.remove(p);
		label.setText("Person "+p.getName()+" gelöscht...");
	}

	
	@FXML
	public void show(){
		label.setText(personenList+"");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		table.setItems(personenList);
		
		
		// für editieren der Zellen wichtig
		nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		///Multi Select
		table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		//--------------------Delete ContextMenu------------------------------
		ContextMenu cm = new ContextMenu();
		MenuItem deleteAllSelectedItem  = new MenuItem("Delete");
		table.setContextMenu(cm);
		
		cm.getItems().add(deleteAllSelectedItem);
		
		
		deleteAllSelectedItem.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				table.getItems().removeAll(table.getSelectionModel().getSelectedItems());
				
				
//				Person p = table.getSelectionModel().getSelectedItem();
//				table.getItems().remove(p);
//	
				
				
			}
		});
		
	}
	
}

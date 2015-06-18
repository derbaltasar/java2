package de.cimdata.adressdb.ui;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Duration;
import de.cimdata.adressdb.dao.PersonDAO;
import de.cimdate.adressdb.model.Person;

public class AdressController implements Initializable{
	private PersonDAO dao; 
	
	//---------- FXML ----------------------------------------
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
	private TextField suchFeld;
	
	
	@FXML
	private Label infoLabel;
	@FXML
	private TableColumn<Person, String> telefonColumn;
	@FXML
	private TableColumn<Person, String> mobilColumn;
	@FXML
	private TableColumn<Person, String> emailColumn;
	@FXML
	private ComboBox<ComboBoxData> filterComboBox;
	
	
	// --------------------------------------------------------

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		dao = new PersonDAO();
		List<Person> list = dao.findAllPersons();
		ObservableList<Person> oList = FXCollections.observableArrayList(list);
		personTableView.setItems(oList);
		
		// Spalten editierbar machen
		telefonColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		mobilColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		
		//------------- delete ----------------------------------

		///Multi Select
		personTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		//--------------------Delete ContextMenu------------------------------
		ContextMenu cm = new ContextMenu();
		MenuItem deleteAllSelectedItem  = new MenuItem("Delete");
		personTableView.setContextMenu(cm);
		cm.getItems().add(deleteAllSelectedItem);
		deleteAllSelectedItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//personTableView.getItems().removeAll(personTableView.getSelectionModel().getSelectedItems());
				Person p = personTableView.getSelectionModel().getSelectedItem();
				int id = p.getId();
				boolean ok = dao.deletePerson(id);
				if(ok){
					personTableView.getItems().remove(p);
				}
			}
		});
		
		//-----------filter -------------
		ObservableList<ComboBoxData > comboBoxDataList = FXCollections.observableArrayList();
		
		//-- fx:id's aller Spalten ermitteln
		for (TableColumn<Person,?>   column : personTableView.getColumns()) {
			comboBoxDataList.add(new ComboBoxData(column.getText(),column.getId()));// Label, FX:id
		} 
		
		filterComboBox.setItems(comboBoxDataList);// Liste zur ComboBox geben
		
		//
		filterComboBox.setValue(comboBoxDataList.get(2));

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
			refresh();
		}
	}
	
	
	//---------------------update---------------------
	
	@FXML
	public void editCommit(CellEditEvent<Person, String> e){
		
		String newValue= e.getNewValue();
		System.out.println(newValue);
		Person p = e.getRowValue();
		int id = p.getId();
		
		String fxIdColumn= e.getTableColumn().getId();
		
		boolean updateOk =dao.updatePerson(id, fxIdColumn, newValue);
		if(updateOk){
			setInfoText("Update erfolgreich");
		}
		
	}
	
	
	

	@FXML
	public void refresh(ActionEvent e){
		refresh();
	}
	
	private void refresh(){
		List<Person> list = dao.findAllPersons();
		ObservableList<Person> oList = FXCollections.observableArrayList(list);
		personTableView.setItems(oList);
	}
	
	
	
	
	@FXML
	public void find(ActionEvent e){
		ComboBoxData data = filterComboBox.getSelectionModel().getSelectedItem();
		
		//findByField bekommt fx:id(Column) und Suchtext 
		List<Person> list = dao.findByField(data.getValue(),suchFeld.getText());///fx:id:Column
		
		ObservableList<Person> oList = FXCollections.observableArrayList(list);
		personTableView.setItems(oList);
		
		
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

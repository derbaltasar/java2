package de.cimdata.dbtable.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import de.cimdata.dbtable.dao.GehaltDAO;
import de.cimdata.dbtable.model.Gehalt;

public class GehaltController implements Initializable{
	@FXML
	private TableView<Gehalt> gehaltTableView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		GehaltDAO dao = new GehaltDAO();
		List<Gehalt> list = dao.findAll();
		
		ObservableList<Gehalt> oList = FXCollections.observableArrayList(list);
		
		gehaltTableView.setItems(oList);
		
	}
	
	
	

}

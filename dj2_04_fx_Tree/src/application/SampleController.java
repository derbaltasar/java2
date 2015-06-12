package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class SampleController implements Initializable{
	
	@FXML
	TreeView<String> treeview;
	
	
	
	
	@FXML
	public void show(ActionEvent e){
		
		TreeItem<String> rootItem = new TreeItem<>("Root");
		TreeItem<String> a = new TreeItem<>("a");
		TreeItem<String> b = new TreeItem<>("b");
		rootItem.getChildren().add(a);
		
		rootItem.getChildren().add(b);
		
		a.getChildren().add(new TreeItem<>("aa"));
		
	
		
		rootItem.setExpanded(true);
		treeview.setRoot(rootItem);
		
		
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
}

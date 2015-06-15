package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class SampleController implements Initializable{
	
	
	@FXML
	private TreeView<String> cdTreeView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		TreeItem<String> root =CDTreeCreator.createTree("cd-catalog.xml");
		root.setExpanded(true);
		
		cdTreeView.setRoot(root);
		
	}
	
}

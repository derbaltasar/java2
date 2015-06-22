package de.cimdata.urlservice.ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import de.cimdata.urlservice.service.URLService;

public class SampleController implements Initializable{
	
	
	@FXML
	private TextField searchField;
	@FXML
	private ProgressBar progress;
	@FXML
	private TextArea textArea;
	@FXML
	private ListView<String> listView;
	
	@FXML
	private Label infoLabel;
	
	private URLService urlService;

	// Event Listener on Button.onAction
	@FXML
	public void search(ActionEvent event) {
		System.out.println("search");
		
	
		urlService.restart();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.setProperty("http.proxyHost", "10.101.102.1");
		System.setProperty("http.proxyPort", "8877");
		//System.setProperty("java.net.useSystemProxies", "true");
		urlService = new URLService(searchField.getText());
		searchField.setText("http://www.google.com");
		infoLabel.textProperty().bind(urlService.messageProperty());
	}
}

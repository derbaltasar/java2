package de.cimdata.urlservice.ui;

import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import de.cimdata.urlservice.service.URLService;

public class SampleController implements Initializable{
	
	//---FXML -------------------------
	@FXML private TextField searchField;
	@FXML private ProgressBar progress;
	@FXML private TextArea textArea;
	@FXML private ListView<String> listView;
	@FXML private Label infoLabel;
	//----Member----------------------------
	private URLService urlService;
	private ExtractURLService extractURLService;
	
	//----Button Events----------------------------
	@FXML
	public void search(ActionEvent event) {
		System.out.println("search");
		urlService.setUrlString(searchField.getText());
		urlService.restart();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.setProperty("java.net.useSystemProxies", "true");//cim-proxy
		urlService = new URLService();
		infoLabel.textProperty().bind(urlService.messageProperty());
		progress.progressProperty().bind(urlService.progressProperty());
		
		//-------------------Test -------------------------
		searchField.setText("http://www.java2s.com");
		// -----------------------
		urlService.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			
			@Override
			public void handle(WorkerStateEvent e1) {
				
				System.out.println("Hier UrlSerce fertig....");
				String quellcode = e1.getSource().getValue().toString();  // Result vom call
				textArea.setText(quellcode);
				// EXTRACTService
				
				extractURLService = new ExtractURLService(quellcode);
				extractURLService.restart();
				
				extractURLService.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
					
					@Override
					public void handle(WorkerStateEvent e2) {
						System.out.println(e2);
				
						List<String> linkList = (List<String>) e2.getSource().getValue();
						listView.setItems(FXCollections.observableArrayList(linkList));
						
					}
				});
			}
		});
	}
}

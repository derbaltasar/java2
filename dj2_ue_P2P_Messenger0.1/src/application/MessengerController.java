package application;

import java.net.URL;
import java.time.LocalTime;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MessengerController implements Initializable{
	//----FXML----------------------------------
	@FXML private TextField serverHostField;
	@FXML private TextField nameField;
	@FXML private TableView<MessageObject> messageTableView;
	@FXML private TextField sendMessageField;
	@FXML private TextField connectRemoteServerHostField;
	@FXML private Button sendMessage;
	
	//----- Member------------------------------
	
	private ObservableList<MessageObject> oMsgObjList = FXCollections.observableArrayList();
	private Server server;
	private Client client;
	
	// ---- Event--------------------------------
	@FXML public void serverStartButtonAction(ActionEvent event) {
		Button b = (Button) event.getSource();
		// im Thread laufen lassen, da sonst Verklemmung an GUI
		Task<String> task = new Task<String>() {

			@Override
			protected String call() throws Exception {

				server.setLocalServerHost(serverHostField.getText());
				boolean isBound = server.serverBind();
				if(isBound){
					// Button
					b.setStyle("-fx-background-color:green");
					server.serverStart();
					
				}
				
				return "?";
			}
			
		};
		Thread t = new Thread(task);
		t.setDaemon(true);
		t.start();
		
		
		
	
	}
	
	private void sendMessageAction() {
		MessageObject msgObj = new MessageObject(
				nameField.getText(), // Name
				sendMessageField.getText(), // Nachricht
				LocalTime.now()); // Systemzeit
		oMsgObjList.add(msgObj);// TableView füllen
		
		client.writeMSG(msgObj);// client schreibt zum Remote Server
		
	}
	
	// Event Listener on Button[#sendMessage].onAction
	@FXML public void sendMessageButtonAction(ActionEvent event) {
		sendMessageAction();
	}
	// Event Listener on Button[#sendMessage].onKeyReleased
	@FXML public void sendMessageKeyAction(KeyEvent event) {
		  if (event.getCode() == KeyCode.ENTER){
			  sendMessageAction();
		  }
	}
	// Event Listener on Button.onAction
	@FXML public void remoteServerConnectButtonAction(ActionEvent event) {
		Button b = (Button) event.getSource();
		boolean isConnected = client.connect(connectRemoteServerHostField.getText());
		if(isConnected){
			b.setStyle("-fx-background-color:green");
		}
	}
	@Override public void initialize(URL location, ResourceBundle resources) {
		server = new Server();
		client = new Client();
		messageTableView.setItems(oMsgObjList);
		
		// holt sich MessageObject:  MessageController <- Server <- MessageService
		server.getMessageService().valueProperty().addListener(new ChangeListener<MessageObject>() {

			@Override
			public void changed(
					ObservableValue<? extends MessageObject> observable,
					MessageObject oldValue, MessageObject newValue) {
				
					oMsgObjList.add(newValue);
			}
		});
	}
}

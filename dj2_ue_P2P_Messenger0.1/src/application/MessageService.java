package application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class MessageService extends Service<MessageObject> {

	private ObjectInputStream in;

	public void setClientSocket(Socket clientSocket) throws IOException {
		in = new ObjectInputStream(clientSocket.getInputStream());
	}

	@Override
	protected Task<MessageObject> createTask() {
		
		Task<MessageObject> task = new Task<MessageObject>() {
			
			@Override
			protected MessageObject call() throws Exception {
				System.out.println("Server.call...");
				updateMessage("call");
				MessageObject msgObj = null;
				
				while ((msgObj = (MessageObject) in.readObject()) != null) {
					
					System.out.println("MessageService.messageObject: "+msgObj);
					updateValue(msgObj);// ---> MessageObject "senden"
					
					//isCancelled() TODO
				}
				
				return msgObj;
			}
		};
		
			
		return task;
	}
	

}

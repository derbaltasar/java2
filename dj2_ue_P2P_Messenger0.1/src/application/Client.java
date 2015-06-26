package application;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javafx.concurrent.Task;

public class Client {
	private ObjectOutputStream out;

	public boolean connect(String remoteHost) {
		// - Socket erzeugen
		// - ObjectOutputStream erzeugen
		try { // TODO Closable
			Socket serverSocket = new Socket(remoteHost, Const.SERVER_PORT);
			out = new ObjectOutputStream(serverSocket.getOutputStream());

			return serverSocket.isConnected();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void writeMSG(MessageObject msgObj) {
		Task<MessageObject> task = new Task<MessageObject>() {
			@Override
			protected MessageObject call() throws Exception {
				// - Objekt senden
				
				out.writeObject(msgObj);
				return msgObj;
			}
		};
		Thread t = new Thread(task);
		t.setDaemon(true);
		t.start();
	}

//	public void setHost(String host) { TODO ???
//		this.host = host;// setzt den Host zum Server
//	}

}

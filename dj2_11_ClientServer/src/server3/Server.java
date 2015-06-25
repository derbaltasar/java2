package server3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Server {

	public Server() {
		try {
			ServerSocket serverSocket = new ServerSocket(1111);
			while (true) {
				Socket clientSocket = serverSocket.accept();// wartet, gibt die
															// Verbindung zum
															// Client zurück

				work(clientSocket);

				// Streams schließen

			}// while end

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();

		}

	}

	private void work(Socket clientSocket) throws IOException,
			ClassNotFoundException {

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					ObjectInputStream in = new ObjectInputStream(
							clientSocket.getInputStream());

					ObjectOutputStream out = new ObjectOutputStream(
							clientSocket.getOutputStream());// zum
					String text = String.valueOf(in.readObject());
					out.writeObject(text.toUpperCase());

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		
		t.start();

	}

	public static void main(String[] args) {
		new Server();
		
		
	}

}

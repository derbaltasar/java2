package server2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	
	public Server() {
		try {
			ServerSocket serverSocket = new ServerSocket(1111);
			while(true){
				Socket clientSocket = serverSocket.accept();// wartet, gibt die
															// Verbindung zum
															// Client zurück

				ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());     
				
				
				ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());// zum
																	// antworten
																	// (schreiben)

				String text =   String.valueOf(in.readObject());
				
				out.writeObject(text.toUpperCase());
				
				// Streams schließen
			
			}//while end
		
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public static void main(String[] args) {
		new Server();
	}

}

package server1;

import java.io.IOException;
import java.io.InputStream;
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

				InputStream in = clientSocket.getInputStream(); // zum lesen
				OutputStream out = clientSocket.getOutputStream();// zum
																	// antworten
																	// (schreiben)

				int a = in.read();
				int b = in.read();

				out.write(a + b);
				// Streams schließen
			
			}//while end
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new Server();
	}

}

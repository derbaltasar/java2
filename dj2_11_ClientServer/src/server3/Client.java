package server3;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public Client() {
		try {
			Socket serverSocket = new Socket("localhost", 1111);

			// Reihenfolge relevant!!!
			ObjectOutputStream out = new ObjectOutputStream(serverSocket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(serverSocket.getInputStream());

	
			out.writeObject("hallo.....");
			
			System.out.println(in.readObject());
			

	

			serverSocket.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Client();

	}

}

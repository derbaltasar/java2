package server1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public Client() {
		try {
			Socket serverSocket = new Socket("localhost",1111);
			
			InputStream in = serverSocket.getInputStream();
			OutputStream out = serverSocket.getOutputStream();
			
			out.write(5);
			out.write(6);
			
			System.out.println(in.read());

			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	public static void main(String[] args) {
		new Client();

	}

}

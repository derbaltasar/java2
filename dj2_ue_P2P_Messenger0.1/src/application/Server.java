package application;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	
	private ServerSocket serverSocket;
	private String localServerHost;
	private boolean stop;
	private MessageService messageService = new MessageService();
	
	public boolean serverBind(){
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(localServerHost, Const.SERVER_PORT));//127.0.0.1/127.0.0.2
			return serverSocket.isBound();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	public void serverStart() {
		while(!stop){//stop ->not used
			try {
				Socket clientSocket = serverSocket.accept();
				System.out.println("Server.clientSocket: "+clientSocket);
				messageService.setClientSocket(clientSocket);
				messageService.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public MessageService getMessageService() {
		return messageService;
	}
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	public String getLocalServerHost() {
		return localServerHost;
	}

	public void setLocalServerHost(String serverHost) {
		this.localServerHost = serverHost;
	}

}

package de.unbound.game.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class TCPConnector extends Thread{
	Socket clientSocket;
	InetAddress ip;
	int serverPort;
	public TCPThreadReceiver receiver;
	public TCPThreadSender sender;
	private ConnectionHandler connectionHandler;
	
	public TCPConnector(InetAddress ip,int serverPort,ConnectionHandler connectionHandler) {
		this.ip = ip;
		this.serverPort = serverPort;
		this.connectionHandler = connectionHandler;
		establishConnection();
	}
	
	public void establishConnection(){
			Socket clientSocket = null;
			try {
				clientSocket = new Socket(ip, serverPort);
			} catch (IOException e) {
				e.printStackTrace();
			}
			receiver = new TCPThreadReceiver(clientSocket);
			sender  = new TCPThreadSender(clientSocket,connectionHandler);
			receiver.start();
			sender.sendInitialMessage();
			sender.start();
	}
	
	public void stopTCPConnection(){
		receiver.setRunning(false);
		sender.setRunning(false);
	}

}
package de.unbound.game.network;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;



public class TCPConnecter extends Thread{
	Socket clientSocket;
	InetAddress ip;
	int serverPort;
	public TCPThreadReceiver receiver;
	public TCPThreadSender sender;
	
	public TCPConnecter(InetAddress ip,int serverPort) {
		this.ip = ip;
		this.serverPort = serverPort;
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
			sender  = new TCPThreadSender(clientSocket);
			receiver.start();
			sender.start();
			
	}
	

}
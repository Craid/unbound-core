package de.unbound.game.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ConnectionHandler {

	ConnectionHandler connectionHandler;
	public int portNumber;
	InetAddress serverIp;
	TCPConnecter 	tcpConnecter; // richtet Verbindung zum Server ein
	TCPThreadSender		tcpSender; 
	TCPThreadReceiver	tcpReceiver; 
	UDPThreadReceiver 	udpReceiver; //empfängt alle UDP-Packages
	UDPSender 			udpSender; //
	
	public static ConnectionHandler instance;
	
	public static ConnectionHandler getInstance(){
		if(instance == null)
			instance = new ConnectionHandler();
		return instance;
	}
	

	private ConnectionHandler(){
		//this.portNumber = 11300; //default value
	}
	
	public void establishTCPConnection(){
		if (serverIp==null)
			try {
				serverIp = InetAddress.getLocalHost();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		if (portNumber<80) portNumber = 11300;
		tcpConnecter = new TCPConnecter(serverIp, portNumber);
	}
	public void closeTCPConnection(){

	}
	public void startUDP(){

	}
	public void stopUDP(){

	}
	
	public void startTCP(){
		tcpConnecter = new TCPConnecter(serverIp, 11300);
	}
	public void stopTCP(){

	}


	
	public void setPortNumber(int port){
		this.portNumber = port;
	}
	public void setServerIp(String ipAsString){
		try {
			serverIp = InetAddress.getByName(ipAsString);
		} catch (UnknownHostException e) {
		}
	}

}

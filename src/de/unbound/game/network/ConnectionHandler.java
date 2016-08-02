package de.unbound.game.network;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import de.unbound.game.network.serialization.PacketDeserializer.DeserializedEntity;

public class ConnectionHandler {

	ConnectionHandler connectionHandler;
	public int portNumber;
	public InetAddress serverIp;
	TCPConnecter 	tcpConnecter; // richtet Verbindung zum Server ein
	public UDPThreadReceiver 	udpReceiver; //empfängt alle UDP-Packages
	public UDPThreadSender 	udpSender; //
	DatagramSocket udpSocket;
	public DeserializedEntity player;
	public DeserializedEntity mainBase;
	
	boolean initializedConnection = false; //wenn Spieler und Main Base empfangen wurden
	

	private static ConnectionHandler instance;
	
	public static ConnectionHandler getInstance(){
		if(instance == null)
			instance = new ConnectionHandler();
		return instance;
	}
	

	private ConnectionHandler(){
		if (portNumber<80) portNumber = 11300;
		//this.portNumber = 11300; //default value
	}
	
	public void startConnection(){
		initializeDatagramSocket();
		startTCP();
		//establishTCPConnection();
//		startUDP();
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
		//TODO Marwin SCHLIEß ES!
	}
	private void initializeDatagramSocket(){
		try {
			udpSocket = new DatagramSocket();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void startUDP(){

		udpReceiver = new UDPThreadReceiver(udpSocket);
		udpSender = new UDPThreadSender(udpSocket,serverIp, portNumber+1);
		udpReceiver.start();
		//udpSender.start(); eig gar nicht nötig
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
	
	public boolean isInitializedConnection() {
		return initializedConnection;
	}


	public void setInitializedConnection(boolean initializedConnection) {
		this.initializedConnection = initializedConnection;
	}

}

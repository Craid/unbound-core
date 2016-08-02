package de.unbound.game.network;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import de.unbound.utility.UnboundConstants;

public class ConnectionHandler {

	public int portNumber;
	public InetAddress serverIp;
	public TCPConnector 	tcpConnecter; // richtet Verbindung zum Server ein
	public UDPThreadReceiver 	udpReceiver; //empfängt alle UDP-Packages
	public UDPSender 	udpSender; //
	DatagramSocket udpSocket;
	public int ownUdpPort;
	
	boolean initializedConnection = false; //wenn Spieler und Main Base empfangen wurden
	
	public ConnectionHandler(){
		if (portNumber<80) portNumber = UnboundConstants.tcpPort;
		setServerIp(UnboundConstants.IPADDRESS);
		
		startConnection();
	}
	
	public void startConnection(){
		initializeDatagramSocket();
		startTCP();
		//establishTCPConnection();
		//		startUDP();
	}
	

	public void closeTCPConnection(){
		//TODO Marwin SCHLIEß ES!
	}
	private void initializeDatagramSocket(){
		try {
			udpSocket = new DatagramSocket();
			ownUdpPort = udpSocket.getLocalPort();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void startUDP(){

		udpReceiver = new UDPThreadReceiver(udpSocket,this);
		udpSender = new UDPSender(udpSocket,serverIp);
		udpReceiver.start();
		//udpSender.start(); eig gar nicht nötig
	}
	public void stopUDP(){

	}
	
	public void startTCP(){
		tcpConnecter = new TCPConnector(giveInetAddress(UnboundConstants.IPADDRESS), UnboundConstants.tcpPort,this);
	}
	
	public InetAddress giveInetAddress(String args){
		try {
			this.serverIp = InetAddress.getByName(args);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return serverIp;
	}
	
	public void stopTCP(){
		tcpConnecter.stopTCPConnection();
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

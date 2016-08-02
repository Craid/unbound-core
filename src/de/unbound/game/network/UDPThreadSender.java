package de.unbound.game.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPThreadSender extends Thread{

	private InetAddress ipServer;
	private int portServer;
	private DatagramSocket socket;
	public static DatagramPacket lastPacket;
	public boolean running;

	public UDPThreadSender(DatagramSocket udpSocket,InetAddress ipAddress, int portServer) {
			this.socket = udpSocket;
			this.ipServer = ipAddress;
			this.portServer = portServer;
			running = true;
	}

	public void sendData(byte[] data){
		DatagramPacket packet = new DatagramPacket(data, data.length, ConnectionHandler.getInstance().serverIp, ConnectionHandler.getInstance().portNumber+1); // 11301 = Port für Server Receiver
		try {
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		while (running){

		while (ConnectionHandler.getInstance().isInitializedConnection()){

				//sendData("ClientUDP".getBytes());
			}
		}
	}
	public void toggleRunning(){
		running = !running;
	}
	public void setRunning(boolean active){
		running = active;
	}
}

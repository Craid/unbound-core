package de.unbound.game.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import de.unbound.utility.UnboundConstants;

public class UDPSender{

	private InetAddress ipServer;
	private DatagramSocket socket;
	public static DatagramPacket lastPacket;
	public boolean running;

	public UDPSender(DatagramSocket udpSocket,InetAddress ipAddress) {
			this.socket = udpSocket;
			this.ipServer = ipAddress;
			running = true;
	}

	public void sendData(byte[] data){
		DatagramPacket packet = new DatagramPacket(data, data.length, ipServer, UnboundConstants.udpPort); // 11301 = Port für Server Receiver
		try {
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void toggleRunning(){
		running = !running;
	}
	
	public void setRunning(boolean active){
		running = active;
	}
}

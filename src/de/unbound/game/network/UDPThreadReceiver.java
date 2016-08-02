package de.unbound.game.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import de.unbound.game.network.serialization.PacketSerializer;

public class UDPThreadReceiver extends Thread{

	private DatagramSocket socket;
	private int portNumber;
	private boolean running = false;
	private static PacketSerializer entitySerializer = new PacketSerializer();
	private DatagramPacket lastPacket;
	
	
	public UDPThreadReceiver(DatagramSocket udpSocket) {
				byte[] data = new byte[4096];
				this.lastPacket = new DatagramPacket(data, data.length); 
				this.socket = udpSocket; // Portnummer ist egal, es wird ein freier autm. gesucht
	}
	
	
	public void run(){
		running = true;
		while (running){
		
			while (ConnectionHandler.getInstance().isInitializedConnection()){	
		
				byte[] data = new byte[4096];
				DatagramPacket packet = new DatagramPacket(data, data.length); // read packet
				try {
					socket.receive(packet); // wartet so lange, bis ein Packet ankommt
					setLastPacket(packet); // letztes Packet wird in Variable geschrieben
				} catch (IOException e) {
					e.printStackTrace(); // Fehler beim Empfang des Packages
				}
				String message = new String(packet.getData()); // hier versuchen wir aus dem Packet den String zu lesen
			}
		}
		socket.close();
	}

	
	
	
	public void toggleRunning(){
		running = !running;
	}
	public void setRunning(boolean active){
		running = active;
	}
	
	
	public int getPortNumber(){
		return portNumber;
	}


	public synchronized DatagramPacket getLastPacket() {
		return lastPacket;
	}


	public synchronized void setLastPacket(DatagramPacket lastPacket) {
		this.lastPacket = lastPacket;
	}
	
	
}

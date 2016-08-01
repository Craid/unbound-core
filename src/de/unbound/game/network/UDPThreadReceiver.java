package de.unbound.game.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import de.unbound.game.network.serialization.PacketSerializer;

public class UDPThreadReceiver extends Thread{

	private DatagramSocket socket;
	private int portNumber;
	private boolean running = false;
	private static PacketSerializer entitySerializer = new PacketSerializer();
	public DatagramPacket lastPacket;
	
	public UDPThreadReceiver(int portNumber) {
			try {
				this.socket = new DatagramSocket(); // Portnummer ist egal, es wird ein freier autm. gesucht
			} catch (SocketException e) {
				e.printStackTrace();
			} 
	}
	
	
	public void run(){
		running = true;
		while (running){
			
				byte[] data = new byte[1024];
				DatagramPacket packet = new DatagramPacket(data, data.length); // read packet
				try {
					socket.receive(packet); // wartet so lange, bis ein Packet ankommt
					lastPacket = packet; // letztes Packet wird in Variable geschrieben
				} catch (IOException e) {
					e.printStackTrace(); // Fehler beim Empfang des Packages
				}
				String message = new String(packet.getData()); // hier versuchen wir aus dem Packet den String zu lesen
				System.out.println("[I AM GAME CLIENT] SERVER said: "+ message);
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
	
	
}

package de.unbound.game.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import de.unbound.game.network.serialization.PacketDeserializer;

public class UDPThreadReceiver extends Thread{

	private DatagramSocket socket;
	private int portNumber;
	private boolean running = false;
	private DatagramPacket lastPacket;
	private ConnectionHandler connectionHandler;
	private PacketDeserializer deserializer;
	private long timeStamp;
	
	public UDPThreadReceiver(DatagramSocket udpSocket,ConnectionHandler connectionHandler) {
		byte[] data = new byte[4096];
		this.lastPacket = new DatagramPacket(data, data.length); 
		this.socket = udpSocket; // Portnummer ist egal, es wird ein freier autm. gesucht
		this.connectionHandler = connectionHandler;
		this.deserializer = new PacketDeserializer();
		timeStamp = 0;
	}
	
	public void run(){
		running = true;
		byte[] data = new byte[4096];
		DatagramPacket packet = new DatagramPacket(data, data.length); // read packet
		while (running){
			while (connectionHandler.isInitializedConnection()){	
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

	public synchronized byte[] getLatestBytes() {
		byte[] data = null;
		synchronized (lastPacket) {
			data = lastPacket.getData();
		}
		return data;
	}

	public synchronized void setLastPacket(DatagramPacket lastPacket) {
		long tempTimeStamp = deserializer.getTimeStampFromByteArray(lastPacket.getData());
		if(tempTimeStamp > timeStamp){
			timeStamp = tempTimeStamp;
			this.lastPacket = lastPacket;
		}
	}
	
}

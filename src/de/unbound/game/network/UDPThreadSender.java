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
			System.out.println(ConnectionHandler.getInstance().portNumber+1);
			socket.send(packet);
			System.out.println(socket.getLocalPort());
			//System.out.println("[I AM GAME CLIENT] Successfully sent the Packet to the Server, hoping it arrived!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run(){
		while (running){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		while (ConnectionHandler.getInstance().isInitializedConnection()){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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

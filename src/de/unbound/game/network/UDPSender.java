package de.unbound.game.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import de.unbound.game.network.serialization.ByteBuilderHelper;

public class UDPSender{

	private InetAddress ipServer;
	private int portServer;
	private DatagramSocket socket;
	public static DatagramPacket lastPacket;

	public UDPSender(InetAddress ipAddress, int portServer) {
		try {
			this.socket = new DatagramSocket();
			this.ipServer = ipAddress;
			this.portServer = portServer;
			
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	
	public void sendData(byte[] data){
		DatagramPacket packet = new DatagramPacket(data, data.length, ipServer, 11301); // 11333 = Port
		try {
			socket.send(packet);
			System.out.println("[I AM GAME CLIENT] Successfully sent the Packet to the Server, hoping it arrived!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

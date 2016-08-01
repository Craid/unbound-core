package de.unbound.game.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

import de.unbound.game.network.serialization.PacketDeserializer;

public class TCPThreadReceiver extends Thread {

	private Socket skt;
	public boolean running = true;
	boolean playerReceived = false;
	boolean mainBaseReceived = false;
	private PacketDeserializer deserializer;

	public TCPThreadReceiver(Socket skt) {
		this.skt = skt;
		deserializer = new PacketDeserializer();
	}

	@Override
	public void run() {
		System.out.println("Receive Thread Started");
		BufferedReader sktReceive;
		try {
			sktReceive = new BufferedReader(new InputStreamReader(
					skt.getInputStream()));
			String input = "aaaa";
			while (running) {
				input = sktReceive.readLine();
				System.out.println("input: " + input);
				checkInput(input);
				System.out.println(input+" <---I just read");
				
			}
			sktReceive.close();
			skt.close();
		} catch (SocketException e) {
			System.out.println("Socket was closed. Ignore, if you exited.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void checkInput(String input){
		if (input.length()>15) if (input.substring(0, 7).equalsIgnoreCase("Player:")){
			byte[] array = new String(input.substring(7, input.length())).getBytes();
			System.out.println("Player legnth : " +array.length);
			ConnectionHandler.getInstance().player = deserializer.getDeserializedEntityFromByteArray(array,0).get(0);
			playerReceived = true;
			
			if (playerReceived & mainBaseReceived) ConnectionHandler.getInstance().setInitializedConnection(true);
		}
		if (input.length()>15) if (input.substring(0, 9).equalsIgnoreCase("MainBase:")){
			byte[] array = new String(input.substring(9, input.length())).getBytes();
			System.out.println("Main Base legnth : " +array.length);
			ConnectionHandler.getInstance().mainBase = deserializer.getDeserializedEntityFromByteArray(array,0).get(0);
			mainBaseReceived = true;
			if (playerReceived & mainBaseReceived) ConnectionHandler.getInstance().setInitializedConnection(true);
			
		}
	}
}

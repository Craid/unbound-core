package de.unbound.game.network;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

import de.unbound.game.network.serialization.ByteBuilderHelper;

public class TCPThreadReceiver extends Thread {

	private Socket skt;
	public boolean running = true;

	public TCPThreadReceiver(Socket skt) {
		this.skt = skt;
	}

	@Override
	public void run() {
		
		/*
		running = true;
		System.out.println("TCP Receive Thread Started");
		try {
			DataInputStream dIn = new DataInputStream(skt.getInputStream());
			while (running) {
				int length = dIn.readInt(); // read length of incoming message
				System.out.println("got sum");
				
				if (length > 0) {
					System.out.println(length);
					byte[] message = new byte[8];
					dIn.readFully(message, 0, message.length); // read the
																// message
					System.out.println(dIn.read());
				}
			}
		} catch (Exception e) {
			System.out.println("exception");
		}
		*/
		
		
		System.out.println("Receive Thread Started");
		BufferedReader sktReceive;
		try {
			sktReceive = new BufferedReader(new InputStreamReader(
					skt.getInputStream()));
			String input = "aaaa";
			while (running) {
				input = sktReceive.readLine();
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
			System.out.println(input.substring(7, input.length()));
			System.out.println(array);
			System.out.println("Player empfangen");
			
			try{
			ByteBuilderHelper b = new ByteBuilderHelper();
			System.out.println(b.intFromByteArray(array,0)+" = Entity ID");
			System.out.println(b.byteFromByteArray(array,4)+" = Entity Class");
			System.out.println(b.floatFromByteArray(array,5)+" = Position X");
			System.out.println(b.floatFromByteArray(array,9)+" = Position Y");
			System.out.println(b.floatFromByteArray(array,13)+" = Direction X");
			System.out.println(b.floatFromByteArray(array,17)+" = Direction Y");
			System.out.println(b.floatFromByteArray(array,21)+" = Velocity X");
			System.out.println(b.floatFromByteArray(array,25)+" = Velocity Y");
			} catch (Exception e){}
		}
		if (input.length()>15) if (input.substring(0, 9).equalsIgnoreCase("MainBase:")){
			byte[] array = new String(input.substring(9, input.length()-2)).getBytes();
			System.out.println(input.substring(9, input.length()-2));
			System.out.println(array);
			System.out.println("Main Base empfangen");
			try{
			ByteBuilderHelper b = new ByteBuilderHelper();
			System.out.println(b.intFromByteArray(array,0)+" = Entity ID");
			System.out.println(b.byteFromByteArray(array,4)+" = Entity Class");
			System.out.println(b.floatFromByteArray(array,5)+" = Position X");
			System.out.println(b.floatFromByteArray(array,9)+" = Position Y");
			System.out.println(b.floatFromByteArray(array,13)+" = Direction X");
			System.out.println(b.floatFromByteArray(array,17)+" = Direction Y");
			System.out.println(b.floatFromByteArray(array,21)+" = Velocity X");
			System.out.println(b.floatFromByteArray(array,25)+" = Velocity Y");
			} catch (Exception e){}
			
		}
	}
}

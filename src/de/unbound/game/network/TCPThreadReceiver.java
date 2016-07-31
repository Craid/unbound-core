package de.unbound.game.network;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class TCPThreadReceiver extends Thread {

	private Socket skt;
	public boolean running = true;

	public TCPThreadReceiver(Socket skt) {
		this.skt = skt;
	}

	@Override
	public void run() {
		
		/*
		try{
				DataInputStream dIn = new DataInputStream(skt.getInputStream());

				int length = dIn.readInt();                    // read length of incoming message
				if(length>0) {
				    byte[] message = new byte[length];
				    dIn.readFully(message, 0, message.length); // read the message
				    
				}
		
		}catch(Exception e){}
		
		*/
		
		
		
		
		
		System.out.println("Receive Thread Started");
		BufferedReader sktReceive;
		try {
			sktReceive = new BufferedReader(new InputStreamReader(
					skt.getInputStream()));
			String input = "";
			while (running) {
				System.out.println("trying to read");
				input = sktReceive.readLine();
				System.out.println("I just read");
				if (input != null)
					System.out.println(input);
			}
			sktReceive.close();
			skt.close();
		} catch (SocketException e) {
			System.out.println("Socket was closed. Ignore, if you exited.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

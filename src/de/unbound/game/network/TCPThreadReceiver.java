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
		
		
		
		
		
		/*
		
		System.out.println("Receive Thread Started");
		BufferedReader sktReceive;
		try {
			sktReceive = new BufferedReader(new InputStreamReader(
					skt.getInputStream()));
			String input = "aaaa";
			while (running) {
				System.out.println("trying to read");
				input = sktReceive.readLine();
				System.out.println(input+" <---I just read");
			}
			sktReceive.close();
			skt.close();
		} catch (SocketException e) {
			System.out.println("Socket was closed. Ignore, if you exited.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}
}

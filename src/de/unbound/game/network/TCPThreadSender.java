package de.unbound.game.network;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;

public class TCPThreadSender extends Thread {

	private Socket skt;
	public boolean running = true;

	public TCPThreadSender(Socket skt) {
		this.skt = skt;
	}

	public String generateRandomPlayerName(){
		double rnd = Math.random();
		String randomName = "Generic Player";
		if (rnd<=0.10) randomName = "Bob";
		else if (rnd<=0.20) randomName = "Maverick";
		else if (rnd<=0.30) randomName = "Charles";
		else if (rnd<=0.40) randomName = "Christian";
		else if (rnd<=0.50) randomName = "Linda";
		else if (rnd<=0.60) randomName = "Laura";
		else if (rnd<=0.70) randomName = "Kathrin";
		else if (rnd<=0.80) randomName = "Marwin";
		else if (rnd<=0.90) randomName = "Michel";
		else if (rnd<=1.00) randomName = "David";
		return randomName;
	}
	public void sendInitialMessage(){
		BufferedWriter sktSend;
		try {
			//Thread.sleep(500);
			sktSend = new BufferedWriter(new OutputStreamWriter(skt.getOutputStream()));
			String input = generateRandomPlayerName()+"\n";
			sktSend.write(input);
			sktSend.flush();
			
			input = "New Player\n";
			sktSend.write(input);
			sktSend.flush();

			input = String.valueOf(ConnectionHandler.getInstance().udpSocket.getLocalPort());
			input = input + "\n";
			sktSend.write(input);
			sktSend.flush();
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void run() {
		System.out.println("TCP Send Thread Started");
		BufferedWriter sktSend;
		try {
			
			sktSend = new BufferedWriter(new OutputStreamWriter(skt.getOutputStream()));

			String input = "Heartbeat\n";

			do {
				Thread.sleep(7500); //heartbeat
				sktSend.write(input);
				sktSend.flush();
			} while (!input.equalsIgnoreCase("EXIT\n"));
			System.out.println("You are now signed off.");
			running = false;
			sktSend.close();

		} catch (SocketException e) {
			System.out.println("Server Connection lost");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

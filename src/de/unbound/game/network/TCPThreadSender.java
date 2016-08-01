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

	
	public void sendInitialMessage(){
		BufferedWriter sktSend;
		try {
			//Thread.sleep(500);
			sktSend = new BufferedWriter(new OutputStreamWriter(skt.getOutputStream()));
			String input = "Generic Player\n";
			sktSend.write(input);
			sktSend.flush();
			
			input = "New Player\n";
			sktSend.write(input);
			sktSend.flush();
			//System.out.println("okkkkkk");
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void run() {
		System.out.println("TCP Send Thread Started");
		BufferedWriter sktSend;
		//BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			sktSend = new BufferedWriter(new OutputStreamWriter(skt.getOutputStream()));
			//System.out.println("Bitte Benutzernamen eingeben: ");
			//String input = console.readLine() + "\n";
			String input = "Heartbeat\n";
			//sktSend.write(input);
			//sktSend.flush();
			do {
				Thread.sleep(2500);
				//System.out.println("ok");
				//input = console.readLine() + "\n";
				sktSend.write(input);
				sktSend.flush();
			} while (!input.equalsIgnoreCase("EXIT\n"));
			System.out.println("You are now signed off.");
			running = false;
			sktSend.close();
			//console.close();

		} catch (SocketException e) {
			System.out.println("Server Connection lost");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

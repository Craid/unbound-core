package de.unbound.game.network;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;

public class TCPThreadSender extends Thread {

	public boolean running = true;
	ConnectionHandler connectionHandler;
	BufferedWriter sktSend;
	private String commands;

	public TCPThreadSender(Socket skt,ConnectionHandler connectionHandler) {
		this.connectionHandler = connectionHandler;
		try {
			sktSend = new BufferedWriter(new OutputStreamWriter(skt.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		commands = "";
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
		try {
			sendMessage(generateRandomPlayerName()+":"+String.valueOf(connectionHandler.udpSocket.getLocalPort())+"\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		System.out.println("TCP Send Thread Started");
		try {
			String input = "Heartbeat\n";
			do {
				if(commands.length() != 0){
					System.out.println("[TCP Send] "+ commands);
					sendMessage(commands);
					commands = "";
				}
			} while (!input.equalsIgnoreCase("EXIT\n") && running); 
			//TODO TCPClientGameCommandHandler: Falls Exit, dann set running false!
			//}while(running);
			
			System.out.println("You are now signed off.");
			sktSend.close();

		} catch (SocketException e) {
			System.out.println("Server Connection lost");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void sendMessage(String input) throws IOException {
		sktSend.write(input);
		sktSend.flush();
	}
	
	public String getCommands() {
		return commands;
	}

	public void appendCommands(String commands) {
		synchronized (this.commands) {
			this.commands += commands + "\n";
		}
	}
	
	public void setRunning(boolean running){
		this.running = running;
	}

}

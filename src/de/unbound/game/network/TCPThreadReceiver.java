package de.unbound.game.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class TCPThreadReceiver extends Thread {

	private Socket skt;
	public boolean running = true;
	boolean playerReceived = false;
	boolean mainBaseReceived = false;
	private String commands;

	public TCPThreadReceiver(Socket skt) {
		this.skt = skt;
		commands = "";
	}

	@Override
	public void run() {
		String input = "initialized";
		System.out.println("Receive Thread Started");
		BufferedReader sktReceive;
		try {
			sktReceive = new BufferedReader(new InputStreamReader(
					skt.getInputStream()));

			while (running) {
				input = sktReceive.readLine();
				appendCommands(input);
				System.out.println("[TCP Receiver] : " + input);
			}
			sktReceive.close();
			skt.close();
		} catch (SocketException e) {
			System.out.println("Socket was closed. Ignore, if you exited.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String[] getCommands() {
		String[] allCommands = new String[0];
		if (commands.length() != 0) {
			synchronized (commands) {
				allCommands = new String(commands).split("\n");
				commands = "";
			}
		}
		return allCommands;
	}

	public void appendCommands(String commands) {
		synchronized (this.commands) {
			this.commands += commands + "\n";
		}
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
}

package de.unbound.game.mode.client.util;

import java.util.ArrayList;

import de.unbound.game.mode.AbstractCommandHandler;
import de.unbound.game.network.ConnectionHandler;
import de.unbound.game.network.TCPThreadReceiver;
import de.unbound.game.network.serialization.PacketDeserializer;
import de.unbound.game.network.serialization.PacketDeserializer.DeserializedEntity;

public class TCPInitCommandHandler extends AbstractCommandHandler {

	private TCPThreadReceiver tcpReceiver;
	private boolean playerReceived, mainBaseReceived;
	private PacketDeserializer deserializer;
	private ArrayList<DeserializedEntity> desList;

	public TCPInitCommandHandler(ConnectionHandler connectionHandler) {
		tcpReceiver = connectionHandler.tcpConnecter.receiver;
		deserializer = new PacketDeserializer();
		desList = new ArrayList<PacketDeserializer.DeserializedEntity>();
	}

	@Override
	public String[] getCommands() {
		return tcpReceiver.getCommands();
	}
	
	public void handleCommand(String command) {
		if (command.length()>15) if (command.contains("Player:")){
			byte[] array = new String(command.substring(7, command.length())).getBytes();
			System.out.println("Player legnth : " + array.length);
			desList.add(deserializer.getDeserializedEntityFromByteArray(array, 0).get(0));
			playerReceived = true;
		}
		if (command.length()>15) if (command.contains("MainBase:")){
			byte[] array = new String(command.substring(9, command.length())).getBytes();
			System.out.println("Main Base length : " + array.length);
			desList.add(deserializer.getDeserializedEntityFromByteArray(array, 0).get(0));
			mainBaseReceived = true;
		}
	}

	public boolean isAllReceived() {
		return mainBaseReceived && playerReceived;
	}

	public ArrayList<DeserializedEntity> getDesList() {
		for(DeserializedEntity de : desList)
			System.out.println(de);
		return desList;
	}

}

package de.unbound.game.mode.client;

import de.unbound.game.mode.AbstractCommandHandler;
import de.unbound.game.mode.AbstractGameUpdate;
import de.unbound.game.network.TCPConnector;

public class ClientSurvivalSendCommandHandler extends AbstractCommandHandler {
	
	private TCPConnector tcpConnector;
	private AbstractGameUpdate gu;

	public ClientSurvivalSendCommandHandler(TCPConnector tcpC, AbstractGameUpdate gameUpdate){
		tcpConnector = tcpC;
		this.gu = gameUpdate;
	}

	public void handleCommand(String command) {
		tcpConnector.sender.appendCommands(command);
	}

	@Override
	public String[] getCommands() {
		return gu.getCommands();
	}
	
}

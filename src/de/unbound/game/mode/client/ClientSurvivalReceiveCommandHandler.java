package de.unbound.game.mode.client;

import de.unbound.game.World;
import de.unbound.game.mode.AbstractCommandHandler;
import de.unbound.game.network.TCPConnector;
import de.unbound.utility.UnboundConstants;

public class ClientSurvivalReceiveCommandHandler extends AbstractCommandHandler{

	private TCPConnector tcpConnector;

	public ClientSurvivalReceiveCommandHandler(TCPConnector tcpC){
		tcpConnector = tcpC;
	}
	
	@Override
	public String[] getCommands() {
		return tcpConnector.receiver.getCommands();
	}

	@Override
	public void handleCommand(String command) {
		if (command.equalsIgnoreCase("Respawn")){
			World.getInstance().getBattleField().getPlayers().get(0).setPosition(UnboundConstants.SPAWNPOINT);;
		}
	}

}

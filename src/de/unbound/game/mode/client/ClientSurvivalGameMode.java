package de.unbound.game.mode.client;

import de.unbound.game.mode.GameMode;
import de.unbound.game.mode.client.util.ClientSurvivalConfig;
import de.unbound.utility.UnboundConstants;

public class ClientSurvivalGameMode extends GameMode{
	
	public ClientSurvivalGameMode(ClientSurvivalConfig config){
		super(new ClientSurvivalWaveHandler(
				new ClientSurvivalEntityFactory(UnboundConstants.Race.Prelate.name(),false), 
				new ClientSurvivalEntityFactory(UnboundConstants.Race.Duck.name(),true),config),
				new ClientSurvivalGameUpdate(config));
	}
	
}

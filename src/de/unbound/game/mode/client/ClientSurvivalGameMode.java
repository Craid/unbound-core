package de.unbound.game.mode.client;

import de.unbound.game.factories.EntityFactory;
import de.unbound.game.mode.GameMode;
import de.unbound.utility.UnboundConstants;

public class ClientSurvivalGameMode extends GameMode{
	
	//TODO Michel Factories müssen vom Server initial empfangen werden
	public ClientSurvivalGameMode(EntityFactory ownFactory, EntityFactory enemyFactory){
		super(new ClientSurvivalWaveHandler(ownFactory, enemyFactory),new ClientSurvivalGameUpdate());
	}
	
	public ClientSurvivalGameMode(){
		super(new ClientSurvivalWaveHandler(
				new ClientSurvivalEntityFactory(UnboundConstants.Race.Prelate.name(),false), 
				new ClientSurvivalEntityFactory(UnboundConstants.Race.Duck.name(),true)),
				new ClientSurvivalGameUpdate());
	}
	
}

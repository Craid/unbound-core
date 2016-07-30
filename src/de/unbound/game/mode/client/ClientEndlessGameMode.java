package de.unbound.game.mode.client;

import de.unbound.game.factories.EntityFactory;
import de.unbound.game.mode.GameMode;
import de.unbound.utility.UnboundConstants;

public class ClientEndlessGameMode extends GameMode{
	
	//TODO Michel Factories müssen vom Server initial empfangen werden
	public ClientEndlessGameMode(EntityFactory ownFactory, EntityFactory enemyFactory){
		super(new ClientEndlessWaveHandler(ownFactory, enemyFactory),new ClientGameUpdate());
	}
	
	public ClientEndlessGameMode(){
		super(new ClientEndlessWaveHandler(
				new ClientEndlessEntityFactory(UnboundConstants.Race.Prelate.name(),false), 
				new ClientEndlessEntityFactory(UnboundConstants.Race.Duck.name(),true)),
				new ClientGameUpdate());
	}
	
}

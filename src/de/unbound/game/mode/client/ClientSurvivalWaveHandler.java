package de.unbound.game.mode.client;

import de.unbound.game.factories.EntityFactory;
import de.unbound.game.mode.WaveHandler;
import de.unbound.game.mode.local.LocalEndlessEntityFactory;

public class ClientSurvivalWaveHandler extends WaveHandler {
	
	public ClientSurvivalWaveHandler(EntityFactory ownFactory, EntityFactory enemyFactory) {
		super(ownFactory, enemyFactory);
		cummulativeTime = 2; //First Wave in 3 Seconds, next in steps of WAVETIMEOUTS
		level = -1;
	}
	
	public static ClientSurvivalWaveHandler createLocalEndlessWaveHandlerPreset() {
		EntityFactory ownFactory = new LocalEndlessEntityFactory("Prelate", false);
		EntityFactory enemyFactory = new LocalEndlessEntityFactory("Duck", true);
		return new ClientSurvivalWaveHandler(ownFactory,enemyFactory);
	}
	
	@Override
	public void update(double deltaTime) {
		
	}

}
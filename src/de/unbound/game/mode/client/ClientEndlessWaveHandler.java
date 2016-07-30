package de.unbound.game.mode.client;

import de.unbound.game.factories.EntityFactory;
import de.unbound.game.mode.WaveHandler;
import de.unbound.game.mode.local.LocalEndlessEntityFactory;

public class ClientEndlessWaveHandler extends WaveHandler {
	
	public ClientEndlessWaveHandler(EntityFactory ownFactory, EntityFactory enemyFactory) {
		super(ownFactory, enemyFactory);
		cummulativeTime = 2; //First Wave in 3 Seconds, next in steps of WAVETIMEOUTS
		level = -1;
	}
	
	public static ClientEndlessWaveHandler createLocalEndlessWaveHandlerPreset() {
		EntityFactory ownFactory = new LocalEndlessEntityFactory("Prelate", false);
		EntityFactory enemyFactory = new LocalEndlessEntityFactory("Duck", true);
		return new ClientEndlessWaveHandler(ownFactory,enemyFactory);
	}
	
	@Override
	public void update(double deltaTime) {
		
	}

}
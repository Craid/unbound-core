package de.unbound.game.wave;

import de.unbound.game.factories.EntityFactory;
import de.unbound.game.multiplayer.client.VersusConnection;


public class ExternalVersusWaveHandler extends WaveHandler {

	public ExternalVersusWaveHandler(EntityFactory ownFactory, EntityFactory enemyFactory) {
		super(ownFactory, enemyFactory);
	}

	private VersusConnection connection;

	@Override
	public void update(double deltaTime) {
		// TODO Auto-generated method stub
		
	}

}
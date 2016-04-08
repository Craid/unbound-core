package de.unbound.game.wave;

import de.unbound.game.factories.AbstractRaceFactory;
import de.unbound.game.multiplayer.client.*;


public class ExternalVersusWaveHandler extends WaveHandler {

	public ExternalVersusWaveHandler(AbstractRaceFactory ownFactory,
			AbstractRaceFactory enemyFactory) {
		super(ownFactory, enemyFactory);
	}

	private VersusConnection connection;

	@Override
	public void update(double deltaTime) {
		// TODO Auto-generated method stub
		
	}

}
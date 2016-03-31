package de.unbound.game;

import de.unbound.game.factories.*;
import de.unbound.game.wave.*;
import de.unbound.game.collision.*;

public class World {

	private AbstractRaceFactory enemyFactory;
	private AbstractRaceFactory ownFactory;
	private WaveHandler waveHandler;
	private CollisionDetection collisionDetection;

	/**
	 * 
	 * @param deltaTime
	 */
	public void update(double deltaTime) {
		// TODO - implement World.update
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param newWaveHandler
	 */
	public void setWaveHandler(WaveHandler newWaveHandler) {
		this.waveHandler = newWaveHandler;
	}

	public WaveHandler getWaveHandler() {
		return this.waveHandler;
	}

}
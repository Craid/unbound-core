package de.unbound.game;

import de.unbound.game.logic.AbstractGameUpdate;
import de.unbound.game.logic.LocalGameUpdate;
import de.unbound.game.wave.WaveHandler;

public class World {

	private WaveHandler waveHandler;
	private AbstractGameUpdate gameUpdate;

	public World(WaveHandler waveHandler, AbstractGameUpdate gameUpdate){
		this.waveHandler = waveHandler;
		this.gameUpdate = gameUpdate;
	}

	/**
	 * 
	 * @param deltaTime
	 */
	public void update(double deltaTime) {
		gameUpdate.update(deltaTime);
	}

	public WaveHandler getWaveHandler() {
		return waveHandler;
	}

	public void setWaveHandler(WaveHandler waveHandler) {
		this.waveHandler = waveHandler;
	}
	
}
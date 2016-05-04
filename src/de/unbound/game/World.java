package de.unbound.game;

import de.unbound.game.factories.AbstractRaceFactory;
import de.unbound.game.logic.AbstractGameUpdate;
import de.unbound.game.logic.ClientSurvivalGameUpdate;
import de.unbound.game.wave.WaveHandler;

public class World {

	private AbstractRaceFactory enemyFactory;
	private AbstractRaceFactory ownFactory;
	private WaveHandler waveHandler;
	private AbstractGameUpdate gameUpdate;

	public World(WaveHandler waveHandler){
		this.waveHandler = waveHandler;
		init();
	}

	private void init() {
		enemyFactory = this.waveHandler.getEnemyFactory();
		ownFactory = this.waveHandler.getOwnFactory();

		//Set basic defense units
		ownFactory.createImmobileEntities(waveHandler.getSeed());
		
		enemyFactory.createSpawner();
		
		ownFactory.createPlayer();
		
		gameUpdate = new ClientSurvivalGameUpdate();
		gameUpdate.setWorld(this);
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

	public AbstractRaceFactory getEnemyFactory() {
		return enemyFactory;
	}

	public void setEnemyFactory(AbstractRaceFactory enemyFactory) {
		this.enemyFactory = enemyFactory;
	}

	public AbstractRaceFactory getOwnFactory() {
		return ownFactory;
	}

	public void setOwnFactory(AbstractRaceFactory ownFactory) {
		this.ownFactory = ownFactory;
	}

}
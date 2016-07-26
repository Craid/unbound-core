package de.unbound.game;

import de.unbound.game.factories.EntityFactory;
import de.unbound.game.logic.AbstractGameUpdate;
import de.unbound.game.logic.ClientSurvivalGameUpdate;
import de.unbound.game.wave.WaveHandler;

public class World {

	private EntityFactory enemyFactory;
	private EntityFactory ownFactory;
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
		ownFactory.createMap(waveHandler.getSeed());
		enemyFactory.createEntity("Spawner");
		
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

	public EntityFactory getEnemyFactory() {
		return enemyFactory;
	}

	public void setEnemyFactory(EntityFactory enemyFactory) {
		this.enemyFactory = enemyFactory;
	}

	public EntityFactory getOwnFactory() {
		return ownFactory;
	}

	public void setOwnFactory(EntityFactory ownFactory) {
		this.ownFactory = ownFactory;
	}

}
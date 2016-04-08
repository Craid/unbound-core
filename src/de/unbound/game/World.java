package de.unbound.game;

import de.unbound.game.collision.CollisionDetection;
import de.unbound.game.factories.AbstractRaceFactory;
import de.unbound.game.wave.WaveHandler;
import de.unbound.game.wave.WaveOrder;

public class World {

	private AbstractRaceFactory enemyFactory;
	private AbstractRaceFactory ownFactory;
	private WaveHandler waveHandler;
	private CollisionDetection collisionDetection;

	public World(WaveHandler waveHandler){
		collisionDetection = new CollisionDetection();
		this.waveHandler = waveHandler;
		enemyFactory = waveHandler.getEnemyFactory();
		ownFactory = waveHandler.getOwnFactory();
	}
	
	/**
	 * 
	 * @param deltaTime
	 */
	public void update(double deltaTime) {
		waveHandler.update(deltaTime);
		if(waveHandler.hasNewOrder()){
			createWave(waveHandler.getCurrentOrder());
		}
	}

	private void createWave(WaveOrder order) {
		 enemyFactory.createWave(order);
		 System.out.println("Created Wave");
	}

}
package de.unbound.game;

import java.util.ArrayList;

import de.unbound.game.collision.CollisionDetection;
import de.unbound.game.factories.AbstractRaceFactory;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.immobile.ImmobileEntity;
import de.unbound.game.model.entities.mobile.MobileEntity;
import de.unbound.game.wave.WaveHandler;

public class World {

	private AbstractRaceFactory enemyFactory;
	private AbstractRaceFactory ownFactory;
	private WaveHandler gameMode;
	private CollisionDetection collisionDetection;
	private BattleField battleField;
	private ArrayList<MobileEntity> wave;

	public World(WaveHandler gameMode){
		this.gameMode = gameMode;
		init();
	}

	private void init() {
		collisionDetection = new CollisionDetection();
		enemyFactory = this.gameMode.getEnemyFactory();
		ownFactory = this.gameMode.getOwnFactory();
		battleField = BattleField.getBattleField();
		wave = new ArrayList<MobileEntity>();
		
		for(ImmobileEntity e : ownFactory.createImmobileEntities(gameMode.getSeed()))
			battleField.add(e);
	}
	
	/**
	 * 
	 * @param deltaTime
	 */
	public void update(double deltaTime) {
		gameMode.update(deltaTime);
		
		createNextWaveIfReadyAndPushToBattlefield();
		
		battleField.update(deltaTime);
		for(Entity e : battleField.getGameObjects())
			e.update(deltaTime);
		
	}

	private void createNextWaveIfReadyAndPushToBattlefield() {
		if(gameMode.hasNewOrder()){
			wave = enemyFactory.createWave(gameMode.getCurrentOrder());
			System.out.println("Created Wave");
		}
		if(wave.size() > 0){
			int subListLength = Math.min(wave.size(), 9);
			battleField.addWave(wave.subList(0,	subListLength));
			wave.subList(0, subListLength).clear();
			System.out.println("Added Wave Part");
		}
	}

}
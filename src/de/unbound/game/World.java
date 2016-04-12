package de.unbound.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.unbound.game.collision.CollisionDetection;
import de.unbound.game.factories.AbstractRaceFactory;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.immobile.ImmobileEntity;
import de.unbound.game.model.entities.mobile.MobileEntity;
import de.unbound.game.wave.WaveHandler;
import de.unbound.utility.AssetsManagingHelper;

public class World {

	private AbstractRaceFactory enemyFactory;
	private AbstractRaceFactory ownFactory;
	private WaveHandler gameMode;
	private CollisionDetection collisionDetection;
	private BattleField battleField;
	private ArrayList<MobileEntity> wave;
	private SpriteBatch batch;

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
		batch = new SpriteBatch();
		
		for(ImmobileEntity e : ownFactory.createImmobileEntities(gameMode.getSeed()))
			battleField.add(e);
	}
	
	/**
	 * 
	 * @param deltaTime
	 */
	public void update(double deltaTime) {
		Gdx.gl.glClearColor( 1, 0, 0, 1 );
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
		
		gameMode.update(deltaTime);
		
		createNextWaveIfReadyAndPushToBattlefield();
		battleField.update(deltaTime);
		
		for(Entity e : battleField.getGameObjects()){
			e.update(deltaTime);
		}

		batch.begin();
		System.out.println(AssetsManagingHelper.instance.getSprite("Prelate", "PrelateBoss").getHeight() + " , " + AssetsManagingHelper.instance.getSprite("Prelate", "PrelateBoss").getWidth());
		AssetsManagingHelper.instance.getSprite("Prelate", "PrelateBoss").draw(batch);;
//		for(Entity e : battleField.getGameObjects()){
//			e.render(batch);
//		}
		batch.end();
		
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
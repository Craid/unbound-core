package de.unbound.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.unbound.game.collision.CollisionDetection;
import de.unbound.game.factories.AbstractRaceFactory;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.wave.WaveHandler;

public class World {

	private AbstractRaceFactory enemyFactory;
	private AbstractRaceFactory ownFactory;
	private WaveHandler gameMode;
	private CollisionDetection collisionDetection;
	private BattleField battleField;
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
		batch = new SpriteBatch();
		
		//Set basic defense units
		ownFactory.createImmobileEntities(gameMode.getSeed());
		//ownFactory.createPlayer();
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

		render();
		
	}

	private void render() {
		batch.begin();

		//DUMMY TEST CODE
//		AssetsManagingHelper.instance.getSprite("PrelateAttacker", "PrelateBoss").draw(batch);;

		//REAL CODE
				for(Entity e : battleField.getGameObjects()){
					e.render(batch);
				}
		batch.end();
	}

	private void createNextWaveIfReadyAndPushToBattlefield() {
		if(gameMode.hasNewOrder()){
			enemyFactory.createWave(gameMode.getCurrentOrder());
			System.out.println("Created Wave");
		}
	}

}
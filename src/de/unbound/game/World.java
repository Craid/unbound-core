package de.unbound.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
	private OrthographicCamera camera;

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
		//Initialize and Set Camera
		InitializeAndConfigCamera();
		
		//Set basic defense units
		ownFactory.createImmobileEntities(gameMode.getSeed());
		
		enemyFactory.createSpawner();
		
		ownFactory.createPlayer();
	}
	
	public void InitializeAndConfigCamera() {
		//camera.zoom = 0.4f;
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
	}
	
	/**
	 * 
	 * @param deltaTime
	 */
	public void update(double deltaTime) {
		Gdx.gl.glClearColor( 0, 0, 0.10f, 1 );
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
		
		
		gameMode.update(deltaTime);
		
		createNextWaveIfReadyAndPushToBattlefield();
		battleField.update(deltaTime); // To be generated Objects in actual List
		
		collisionDetection.update(deltaTime);
		
		for(Entity e : battleField.getGameObjects()){
			e.update(deltaTime);
		}

		System.out.println(battleField.getGameObjects().size());
		
		render();
		
	}

	private void updateCameraPosition(){
		camera.position.x = battleField.getPlayer().getPosition().x;
		camera.position.y = battleField.getPlayer().getPosition().y;
		camera.zoom = 2.4f;
		camera.update();
	}
	
	private void render() {
		updateCameraPosition();
		batch.setProjectionMatrix(camera.combined); //ka warum... aber man muss es drinlassen
		//Damit die batch weiß, welcher Bereich angezeigt werden soll
		batch.begin();
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
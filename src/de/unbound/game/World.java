package de.unbound.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
	private BitmapFont font;
	private SpriteBatch hudBatch;

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
		hudBatch = new SpriteBatch();
		//Initialize and Set Camera
		//InitializeAndConfigCamera();
		camera = GameCamera.getGameCamera();
		//Set basic defense units
		ownFactory.createImmobileEntities(gameMode.getSeed());
		
		enemyFactory.createSpawner();
		
		ownFactory.createPlayer();
		font = new BitmapFont();
	}
	
	public void InitializeAndConfigCamera() {
		//camera.zoom = 0.4f;
		//camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		//camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
	}
	
	/**
	 * 
	 * @param deltaTime
	 */
	public void update(double deltaTime) {
		Gdx.gl.glClearColor( 0, 0, 0.10f, 1 );
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
		
		if(battleField.getMainBase().isActive()){
		
			gameMode.update(deltaTime);
		
			createNextWaveIfReadyAndPushToBattlefield();
			battleField.update(deltaTime); // To be generated Objects in actual List
		
			collisionDetection.update(deltaTime);
		
			for(Entity e : battleField.getGameObjects()){
				e.update(deltaTime);
			}

			render();
		}else{
			renderGameOver();
		}		
	}

	private void renderGameOver() {
		render();
		hudBatch.begin();
		String temp = "GameOver!";
		font.draw(hudBatch, temp, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		hudBatch.end();
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
		hudBatch.begin();
		String temp = String.format("Punkte: %010d", battleField.getScore());
		font.draw(hudBatch, temp, Gdx.graphics.getWidth()-140, Gdx.graphics.getHeight()-15);
		temp = String.format("Player-HP: %03d/500", (int)battleField.getPlayer().getHp());
		font.draw(hudBatch, temp, 10, Gdx.graphics.getHeight()-30);
		temp = String.format("MainBase-HP: %03d/1500", (int)battleField.getMainBase().getHp());
		font.draw(hudBatch, temp, 10, Gdx.graphics.getHeight()-15);
		hudBatch.end();
	}

	private void createNextWaveIfReadyAndPushToBattlefield() {
		if(gameMode.hasNewOrder()){
			enemyFactory.createWave(gameMode.getCurrentOrder());
			System.out.println("Created Wave");
			System.out.println(battleField.getGameObjects().size());
		}
	}

}
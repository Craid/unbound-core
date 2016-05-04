package de.unbound.game.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.unbound.game.GameCamera;
import de.unbound.game.model.entities.Entity;

public class ClientSurvivalGameUpdate extends AbstractGameUpdate {

	private BitmapFont font;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private SpriteBatch hudBatch;

	public ClientSurvivalGameUpdate() {
		initAbstract();
		init();
	}

	protected void init() {
		batch = new SpriteBatch();
		hudBatch = new SpriteBatch();
		camera = GameCamera.getGameCamera();
		font = new BitmapFont();
	}

	@Override
	public boolean isGameOver() {
		return battleField.getMainBase().isActive();
	}	
	
	@Override
	public void doBeforeUpdate() {
		//Do nothing
	}

	@Override
	public void onCollisionHandling(double deltaTime) {
		collisionDetection.update(deltaTime);
	}

	@Override
	public void doAfterUpdate() {
		render();
	}

	@Override
	public void onGameEnd() {
		renderGameOver();
	}


	public void render() {
		Gdx.gl.glClearColor( 0, 0, 0.10f, 1 );
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
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

}
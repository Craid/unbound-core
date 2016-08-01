package de.unbound.game.mode.local;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import de.unbound.game.GameCamera;
import de.unbound.game.World;
import de.unbound.game.mode.AbstractGameUpdate;
import de.unbound.game.model.entities.Entity;
import de.unbound.utility.UnboundConstants;

public class LocalEndlessGameUpdate extends AbstractGameUpdate {

	private BitmapFont font;
	private SpriteBatch batch;
	private SpriteBatch hudBatch;
	private Vector2 upperCorner, halfViewport;
	private Sprite bathTub;

	public LocalEndlessGameUpdate() {
		initAbstract(new LocaleEndlessCollisionDetection());
		init();
	}

	protected void init() {
		batch = new SpriteBatch();
		hudBatch = new SpriteBatch();
		camera = new GameCamera();
		font = new BitmapFont();
		upperCorner = new Vector2(
				UnboundConstants.WORLDWIDTH*battleField.getScaleX(),
				UnboundConstants.WORLDHEIGHT*battleField.getScaleY());
		halfViewport = new Vector2(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
		bathTub = new Sprite(new Texture(Gdx.files.internal("img/bathtub.png")));
		bathTub.setPosition(-560, -260);
		bathTub.setOrigin(0, 0);
		bathTub.setScale(1.33f, 1.08f);
	}

	private void test() {
		if(Gdx.input.isKeyPressed(Input.Keys.X))
			bathTub.scale(0.01f);
		if(Gdx.input.isKeyPressed(Input.Keys.C))
			bathTub.scale(-0.01f);
		
		System.out.println(bathTub.getScaleX());
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
		test();
		Gdx.gl.glClearColor( 0, 0, 0.10f, 1 );
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
		updateCameraPosition();
		batch.setProjectionMatrix(camera.combined); //ka warum... aber man muss es drinlassen
		//Damit die batch weiß, welcher Bereich angezeigt werden soll
		batch.begin();
		bathTub.draw(batch);
		
		for(Entity e : battleField.getGameObjects()){
			e.render(batch);
		}
		renderEntity(battleField.getPlayers().get(0));
		
		batch.end();
		hudBatch.begin();
		String temp = String.format("Punkte: %010d", battleField.getScore());
		font.draw(hudBatch, temp, Gdx.graphics.getWidth()-140, Gdx.graphics.getHeight()-15);
		temp = String.format("Player-HP: %03d/500", (int)battleField.getPlayers().get(0).getHp());
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
		float playerPosX = battleField.getPlayers().get(0).getPosition().x;
		float playerPosY = battleField.getPlayers().get(0).getPosition().y;
		float mapWidth = upperCorner.x;
		float mapHeight = upperCorner.y;
		
		camera.position.x = MathUtils.clamp(playerPosX, halfViewport.x, mapWidth - halfViewport.x);
		camera.position.y = MathUtils.clamp(playerPosY, halfViewport.y*2, mapHeight - halfViewport.y);
		
		camera.zoom = 2.4f;
		camera.update();
	}

	@Override
	public void updateWaveHandler(double deltaTime) {
		world.getWaveHandler().update(deltaTime);
		if(world.getWaveHandler().hasNewOrder())
			world.getWaveHandler().getEnemyFactory().createWave(world.getWaveHandler().getCurrentOrder());
	}

	@Override
	public void renderEntity(Entity e) {
		Sprite sprite = e.getModel().getGraphic();
		sprite.setPosition(e.getPosition().x-(sprite.getWidth()/2), e.getPosition().y-(sprite.getHeight()/2));
		sprite.setRotation(e.getDirection().angle());
		if(World.getInstance().isOnScreen(e))
			sprite.draw(batch);
	}

}

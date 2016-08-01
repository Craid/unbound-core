package de.unbound.game.mode;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import de.unbound.game.BattleField;
import de.unbound.game.GameCamera;
import de.unbound.game.World;
import de.unbound.game.model.entities.Entity;

public abstract class AbstractGameUpdate {

	protected World world;
	protected CollisionDetection collisionDetection;
	protected BattleField battleField;
	protected GameCamera camera;
	protected Sprite background;
	
	public AbstractGameUpdate(CollisionDetection collisionDetection){
		initAbstract(collisionDetection);
	}
	
	private void initAbstract(CollisionDetection collisionDetection){
		battleField = new BattleField();
		this.collisionDetection = collisionDetection;
		this.collisionDetection.setBattleField(battleField);
		initBackground();
	}

	private void initBackground() {
		background = new Sprite(new Texture(Gdx.files.internal("img/bathtub.png")));
		background.setPosition(-560, -260);
		background.setOrigin(0, 0);
	}

	public void update(double deltaTime){
		if(!isPaused()){
			if (isGameOver()) {
				doBeforeUpdate();
			
				updateWaveHandler(deltaTime);
				updateBattleField(deltaTime);
			
				onCollisionHandling(deltaTime);

				for (Entity e : battleField.getGameObjects()) {
					e.update(deltaTime);
				}

				doAfterUpdate();
			} else {
				onGameEnd();
			}
		}else{
			onGamePaused();
		}
	}

	public abstract boolean isGameOver();

	public abstract void doBeforeUpdate();
	
	private void updateBattleField(double deltaTime){
		battleField.update(deltaTime);
	}

	public abstract void updateWaveHandler(double deltaTime);
	
	public abstract void onCollisionHandling(double deltaTime);
	
	public abstract void doAfterUpdate();
	
	public abstract void onGameEnd();
	
	public abstract void renderEntity(Entity e);

	public abstract boolean isPaused();

	public abstract void onGamePaused();
	
	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public BattleField getBattleField() {
		return battleField;
	}
	
	public Camera getCamera(){
		return camera;
	}
	
}

package de.unbound.game.logic;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;

import de.unbound.game.BattleField;
import de.unbound.game.World;
import de.unbound.game.collision.CollisionDetection;
import de.unbound.game.model.entities.Entity;

public abstract class AbstractGameUpdate {

	protected World world;
	protected CollisionDetection collisionDetection;
	protected BattleField battleField;
	protected OrthographicCamera camera;
	
	protected void initAbstract(CollisionDetection collisionDetection){
		battleField = new BattleField();
		this.collisionDetection = collisionDetection;
		this.collisionDetection.setBattleField(battleField);
	}

	public void update(double deltaTime){
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

package de.unbound.game.logic;

import de.unbound.game.BattleField;
import de.unbound.game.World;
import de.unbound.game.collision.CollisionDetection;
import de.unbound.game.model.entities.Entity;

public abstract class AbstractGameUpdate {

	protected World world;
	protected CollisionDetection collisionDetection;
	protected BattleField battleField;
	
	protected void initAbstract(){
		collisionDetection = new CollisionDetection();
		battleField = BattleField.getInstance();
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
	
	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
}

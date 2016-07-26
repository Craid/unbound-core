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
		battleField = BattleField.getBattleField();
	}

	public void update(double deltaTime){
		if (isGameOver()) {
			doBeforeUpdate();
			
			updateWaveHandlerAndBattleField(deltaTime);
			
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
	
	public abstract void onCollisionHandling(double deltaTime);
	
	public abstract void doAfterUpdate();
	
	public abstract void onGameEnd();
	
	private void updateWaveHandlerAndBattleField(double deltaTime) {
		world.getWaveHandler().update(deltaTime);
		if(world.getWaveHandler().hasNewOrder()){
			world.getEnemyFactory().createWave(world.getWaveHandler().getCurrentOrder());
		}
		// To be generated Objects in actual List
		battleField.update(deltaTime);
	}
	
	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
}

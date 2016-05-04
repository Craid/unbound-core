package de.unbound.game.logic;

import de.unbound.game.BattleField;
import de.unbound.game.World;
import de.unbound.game.collision.CollisionDetection;

public abstract class AbstractGameUpdate {

	protected World world;
	protected CollisionDetection collisionDetection;
	protected BattleField battleField;
	
	protected void initAbstract(){
		collisionDetection = new CollisionDetection();
		battleField = BattleField.getBattleField();
	}

	public abstract void update(double deltaTime);
	
	protected void createNextWaveIfReadyAndPushToBattlefield() {
		if(world.getWaveHandler().hasNewOrder()){
			world.getEnemyFactory().createWave(world.getWaveHandler().getCurrentOrder());
		}
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
}

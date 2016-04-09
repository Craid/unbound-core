package de.unbound.game.collision;

import de.unbound.game.BattleField;

public class CollisionDetection {
	
	private BattleField battleField;

	public CollisionDetection() {
		init();
	}

	public void init() {
		this.battleField = BattleField.getBattleField();
	}

	/**
	 * 
	 * @param deltaTime
	 */
	public void update(double deltaTime) {
//		battleField.getGameObjects().doCollisionDetetctionStuff()
	}

}
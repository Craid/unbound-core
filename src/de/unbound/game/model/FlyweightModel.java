package de.unbound.game.model;

import de.unbound.game.collision.CollisionHandler;

public class FlyweightModel {

	private int rangeOfVision;
	private int rangeofCollision;
	private int upgrades;
	private int graphic;
	private CollisionHandler collisionHandler;
	
	public int getRangeOfVision() {
		return rangeOfVision;
	}
	public void setRangeOfVision(int rangeOfVision) {
		this.rangeOfVision = rangeOfVision;
	}
	public int getRangeofCollision() {
		return rangeofCollision;
	}
	public void setRangeofCollision(int rangeofCollision) {
		this.rangeofCollision = rangeofCollision;
	}
	public int getUpgrades() {
		return upgrades;
	}
	public void setUpgrades(int upgrades) {
		this.upgrades = upgrades;
	}
	public int getGraphic() {
		return graphic;
	}
	public void setGraphic(int graphic) {
		this.graphic = graphic;
	}
	public CollisionHandler getCollisionHandler() {
		return collisionHandler;
	}
	public void setCollisionHandler(CollisionHandler collisionHandler) {
		this.collisionHandler = collisionHandler;
	}

}
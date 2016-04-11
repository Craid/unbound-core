package de.unbound.game.model;

import com.badlogic.gdx.graphics.g2d.Sprite;

import de.unbound.game.collision.CollisionHandler;

public class EntityFlyweight {

	private double rangeOfVision;
	private double rangeofCollision;
	private int upgrades;
	private Sprite graphic;
	
	public double getRangeOfVision() {
		return rangeOfVision;
	}
	public void setRangeOfVision(double rangeOfVision) {
		this.rangeOfVision = rangeOfVision;
	}
	public double getRangeofCollision() {
		return rangeofCollision;
	}
	public void setRangeofCollision(double rangeofCollision) {
		this.rangeofCollision = rangeofCollision;
	}
	public int getUpgrades() {
		return upgrades;
	}
	public void setUpgrades(int upgrades) {
		this.upgrades = upgrades;
	}
	public Sprite getGraphic() {
		return graphic;
	}
	public void setGraphic(Sprite graphic) {
		this.graphic = graphic;
	}

}
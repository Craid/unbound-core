package de.unbound.game.model.entities.mobile;

import de.unbound.game.model.entities.*;
import de.unbound.game.model.state.move.*;
import de.unbound.game.model.state.attack.*;
import de.unbound.game.collision.*;

public abstract class MobileEntity extends Entity {

	private MoveState move;
	private AttackState attack;
	private double rangeOfVision;
	private double velocityX;
	private double velocityY;
	private int direction;

	public double getRangeOfVision() {
		return this.rangeOfVision;
	}

	/**
	 * 
	 * @param sight
	 */
	public void setRangeOfVision(double sight) {
		this.rangeOfVision = sight;
	}

	public double getVelocityX() {
		return this.velocityX;
	}

	/**
	 * 
	 * @param velocityX
	 */
	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}

	public double getVelocityY() {
		return this.velocityY;
	}

	/**
	 * 
	 * @param velocityY
	 */
	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}

	public int getDirection() {
		return this.direction;
	}

	/**
	 * 
	 * @param direction
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

	public CollisionHandler getCollisionHandler() {
		// TODO - implement MobileEntity.getCollisionHandler
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param collisionHandler
	 */
	public void setCollisionHandler(CollisionHandler collisionHandler) {
		// TODO - implement MobileEntity.setCollisionHandler
		throw new UnsupportedOperationException();
	}

}
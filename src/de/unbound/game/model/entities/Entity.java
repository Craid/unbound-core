package de.unbound.game.model.entities;

public abstract class Entity {

	private double x;
	private double y;
	private boolean active;

	/**
	 * 
	 * @param deltaTime
	 */
	public abstract void update(double deltaTime);

	public abstract void render();

	public double getX() {
		return this.x;
	}

	/**
	 * 
	 * @param x
	 */
	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return this.y;
	}

	/**
	 * 
	 * @param y
	 */
	public void setY(double y) {
		this.y = y;
	}

	public boolean getActive() {
		return this.active;
	}

	/**
	 * 
	 * @param active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * 
	 * @param upgradeInfo
	 */
	public void upgrade(int upgradeInfo) {
		// TODO - implement Entity.upgrade
		throw new UnsupportedOperationException();
	}

}
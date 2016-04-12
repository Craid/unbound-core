package de.unbound.game.model;

public class EntityFlyweightModel {
	
	private double rangeOfVision, rangeOfCollision;
	private float acceleration, maxVelocity;
	private int upgrades;
	private String textureName, atlasName;
	
	public EntityFlyweightModel(){}
	
	/**
	 * Constructor to set all values in one go
	 * 
	 * @param rangeOfVision
	 * @param rangeOfCollision
	 * @param upgrades
	 * @param textureName
	 * @param name
	 */
	public EntityFlyweightModel(double rangeOfVision, double rangeOfCollision, int upgrades, String textureName, String name, float accelaration, float maxVelocity){
		setRangeOfCollision(rangeOfCollision);
		setRangeOfVision(rangeOfVision);
		setUpgrades(upgrades);
		setTextureName(textureName);
		setAtlasName(name);
		setAcceleration(accelaration);
		setMaxVelocity(maxVelocity);
	}

	public double getRangeOfVision() {
		return rangeOfVision;
	}

	public void setRangeOfVision(double rangeOfVision) {
		this.rangeOfVision = rangeOfVision;
	}

	public double getRangeOfCollision() {
		return rangeOfCollision;
	}

	public void setRangeOfCollision(double rangeOfCollision) {
		this.rangeOfCollision = rangeOfCollision;
	}

	public int getUpgrades() {
		return upgrades;
	}

	public void setUpgrades(int upgrades) {
		this.upgrades = upgrades;
	}

	public String getTextureName() {
		return textureName;
	}

	public void setTextureName(String textureName) {
		this.textureName = textureName;
	}

	public String getAtlasName() {
		return atlasName;
	}

	public void setAtlasName(String name) {
		this.atlasName = name;
	}

	public float getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(float acceleration) {
		this.acceleration = acceleration;
	}

	public float getMaxVelocity() {
		return maxVelocity;
	}

	public void setMaxVelocity(float maxVelocity) {
		this.maxVelocity = maxVelocity;
	}
}

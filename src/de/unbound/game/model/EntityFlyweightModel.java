package de.unbound.game.model;

public class EntityFlyweightModel {
	
	private double rangeOfVision, rangeOfCollision;
	private int upgrades;
	private String textureName, atlasName;
	
	public EntityFlyweightModel(){}
	
	public EntityFlyweightModel(double rangeOfVision, double rangeOfCollision, int upgrades, String textureName, String name){
		setRangeOfCollision(rangeOfCollision);
		setRangeOfVision(rangeOfVision);
		setUpgrades(upgrades);
		setTextureName(textureName);
		setAtlasName(name);
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

}

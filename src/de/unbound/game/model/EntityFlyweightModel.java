package de.unbound.game.model;

public class EntityFlyweightModel {
	
	private double rangeOfVision, rangeOfCollision;
	private int upgrades;
	private String graphic, name;
	
	public EntityFlyweightModel(){}
	
	public EntityFlyweightModel(double rangeOfVision, double rangeOfCollision, int upgrades, String name, String graphic){
		setRangeOfCollision(rangeOfCollision);
		setRangeOfVision(rangeOfVision);
		setUpgrades(upgrades);
		setGraphic(graphic);
		setName(name);
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

	public String getGraphic() {
		return graphic;
	}

	public void setGraphic(String graphic) {
		this.graphic = graphic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

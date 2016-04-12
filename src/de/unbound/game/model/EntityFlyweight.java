package de.unbound.game.model;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class EntityFlyweight {

	private EntityFlyweightModel model;
	private Sprite graphic;
	
	public float getMaxVelocity(){
		return (float)model.getMaxVelocity();
	}
	
	public float getAcceleration(){
		return (float)model.getAcceleration();
	}
	
	public double getRangeOfVision() {
		return model.getRangeOfVision();
	}

	public double getRangeofCollision() {
		return model.getRangeOfCollision();
	}

	public int getUpgrades() {
		return model.getUpgrades();
	}

	public Sprite getGraphic() {
		return graphic;
	}
	
	public EntityFlyweightModel getModel(){
		return model;
	}
	
	public void setModel(EntityFlyweightModel model){
		this.model = model;
	}
	
	public void setGraphic(Sprite graphic) {
		this.graphic = graphic;
		
		//Für marwin einkommentieren
//		this.graphic.rotate90(true);
	}
	
}
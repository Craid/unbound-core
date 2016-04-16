package de.unbound.game.model.entities.mobile;

public abstract class Commander extends MobileEntity {
	
	public Commander(){
		super();
		setHostile(true);
		setHp(200);
	}
}
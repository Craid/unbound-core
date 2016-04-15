package de.unbound.game.model.entities.mobile;

public abstract class Pawn extends MobileEntity {
	
	public Pawn(){
		super();
		setHostile(true);
	}
}
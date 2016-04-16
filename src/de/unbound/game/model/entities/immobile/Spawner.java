package de.unbound.game.model.entities.immobile;

import com.badlogic.gdx.math.Vector2;

import de.unbound.utility.UnboundConstants;

public abstract class Spawner extends ImmobileEntity {
	
	public Spawner(){
		super();
		setPosition(new Vector2(UnboundConstants.WORLDWIDTH/2,UnboundConstants.WORLDHEIGHT-2*UnboundConstants.SINGLEGRIDHEIGHT));
		setDirection(new Vector2(0,-1));
		setHostile(true);
		setHp(1);
	}
	
	public void takeDamage(double hp) {
		//Intentionally left empty Shall not be destroyed!
		return;
	}
	
}
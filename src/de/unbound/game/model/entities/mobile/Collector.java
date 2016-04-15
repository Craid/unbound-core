package de.unbound.game.model.entities.mobile;

import com.badlogic.gdx.math.Vector2;

import de.unbound.utility.UnboundConstants;

public abstract class Collector extends MobileEntity {
	
	public Collector(){
		super();
		setPosition(new Vector2(UnboundConstants.WORLDWIDTH/2,UnboundConstants.SINGLEGRIDHEIGHT/10));
	}
}
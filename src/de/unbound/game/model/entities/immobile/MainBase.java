package de.unbound.game.model.entities.immobile;

import com.badlogic.gdx.math.Vector2;

import de.unbound.utility.UnboundConstants;

public abstract class MainBase extends ImmobileEntity {
	
	public MainBase(){
		super();
		setPosition(new Vector2(UnboundConstants.WORLDWIDTH/2,UnboundConstants.SINGLEGRIDHEIGHT/10));
	}
}
package de.unbound.game.model.entities.mobile;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.state.move.MoveStateControlled;
import de.unbound.utility.UnboundConstants;

public abstract class Player extends MobileEntity {
	
	
	public Player(){
		super();
		setPosition(new Vector2(UnboundConstants.WORLDWIDTH/2,UnboundConstants.SINGLEGRIDHEIGHT/10));
		setMove(new MoveStateControlled(this)); // Maus überarbeitet werden in singleton 
	}
	
	public void update(double deltaTime){
		getAttack().update(deltaTime);
		getMove().update(deltaTime);
		setMove(new MoveStateControlled(this)); // Maus überarbeitet werden in singleton 
	}
}
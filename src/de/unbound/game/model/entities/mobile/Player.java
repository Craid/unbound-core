package de.unbound.game.model.entities.mobile;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.state.attack.AttackStateStraight;
import de.unbound.game.model.state.move.MoveStateControlled;

public abstract class Player extends MobileEntity {
	
	
	public Player(){
		setMove(new MoveStateControlled(this)); // Maus überarbeitet werden in singleton 
	}
	
	public void update(double deltaTime){
		super.update(deltaTime);
		setMove(new MoveStateControlled(this)); // Maus überarbeitet werden in singleton 
	}
}
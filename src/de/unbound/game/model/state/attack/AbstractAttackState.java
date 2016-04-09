package de.unbound.game.model.state.attack;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.State;

public abstract class AbstractAttackState implements State{
	
	protected Entity e;
	
	public AbstractAttackState(Entity e){
		this.e = e;
	}

}
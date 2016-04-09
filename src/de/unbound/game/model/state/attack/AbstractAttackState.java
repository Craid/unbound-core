package de.unbound.game.model.state.attack;

import de.unbound.game.model.entities.Entity;

public abstract class AbstractAttackState implements AttackState{
	
	protected Entity e;
	
	public AbstractAttackState(Entity e){
		this.e = e;
	}

}
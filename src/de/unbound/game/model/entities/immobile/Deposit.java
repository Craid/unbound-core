package de.unbound.game.model.entities.immobile;

import de.unbound.game.model.state.attack.AbstractAttackState;

public abstract class Deposit extends ImmobileEntity {
	
	public Deposit(){
		setHp(500);
	}
	
	public void setAttack(AbstractAttackState attack) {
		//intentionally left blank, shall not attack
		return;
	}
}
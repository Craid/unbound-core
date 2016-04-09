package de.unbound.game.model.entities.mobile;

import de.unbound.game.model.state.attack.AttackStateNone;

public abstract class Projectile extends MobileEntity {
	
	public Projectile(){
		super();
		setAttack(new AttackStateNone(this));
	}
	
}
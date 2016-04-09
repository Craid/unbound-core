package de.unbound.game.model.entities.mobile;

import de.unbound.game.model.state.attack.AttackStateNone;

public abstract class Projectile extends MobileEntity {
	
	public Projectile(){
		super();
		System.out.println();
		setAttack(new AttackStateNone(this));
	}
	
}
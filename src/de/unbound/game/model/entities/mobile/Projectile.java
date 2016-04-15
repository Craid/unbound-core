package de.unbound.game.model.entities.mobile;

import de.unbound.game.model.state.attack.AttackStateNone;
import de.unbound.game.model.state.move.MoveStateStraightSpinning;

public abstract class Projectile extends MobileEntity {
	
	public Projectile(){
		super();
		setAttack(new AttackStateNone(this));
		setMove(new MoveStateStraightSpinning(this));
	}
	
}
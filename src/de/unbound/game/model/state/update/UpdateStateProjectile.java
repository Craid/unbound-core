package de.unbound.game.model.state.update;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.attack.AttackStateNone;
import de.unbound.game.model.state.move.MoveStateStraightSpinning;

public class UpdateStateProjectile extends AbstractUpdateState{

	
	public UpdateStateProjectile(Entity e) {
		super(e);
		attack = new AttackStateNone(e);
		move = new MoveStateStraightSpinning(e);
	}
	
	@Override
	public void update(double deltaTime) {
		move.update(deltaTime);
		takeDamage(deltaTime);
	}

	@Override
	public void takeDamage(double hp) {
		e.setHp(e.getHp() - hp);
		if(e.getHp() <= 0){
			e.setActive(false);
		}
	}

}

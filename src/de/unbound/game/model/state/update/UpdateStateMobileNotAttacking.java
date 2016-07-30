package de.unbound.game.model.state.update;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.attack.AttackStateNone;
import de.unbound.game.model.state.move.MoveStateStraight;

public class UpdateStateMobileNotAttacking extends AbstractUpdateState{

	public UpdateStateMobileNotAttacking(Entity e) {
		super(e);
		attack = new AttackStateNone(e);
		move = new MoveStateStraight(e);
	}
	
	public void update(double deltaTime){
		move.update(deltaTime);
	}

}

package de.unbound.game.model.state.update;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.attack.AttackStateNone;
import de.unbound.game.model.state.move.MoveStateNone;

public class UpdateStateImmobile extends AbstractUpdateState{

	
	public UpdateStateImmobile(Entity e) {
		super(e);
		attack = new AttackStateNone(e);
		move = new MoveStateNone(e);
	}
	
	@Override
	public void update(double deltaTime) {
		attack.update(deltaTime);
	}

}

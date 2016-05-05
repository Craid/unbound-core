package de.unbound.game.model.state.update;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.attack.AttackStateStraight;
import de.unbound.game.model.state.move.MoveStateWave;

public class UpdateStateMobile extends AbstractUpdateState{
	
	public UpdateStateMobile(Entity e) {
		super(e);
		attack = new AttackStateStraight(e);
		move = new MoveStateWave(e);
	}
	
}

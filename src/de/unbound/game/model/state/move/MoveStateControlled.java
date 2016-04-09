package de.unbound.game.model.state.move;

import de.unbound.game.model.entities.mobile.MobileEntity;

public class MoveStateControlled extends AbstractMoveState {

	public MoveStateControlled(MobileEntity e) {
		super(e);
	}

	@Override
	public void execute(double deltaTime) {
	}
}
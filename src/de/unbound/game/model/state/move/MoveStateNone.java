package de.unbound.game.model.state.move;

import de.unbound.game.model.entities.mobile.MobileEntity;

public class MoveStateNone extends AbstractMoveState {

	public MoveStateNone(MobileEntity e) {
		super(e);
	}

	@Override
	public void update(double deltaTime) {
	}

}
package de.unbound.game.model.state.move;

import de.unbound.game.model.entities.mobile.MobileEntity;
public class AbstractMoveState implements MoveState{
	
	protected MobileEntity e;
	
	public AbstractMoveState(MobileEntity e) {
		this.e = e;
	}

	
	public void execute(double deltaTime) {
	}

}

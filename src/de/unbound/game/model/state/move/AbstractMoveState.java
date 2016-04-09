package de.unbound.game.model.state.move;

import de.unbound.game.model.entities.mobile.MobileEntity;
import de.unbound.game.model.state.State;

public abstract class AbstractMoveState implements State{
	
	protected MobileEntity e;
	
	public AbstractMoveState(MobileEntity e) {
		this.e = e;
	}

}

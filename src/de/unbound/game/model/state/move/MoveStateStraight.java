package de.unbound.game.model.state.move;

import de.unbound.game.model.entities.mobile.MobileEntity;

public class MoveStateStraight extends AbstractMoveState {
	
	public MoveStateStraight(MobileEntity e) {
		super(e);
	}

	@Override
	public void update(double deltaTime) {
		//TODO Marwin mach mal
//		e.setVelocity(e.getVelocity().scl((float)(1+deltaTime)));
//		e.setPosition(e.getPosition().add(e.getVelocity()));
//		System.out.println(e.getPosition());
	}
}
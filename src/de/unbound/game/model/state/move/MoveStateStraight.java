package de.unbound.game.model.state.move;

import de.unbound.game.model.entities.mobile.MobileEntity;

public class MoveStateStraight extends AbstractMoveState {
	
	public MoveStateStraight(MobileEntity e) {
		super(e);
	}

	@Override
	public void update(double deltaTime) {

		float acceleration = (float)(e.getModel().getAcceleration()*deltaTime);
		float timeFractionOfASecond = (float)(deltaTime*60);
		
		e.setVelocity(e.getVelocity().cpy().add(e.getDirection().nor().scl(acceleration)));
		e.getVelocity().limit(e.getModel().getMaxVelocity()).scl(timeFractionOfASecond);
		e.setPosition(e.getPosition().cpy().add(e.getVelocity()));
	}
}
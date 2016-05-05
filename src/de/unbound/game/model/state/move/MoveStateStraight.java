package de.unbound.game.model.state.move;

import de.unbound.game.model.entities.Entity;

public class MoveStateStraight extends AbstractMoveState {
	
	public MoveStateStraight(Entity e) {
		super(e);
	}

	@Override
	public void update(double deltaTime) {

		float acceleration = (float)(e.getModel().getAcceleration()*deltaTime);
		float timeFractionOfASecond = (float)(deltaTime*60);
		
		velocity = velocity.cpy().add(e.getDirection().nor().scl(acceleration));
		velocity = velocity.limit(e.getModel().getMaxVelocity()).scl(timeFractionOfASecond);
		e.setPosition(e.getPosition().cpy().add(velocity));
	}
}
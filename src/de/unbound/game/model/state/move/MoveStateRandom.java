package de.unbound.game.model.state.move;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.entities.mobile.MobileEntity;

public class MoveStateRandom extends AbstractMoveState {
	
	public MoveStateRandom(MobileEntity e) {
		super(e);
	}

	@Override
	public void update(double deltaTime) {
		if (Math.random()>0.985) e.setDirection(new Vector2((float)(Math.random()-0.5D),(float) (Math.random()-0.5D)));
		
		float acceleration = (float)(e.getModel().getAcceleration()*deltaTime);
		
		e.setVelocity(e.getVelocity().cpy().add(e.getDirection().cpy().scl((float)(e.getModel().getAcceleration()*deltaTime))));

		e.getVelocity().limit(e.getModel().getMaxVelocity()).scl((float)(e.getModel().getAcceleration()*deltaTime));
				
		e.setPosition(e.getPosition().cpy().add(e.getVelocity()));
		


	}
}
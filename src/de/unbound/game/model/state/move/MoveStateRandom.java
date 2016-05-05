package de.unbound.game.model.state.move;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.entities.Entity;

public class MoveStateRandom extends AbstractMoveState {
	
	public MoveStateRandom(Entity e) {
		super(e);
	}

	@Override
	public void update(double deltaTime) {
		if (Math.random()>0.985) e.setDirection(new Vector2((float)(Math.random()-0.5D),(float) (Math.random()-0.5D)));
		
		float acceleration = (float)(e.getModel().getAcceleration()*deltaTime);
		
		velocity = velocity.cpy().add(e.getDirection().cpy().nor().scl(acceleration));
		velocity = velocity.limit(e.getModel().getMaxVelocity()).scl((float)(deltaTime*60));
		e.setPosition(e.getPosition().cpy().add(velocity));
		
//		e.setVelocity(e.getVelocity().cpy().add(e.getDirection().nor().scl(acceleration)));
//		e.getVelocity().limit(e.getModel().getMaxVelocity()).scl(acceleration);
//		e.setPosition(e.getPosition().cpy().add(e.getVelocity()));


	}
}
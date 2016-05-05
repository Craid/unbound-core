package de.unbound.game.model.state.move;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.entities.Entity;

public class MoveStateStraightSpinning extends AbstractMoveState {
	
	private Vector2 originalDirection; // wird zwischengespeichert
	
	public MoveStateStraightSpinning(Entity e) {
		super(e);
		originalDirection = e.getDirection().cpy();
	}

	@Override
	public void update(double deltaTime) {
		float acceleration = (float)(e.getModel().getAcceleration()*deltaTime);
		float timeFractionOfASecond = (float)(deltaTime*60);
		e.getDirection().rotate((float)(deltaTime*244.8));
		velocity = velocity.cpy().add(originalDirection.nor().scl(acceleration));
		velocity = velocity.limit(e.getModel().getMaxVelocity()).scl(timeFractionOfASecond);
		e.setPosition(e.getPosition().cpy().add(velocity));
	}
}
package de.unbound.game.model.state.move;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.entities.mobile.MobileEntity;

public class MoveStateStraightSpinning extends AbstractMoveState {
	
	private Vector2 originalDirection; // wird zwischengespeichert
	
	public MoveStateStraightSpinning(MobileEntity e) {
		super(e);
		originalDirection = e.getDirection().cpy();
	}

	@Override
	public void update(double deltaTime) {

		float acceleration = (float)(e.getModel().getAcceleration()*deltaTime);
		float timeFractionOfASecond = (float)(deltaTime*60);
		e.getDirection().rotate((float)(deltaTime*2444.8));
		e.setVelocity(e.getVelocity().cpy().add(originalDirection.nor().scl(acceleration)));
		e.getVelocity().limit(e.getModel().getMaxVelocity()).scl(timeFractionOfASecond);
		e.setPosition(e.getPosition().cpy().add(e.getVelocity()));
	}
}
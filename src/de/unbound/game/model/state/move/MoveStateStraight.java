package de.unbound.game.model.state.move;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.entities.mobile.MobileEntity;

public class MoveStateStraight extends AbstractMoveState {
	
	public MoveStateStraight(MobileEntity e) {
		super(e);
	}

	@Override
	public void update(double deltaTime) {
		//TODO Marwin mach mal
		e.setVelocity(new Vector2(0.1f,0));
		e.setDirection(e.getDirection().rotate(5));
		//		e.setVelocity(e.getVelocity().scl((float)(1+deltaTime)));
		e.setPosition(e.getPosition().add(e.getVelocity()));
//		System.out.println(e.getPosition());
	}
}
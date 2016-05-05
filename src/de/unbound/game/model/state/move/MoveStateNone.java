package de.unbound.game.model.state.move;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.entities.Entity;

public class MoveStateNone extends AbstractMoveState {

	public MoveStateNone(Entity e) {
		super(e);
		velocity = new Vector2(0,0);
	}

	@Override
	public void update(double deltaTime) {
		//Intentionally left blank
	}

}
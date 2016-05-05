package de.unbound.game.model.state.move;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.State;

public abstract class AbstractMoveState implements State{
	
	protected Entity e;
	protected Vector2 velocity;
	
	public AbstractMoveState(Entity e) {
		this.e = e;
		velocity = e.getDirection().cpy().limit(0.001f);
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}
	
	

}

package de.unbound.game.model.entities.mobile;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.collision.CollisionHandler;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.move.MoveState;
import de.unbound.game.model.state.move.Straight;

public abstract class MobileEntity extends Entity {

	private MoveState move;
	private Vector2 velocity;
	
	public MobileEntity(){
		move = new Straight();
		velocity = new Vector2();
	}

	
	// Getter und Setter
	
	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

}
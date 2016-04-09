package de.unbound.game.model.entities.mobile;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.attack.AttackStateStraight;
import de.unbound.game.model.state.move.AbstractMoveState;
import de.unbound.game.model.state.move.MoveStateStraight;

public abstract class MobileEntity extends Entity {

	private AbstractMoveState move;
	private Vector2 velocity;
	
	public MobileEntity(){
		setAttack(new AttackStateStraight(this));
		move = new MoveStateStraight(this); // Maus überarbeitet werden in singleton 
		velocity = new Vector2();
	}
	
	@Override
	public void update(double deltaTime){
		getAttack().execute(deltaTime);
		move.execute(deltaTime);
	}
	
	public void updateMoveState(){
		
	}

	
	// Getter und Setter
	
	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public AbstractMoveState getMove() {
		return move;
	}

	public void setMove(AbstractMoveState move) {
		this.move = move;
	}

}
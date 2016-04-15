package de.unbound.game.model.entities.mobile;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.attack.AttackStateStraight;
import de.unbound.game.model.state.move.AbstractMoveState;
import de.unbound.game.model.state.move.MoveStateWave;
import de.unbound.utility.UnboundConstants;

public abstract class MobileEntity extends Entity {

	private AbstractMoveState move;
	private Vector2 velocity;
	
	public MobileEntity(){
		super();
		setAttack(new AttackStateStraight(this));
		setPosition(new Vector2(UnboundConstants.WORLDWIDTH/2,UnboundConstants.WORLDHEIGHT-2*UnboundConstants.SINGLEGRIDHEIGHT));
		move = new MoveStateWave(this); // Maus überarbeitet werden in singleton 
		velocity = new Vector2();
	}
	
	@Override
	public void update(double deltaTime){
		getAttack().update(deltaTime);
		move.update(deltaTime);
			
	//	if (Math.random()>0.999) setMove(new MoveStateWaveViolent(this)); // experimental, limit rausgeholt
	//	if (Math.random()>0.9) setMove(new MoveStateTarget(this)); //limit rausgeholt, tests
	//	if (Math.random()>0.999) setMove(new MoveStateWave(this));
	//	if (Math.random()>0.999) setMove(new MoveStateStraightSpinning(this));
	//	if (Math.random()>0.999) setMove(new MoveStateStraight(this));
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
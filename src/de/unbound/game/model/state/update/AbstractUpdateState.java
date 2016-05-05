package de.unbound.game.model.state.update;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.State;
import de.unbound.game.model.state.attack.AbstractAttackState;
import de.unbound.game.model.state.move.AbstractMoveState;

public abstract class AbstractUpdateState implements State{
	
	protected Entity e;
	protected AbstractAttackState attack;
	protected AbstractMoveState move;

	public AbstractUpdateState(Entity e) {
		this.e = e;
	}
	
	public void update(double deltaTime){
		attack.update(deltaTime);
		move.update(deltaTime);
	}

	public void takeDamage(double hp) {
		e.setHp(e.getHp() - hp);
		if(e.getHp() <= 0){
			e.setActive(false);
//			if(e.isHostile())
//				BattleField.getBattleField().addScore(100);
		}
	}

	
	public AbstractAttackState getAttack() {
		return attack;
	}

	public void setAttack(AbstractAttackState attack) {
		this.attack = attack;
	}

	public AbstractMoveState getMove() {
		return move;
	}

	public void setMove(AbstractMoveState move) {
		this.move = move;
	}

}

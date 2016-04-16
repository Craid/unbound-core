package de.unbound.game.model.entities.mobile;

import de.unbound.game.model.state.attack.AttackStateNone;
import de.unbound.game.model.state.move.MoveStateStraightSpinning;

public abstract class Projectile extends MobileEntity {
	
	private int damage;
	
	public Projectile(){
		super();
		setAttack(new AttackStateNone(this));
		setMove(new MoveStateStraightSpinning(this));
		damage = 100;
		setHp(8);
	}
	
	public void update(double deltaTime){
		getMove().update(deltaTime);
		takeDamage(deltaTime);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
}
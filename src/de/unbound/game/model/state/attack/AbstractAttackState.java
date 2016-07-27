package de.unbound.game.model.state.attack;

import de.unbound.game.BattleField;
import de.unbound.game.factories.ProjectileBuilder;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.State;

public abstract class AbstractAttackState implements State{

	protected double lastTimeSinceEntityShot;
	protected Entity e;
	
	public AbstractAttackState(Entity e){
		this.e = e;
		lastTimeSinceEntityShot = 0;
	}
	
	protected Entity createBullet() {
		Entity p = ProjectileBuilder.getInstance().createProjectile(e);
		BattleField.getInstance().add(p);
		return p;
	}

}
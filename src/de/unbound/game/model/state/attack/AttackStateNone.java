package de.unbound.game.model.state.attack;

import de.unbound.game.model.entities.Entity;

public class AttackStateNone extends AbstractAttackState {

	public AttackStateNone(Entity e) {
		super(e);
	}

	@Override
	public void update(double deltaTime) {
		//Intentionally left blank!
	}

}
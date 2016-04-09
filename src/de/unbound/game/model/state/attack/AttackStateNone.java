package de.unbound.game.model.state.attack;

import de.unbound.game.model.entities.Entity;

public class AttackStateNone extends AbstractAttackState {

	public AttackStateNone(Entity e) {
		super(e);
	}

	@Override
	public void execute(double deltaTime) {
//		System.out.println("Doing noithing");
		//System.out.println("E.Class" + e.getClass());
		//Intentionally left blank!
	}

}
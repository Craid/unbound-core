package de.unbound.game.model.state.attack;

import de.unbound.game.model.entities.Entity;

public class AttackStateTarget extends AbstractAttackState {
	
	private Entity target;
	
	public AttackStateTarget(Entity entity, Entity target) {
		super(entity);
	}
	
	@Override
	public void execute(double deltaTime) {
		// TODO Auto-generated method stub
	}
	
	public void setTarget(Entity target){
		this.target = target;
	}
}
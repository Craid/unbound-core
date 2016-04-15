package de.unbound.game.model.state.attack;

import de.unbound.game.BattleField;
import de.unbound.game.factories.ProjectileBuilder;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.mobile.Projectile;

public class AttackStateStraight extends AbstractAttackState {
	
	private double lastTimeSinceEntityShot;
	
	public AttackStateStraight(Entity e) {
		super(e);
		lastTimeSinceEntityShot = 0;
	}
	
	@Override
	public void update(double deltaTime) {
		lastTimeSinceEntityShot += deltaTime;
		if(lastTimeSinceEntityShot > 5){
			BattleField.getBattleField().add(createBullet());
			lastTimeSinceEntityShot = 0;
		}
	}
	
	private Projectile createBullet() {
		return ProjectileBuilder.getInstance().createProjectile(e);
	}

}
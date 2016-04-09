package de.unbound.game.model.state.attack;

import de.unbound.game.BattleField;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.mobile.Projectile;
import de.unbound.game.model.entities.mobile.ducks.DuckProjectile;
import de.unbound.game.model.entities.mobile.prelates.PrelateProjectile;

public class AttackStateStraight extends AbstractAttackState {
	
	private double lastTimeSinceEntityShot;
	
	public AttackStateStraight(Entity e) {
		super(e);
		lastTimeSinceEntityShot = 0;
	}
	
	@Override
	public void execute(double deltaTime) {
		lastTimeSinceEntityShot += deltaTime;
		if(lastTimeSinceEntityShot > 5){
			BattleField.getBattleField().add(createBullet());
			lastTimeSinceEntityShot = 0;
		}
	}
	
	private Projectile createBullet() {
		Projectile p = null;
		
		switch(e.getClass().getSimpleName().substring(0, 3)){
		case "Pre": p = new PrelateProjectile(); break;
		case "Duc": p = new DuckProjectile(); break;
		}
		
		p.setDirection(e.getDirection());
		p.setPosition(e.getPosition());
		p.setHostile(e.isHostile());
		return p;
	}

}
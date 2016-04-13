package de.unbound.game.model.state.attack;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.BattleField;
import de.unbound.game.factories.RaceDuckFactory;
import de.unbound.game.factories.RacePrelateFactory;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.mobile.Projectile;
import de.unbound.game.model.state.move.MoveStateStraightSpinning;

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
		Projectile p = null;
		
		switch(e.getClass().getSimpleName().substring(0, 3)){
		case "Pre": p = RacePrelateFactory.getRacePrelateFactory().createProjectile() ; break;
		case "Duc": p = RaceDuckFactory.getRaceDuckFactory().createProjectile(); break;
		}
		
		p.setDirection(e.getDirection().cpy());
		p.setPosition(e.getPosition().cpy());
		p.setMove(new MoveStateStraightSpinning(p));
		p.setHostile(e.isHostile());
		return p;
	}

}
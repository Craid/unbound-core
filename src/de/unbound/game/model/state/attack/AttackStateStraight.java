package de.unbound.game.model.state.attack;

import de.unbound.game.BattleField;
import de.unbound.game.model.entities.Entity;
import de.unbound.utility.UnboundConstants;

public class AttackStateStraight extends AbstractAttackState {
	
	
	public AttackStateStraight(Entity e) {
		super(e);
	}
	
	@Override
	public void update(double deltaTime) {
		lastTimeSinceEntityShot += deltaTime;
		if(lastTimeSinceEntityShot > UnboundConstants.SHOTSPEED){
			BattleField.getBattleField().add(createBullet());
			lastTimeSinceEntityShot = 0;
		}
	}
	


}
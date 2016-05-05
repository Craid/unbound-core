package de.unbound.game.model.state.update;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.attack.AttackStateStraight;
import de.unbound.game.model.state.move.MoveStateControlled;
import de.unbound.utility.UnboundConstants;

public class UpdateStatePlayer extends AbstractUpdateState{
	
	public UpdateStatePlayer(Entity e) {
		super(e);
		attack = new AttackStateStraight(e);
		move = new MoveStateControlled(e);
	}

	@Override
	public void update(double deltaTime) {
		attack.update(deltaTime);
		move.update(deltaTime);
		if(!e.isActive())
			respawn();
	}

	private void respawn() {
		e.setActive(true);
		e.setHp(500);
		e.setPosition(new Vector2(UnboundConstants.WORLDWIDTH/2,UnboundConstants.SINGLEGRIDHEIGHT/10));
		e.setDirection(new Vector2(0,1));
//		BattleField.getBattleField().addScore(-500);
	}

}

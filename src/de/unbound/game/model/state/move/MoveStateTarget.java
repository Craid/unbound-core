package de.unbound.game.model.state.move;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.BattleField;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.mobile.MobileEntity;

public class MoveStateTarget extends AbstractMoveState {

	Vector2 targetDirection;
	Entity target;
	
	public MoveStateTarget(MobileEntity e, Entity target) {
		this(e);

		//this.target = target;
		// TODO Auto-generated constructor stub
	}
	
	public MoveStateTarget(MobileEntity e) {
		super(e);
		// TODO Auto-generated constructor stub
		this.target = BattleField.getBattleField().getPlayer();
	}

	@Override
	public void update(double deltaTime) {

		//targetDirection = new Vector2(e.getPosition().cpy().sub(target.getPosition()));
		targetDirection = new Vector2(target.getPosition().cpy().sub(e.getPosition()));
		e.setDirection(targetDirection);
		float acceleration = (float)(e.getModel().getAcceleration()*deltaTime);
		float timeFractionOfASecond = (float)(deltaTime*60);
		
		e.setVelocity(e.getVelocity().cpy().add(e.getDirection().nor().scl(acceleration)));
		//e.getVelocity().limit(e.getModel().getMaxVelocity()).scl(timeFractionOfASecond);
		e.setPosition(e.getPosition().cpy().add(e.getVelocity()));
		
	}

}

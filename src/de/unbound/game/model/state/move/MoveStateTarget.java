package de.unbound.game.model.state.move;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.entities.Entity;

public class MoveStateTarget extends AbstractMoveState {

	Vector2 targetDirection;
	Entity target;

	public MoveStateTarget(Entity e, Entity target) {
		this(e);
		this.target = target;
	}

	private MoveStateTarget(Entity e) {
		super(e);
	}

	@Override
	public void update(double deltaTime) {

		if (target != null || !target.isActive()) {
			targetDirection = new Vector2(target.getPosition().cpy().sub(e.getPosition()));
			e.setDirection(targetDirection);
			float acceleration = (float) (e.getModel().getAcceleration() * deltaTime);
			float timeFractionOfASecond = (float) (deltaTime * 60);

			velocity = velocity.cpy().add(e.getDirection().nor().scl(acceleration));
			velocity = velocity.limit(e.getModel().getMaxVelocity()).scl(timeFractionOfASecond);
			e.setPosition(e.getPosition().cpy().add(velocity));
		} else {
			// tja, erstmal nichts, muss getestet werden
		}
	}

}

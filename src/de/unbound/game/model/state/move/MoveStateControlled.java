package de.unbound.game.model.state.move;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import de.unbound.game.model.entities.Entity;

public class MoveStateControlled extends AbstractMoveState {

	public final float turnSpeed = 12.5f;
	public boolean standingStill;
	public boolean up, down, left, right;

	public MoveStateControlled(Entity e) {
		super(e);
		standingStill = false;
	}

	@Override
	public void update(double deltaTime) {

		if (up = isUpCommandActivated())
			e.getDirection().add(0, turnSpeed * (float) deltaTime);

		if (down = isDownCommandActivated())
			e.getDirection().add(0, -turnSpeed * (float) deltaTime);

		if (left = isLeftCommandActivated())
			e.getDirection().add(-turnSpeed * (float) deltaTime, 0);

		if (right = isRightCommandActivated())
			e.getDirection().add(turnSpeed * (float) deltaTime, 0);

		e.getDirection().nor();
		if (left | right | up | down) {
			float acceleration = (float) (e.getModel().getAcceleration() * deltaTime);
			float timeFractionOfASecond = (float) (deltaTime * 60);

			velocity = velocity.cpy().add(e.getDirection().nor().scl(acceleration));
			velocity = velocity.limit(e.getModel().getMaxVelocity())
					.scl(timeFractionOfASecond);
		} else {
			velocity = velocity.scl(0.98f);
			e.getDirection().scl(0.98f);
		}
		e.setPosition(e.getPosition().cpy().add(velocity));
	}

	private boolean isRightCommandActivated() {
		return Gdx.input.isKeyPressed(Input.Keys.RIGHT)
				|| Gdx.input.isKeyPressed(Input.Keys.D);
	}

	private boolean isLeftCommandActivated() {
		return Gdx.input.isKeyPressed(Input.Keys.LEFT)
				|| Gdx.input.isKeyPressed(Input.Keys.A);
	}

	private boolean isDownCommandActivated() {
		return Gdx.input.isKeyPressed(Input.Keys.DOWN)
				|| Gdx.input.isKeyPressed(Input.Keys.S);
	}

	private boolean isUpCommandActivated() {
		return Gdx.input.isKeyPressed(Input.Keys.UP)
				|| Gdx.input.isKeyPressed(Input.Keys.W);
	}
}
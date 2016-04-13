package de.unbound.game.model.state.move;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import de.unbound.game.model.entities.mobile.MobileEntity;

public class MoveStateControlled extends AbstractMoveState {

	public final float turnSpeed = 0.2f;
	public boolean standingStill;
	public boolean up,down,left,right;

	public MoveStateControlled(MobileEntity e) {
		super(e);
		standingStill = false;
	}

	@Override
	public void update(double deltaTime) {
		
		if (Gdx.input.isKeyPressed(Input.Keys.UP)|| Gdx.input.isKeyPressed(Input.Keys.W)) {
			e.getDirection().add(0,turnSpeed);
			up = true;
		} else {
			up = false;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)|| Gdx.input.isKeyPressed(Input.Keys.S)) {
			e.getDirection().add(0,-turnSpeed);
			down = true;
		} else {
			down = false;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)|| Gdx.input.isKeyPressed(Input.Keys.A)) {
			e.getDirection().add(-turnSpeed,0);
			left = true;
		} else {
			left = false;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)|| Gdx.input.isKeyPressed(Input.Keys.D)) {
			e.getDirection().add(turnSpeed,0);
			right = true;
		} else {
			right = false;
		}
		e.getDirection().nor();
			if (left|right|up|down){
			float acceleration = (float)(e.getModel().getAcceleration()*deltaTime);
			float timeFractionOfASecond = (float)(deltaTime*60);
		
			e.setVelocity(e.getVelocity().cpy().add(e.getDirection().nor().scl(acceleration)));
			e.getVelocity().limit(e.getModel().getMaxVelocity()).scl(timeFractionOfASecond);
		} else {
			e.getVelocity().scl(0.98f);
			e.getDirection().scl(0.98f);
		}
		e.setPosition(e.getPosition().cpy().add(e.getVelocity()));
	}
}
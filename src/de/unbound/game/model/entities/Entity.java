package de.unbound.game.model.entities;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.FlyweightModel;
import de.unbound.game.model.state.attack.AttackState;
import de.unbound.game.model.state.attack.None;

public abstract class Entity {

	private AttackState attack;
	private Vector2 position;
	private Vector2 direction;
	private boolean active;
	private FlyweightModel model;
	
	public Entity(){
		attack = new None();
		position = new Vector2();
		direction = new Vector2();
		active = true;
	}

	/**
	 * 
	 * @param deltaTime
	 */
	public abstract void update(double deltaTime);

	public abstract void render();

	public Vector2 getPosition() {
		return position;
	}

	/**
	 * 
	 * @param x
	 */
	public void setPosition(Vector2 newPosition) {
		this.position = newPosition;
	}
	
	public Vector2 getDirection() {
		return direction;
	}

	public void setDirection(Vector2 direction) {
		this.direction = direction;
	}


	public boolean getActive() {
		return this.active;
	}

	/**
	 * 
	 * @param active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	public AttackState getAttack() {
		return attack;
	}

	public void setAttack(AttackState attack) {
		this.attack = attack;
	}

	public FlyweightModel getModel() {
		return model;
	}

	public void setModel(FlyweightModel model) {
		this.model = model;
	}

}
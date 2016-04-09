package de.unbound.game.model.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.EntityFlyweight;
import de.unbound.game.model.state.attack.AbstractAttackState;
import de.unbound.game.model.state.attack.AttackStateNone;

public abstract class Entity {

	private AbstractAttackState attack;
	private Vector2 position;
	private Vector2 direction;
	private boolean active;
	private EntityFlyweight model;
	private boolean hostile;
	private double hp;

	public Entity(){
		attack = new AttackStateNone(this);
		position = new Vector2();
		direction = new Vector2();
		active = true;
		hostile = false;
		setHp(0);
	}

	/**
	 * 
	 * @param deltaTime
	 */
	public void update(double deltaTime){
		attack.execute(deltaTime);
	}

	public void render(SpriteBatch batch){
		Sprite sprite = model.getGraphic();
		sprite.setPosition(position.x, position.y);
		sprite.setRotation(direction.angle());
		sprite.draw(batch);
	}

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

	public AbstractAttackState getAttack() {
		return attack;
	}

	public void setAttack(AbstractAttackState attack) {
		this.attack = attack;
	}

	public EntityFlyweight getModel() {
		return model;
	}

	public void setModel(EntityFlyweight model) {
		this.model = model;
	}
	
	public boolean isHostile() {
		return hostile;
	}

	public void setHostile(boolean hostile) {
		this.hostile = hostile;
	}

	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}
	
}
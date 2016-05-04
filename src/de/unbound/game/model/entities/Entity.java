package de.unbound.game.model.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import de.unbound.game.BattleField;
import de.unbound.game.GameCamera;
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
		direction = new Vector2(0,1);
		active = true;
		hostile = false;
		setHp(1);
	}

	/**
	 * 
	 * @param deltaTime
	 */
	public void update(double deltaTime){
		attack.update(deltaTime);
	}

	public void render(SpriteBatch batch){
		Sprite sprite = model.getGraphic();
		sprite.setPosition(position.x-(sprite.getWidth()/2), position.y-(sprite.getHeight()/2));
		sprite.setRotation(direction.angle());
		if(GameCamera.getGameCamera().frustum.sphereInFrustum(new Vector3(position.x, position.y, 0), (float)model.getRangeofCollision() ) )
			sprite.draw(batch);
	}
	
	public void takeDamage(double hp) {
		setHp(this.hp - hp);
		if(getHp() <= 0){
			setActive(false);
			if(isHostile())
				BattleField.getBattleField().addScore(100);
		}
	}
	
	//Getters and Setters

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


	public boolean isActive() {
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
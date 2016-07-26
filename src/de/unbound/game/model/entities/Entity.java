package de.unbound.game.model.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import de.unbound.game.BattleField;
import de.unbound.game.GameCamera;
import de.unbound.game.model.state.update.AbstractUpdateState;

public class Entity{

	private AbstractUpdateState updateState;
	private Vector2 position;
	private Vector2 direction;
	private boolean active;
	private EntityFlyweight model;
	private boolean hostile;
	private double hp;

	public Entity(){
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
		updateState.update(deltaTime);
	}

	public void render(SpriteBatch batch){
		Sprite sprite = model.getGraphic();
		sprite.setPosition(position.x-(sprite.getWidth()/2), position.y-(sprite.getHeight()/2));
		sprite.setRotation(direction.angle());
		if(GameCamera.getGameCamera().frustum.sphereInFrustum(new Vector3(position.x, position.y, 0), (float)model.getRangeOfCollision() ) )
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

	public AbstractUpdateState getUpdateState() {
		return updateState;
	}

	public void setUpdateState(AbstractUpdateState updateState) {
		this.updateState = updateState;
	}
	
	public boolean isImmobile(){
		String temp = model.getTextureName();
		return temp.contains("Tower") || temp.contains("Deposit") || temp.contains("MainBase") || temp.contains("Spawner");
	}
}
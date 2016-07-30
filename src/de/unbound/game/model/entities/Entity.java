package de.unbound.game.model.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import de.unbound.game.World;
import de.unbound.game.model.state.update.AbstractUpdateState;

public class Entity{

	private AbstractUpdateState updateState;
	private Vector2 position;
	private Vector2 direction;
	private boolean active;
	private EntityFlyweight model;
	private boolean hostile;
	private double hp;
	private int id;

	public Entity(){
		id = -1;
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
		World.getInstance().getGameUpdate().renderEntity(this);
	}
	
	public void takeDamage(double hp) {
		setHp(this.hp - hp);
		if(getHp() <= 0){
			setActive(false);
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isImmobile(){
		String temp = model.getTextureName();
		return temp.contains("Tower") || temp.contains("Deposit") || temp.contains("MainBase") || temp.contains("Spawner");
	}
	
	public String getTextureName(){
		return getModel().getTextureName();
	}
	
}
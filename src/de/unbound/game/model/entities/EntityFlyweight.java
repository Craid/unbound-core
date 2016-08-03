package de.unbound.game.model.entities;

import java.io.Serializable;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class EntityFlyweight {

	private EntityFlyweightMeta meta;
	private Sprite graphic;
	
	public EntityFlyweightMeta getMeta(){
		return meta;
	}
	
	public void setMeta(EntityFlyweightMeta model){
		this.meta = model;
	}
	
	public void setGraphic(Sprite graphic) {
		this.graphic = graphic;
	}
	
	public Sprite getGraphic(){
		return graphic;
	}
	
	public byte getId(){
		return meta.id;
	}
	
	public float getRangeOfVision() {
		return meta.rangeOfVision;
	}

	public float getRangeOfCollision() {
		return meta.rangeOfCollision;
	}

	public String getTextureName() {
		return meta.textureName;
	}

	public float getAcceleration() {
		return meta.acceleration;
	}

	public float getMaxVelocity() {
		return meta.maxVelocity;
	}

	public float getDamageOnContact() {
		return meta.damageOnContact;
	}

	public int getInitialHP() {
		return meta.initialHP;
	}
	
	public static class EntityFlyweightMeta implements Serializable{
		
		private static final long serialVersionUID = 1L;
		
		private float rangeOfVision, rangeOfCollision, damageOnContact;
		private float acceleration, maxVelocity;
		private int initialHP;
		private byte id;
		private String textureName;
		
		public EntityFlyweightMeta(){}
		
		public EntityFlyweightMeta(byte id,float rangeOfVision, float rangeOfCollision, String textureName, float accelaration, float maxVelocity, float damage, int initialHP){
			setId(id);
			setRangeOfCollision(rangeOfCollision);
			setRangeOfVision(rangeOfVision);
			setTextureName(textureName);
			setAcceleration(accelaration);
			setMaxVelocity(maxVelocity);
			setDamageOnContact(damage);
			setInitialHP(initialHP);
		}

		public byte getId() {
			return id;
		}

		public void setId(byte id) {
			this.id = id;
		}

		public float getRangeOfVision() {
			return rangeOfVision;
		}

		public void setRangeOfVision(float rangeOfVision) {
			this.rangeOfVision = rangeOfVision;
		}

		public float getRangeOfCollision() {
			return rangeOfCollision;
		}

		public void setRangeOfCollision(float rangeOfCollision) {
			this.rangeOfCollision = rangeOfCollision;
		}

		public String getTextureName() {
			return textureName;
		}

		public void setTextureName(String textureName) {
			this.textureName = textureName;
		}

		public float getAcceleration() {
			return acceleration;
		}

		public void setAcceleration(float acceleration) {
			this.acceleration = acceleration;
		}

		public float getMaxVelocity() {
			return maxVelocity;
		}

		public void setMaxVelocity(float maxVelocity) {
			this.maxVelocity = maxVelocity;
		}

		public float getDamageOnContact() {
			return damageOnContact;
		}

		public void setDamageOnContact(float damageOnContact) {
			this.damageOnContact = damageOnContact;
		}

		public int getInitialHP() {
			return initialHP;
		}

		public void setInitialHP(int initialHP) {
			this.initialHP = initialHP;
		}
	}
	
}

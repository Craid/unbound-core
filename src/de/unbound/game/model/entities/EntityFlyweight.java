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
	
	public double getRangeOfVision() {
		return meta.rangeOfVision;
	}

	public void setRangeOfVision(double rangeOfVision) {
		meta.rangeOfVision = rangeOfVision;
	}

	public double getRangeOfCollision() {
		return meta.rangeOfCollision;
	}

	public void setRangeOfCollision(double rangeOfCollision) {
		meta.rangeOfCollision = rangeOfCollision;
	}

	public int getUpgrades() {
		return meta.upgrades;
	}

	public void setUpgrades(int upgrades) {
		meta.upgrades = upgrades;
	}

	public String getTextureName() {
		return meta.textureName;
	}

	public void setTextureName(String textureName) {
		meta.textureName = textureName;
	}

	public float getAcceleration() {
		return meta.acceleration;
	}

	public void setAcceleration(float acceleration) {
		meta.acceleration = acceleration;
	}

	public float getMaxVelocity() {
		return meta.maxVelocity;
	}

	public void setMaxVelocity(float maxVelocity) {
		meta.maxVelocity = maxVelocity;
	}

	public double getDamageOnContact() {
		return meta.damageOnContact;
	}

	public void setDamageOnContact(double damageOnContact) {
		meta.damageOnContact = damageOnContact;
	}
	
	public int getInitialHP() {
		return meta.initialHP;
	}

	public void setInitialHP(int initialHP) {
		meta.initialHP = initialHP;
	}
	
	public static class EntityFlyweightMeta implements Serializable{
		
		private static final long serialVersionUID = 1L;
		
		private double rangeOfVision, rangeOfCollision, damageOnContact;
		private float acceleration, maxVelocity;
		private int upgrades, initialHP;
		private String textureName;
		
		public EntityFlyweightMeta(){}
		
		public EntityFlyweightMeta(double rangeOfVision, double rangeOfCollision, int upgrades, String textureName, float accelaration, float maxVelocity, double damage, int initialHP){
			setRangeOfCollision(rangeOfCollision);
			setRangeOfVision(rangeOfVision);
			setUpgrades(upgrades);
			setTextureName(textureName);
			setAcceleration(accelaration);
			setMaxVelocity(maxVelocity);
			setDamageOnContact(damage);
			setInitialHP(initialHP);
		}

		public double getRangeOfVision() {
			return rangeOfVision;
		}

		public void setRangeOfVision(double rangeOfVision) {
			this.rangeOfVision = rangeOfVision;
		}

		public double getRangeOfCollision() {
			return rangeOfCollision;
		}

		public void setRangeOfCollision(double rangeOfCollision) {
			this.rangeOfCollision = rangeOfCollision;
		}

		public int getUpgrades() {
			return upgrades;
		}

		public void setUpgrades(int upgrades) {
			this.upgrades = upgrades;
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

		public double getDamageOnContact() {
			return damageOnContact;
		}

		public void setDamageOnContact(double damageOnContact) {
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

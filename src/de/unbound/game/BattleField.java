package de.unbound.game;

import java.util.ArrayList;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.immobile.ImmobileEntity;
import de.unbound.game.model.entities.immobile.MainBase;
import de.unbound.game.model.entities.mobile.Collector;
import de.unbound.game.model.entities.mobile.MobileEntity;
import de.unbound.game.model.entities.mobile.Player;
import de.unbound.game.model.entities.mobile.Projectile;

public class BattleField {

	private Player player;
	private MainBase mainBase;
	private ArrayList<Projectile> projectiles;
	private ArrayList<MobileEntity> enemies;
	private ArrayList<Collector> collectors;
	private ArrayList<ImmobileEntity> immobileEntities;
	public BattleField battleField;

	private BattleField() {
	}

	public void init() {
		// TODO - implement BattleField.init
		throw new UnsupportedOperationException();
	}

	public void updateQuadTree() {
		// TODO - implement BattleField.updateQuadTree
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * 
	 * @param mainBase
	 */
	public void setMainBase(MainBase mainBase) {
		this.mainBase = mainBase;
	}

	/**
	 * 
	 * @param waveEntities
	 */
	public void addWave(ArrayList<MobileEntity> waveEntities) {
		// TODO - implement BattleField.addWave
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param projectile
	 */
	public void addProjectile(Projectile projectile) {
		// TODO - implement BattleField.addProjectile
		throw new UnsupportedOperationException();
	}

	public void addCollector() {
		// TODO - implement BattleField.addCollector
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param immobileEntity
	 */
	public void addImmobileEntity(ImmobileEntity immobileEntity) {
		// TODO - implement BattleField.addImmobileEntity
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param entity
	 */
	public void remove(Entity entity) {
		// TODO - implement BattleField.remove
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param projectile
	 */
	private void remove(Projectile projectile) {
		// TODO - implement BattleField.remove
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param enemy
	 */
	private void remove(MobileEntity enemy) {
		// TODO - implement BattleField.remove
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param collectors
	 */
	private void remove(Collector collectors) {
		// TODO - implement BattleField.remove
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param immobileEntity
	 */
	private void remove(ImmobileEntity immobileEntity) {
		// TODO - implement BattleField.remove
		throw new UnsupportedOperationException();
	}

}
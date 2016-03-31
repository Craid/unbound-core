package de.unbound.game.collision;

import java.util.ArrayList;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.immobile.ImmobileEntity;
import de.unbound.game.model.entities.immobile.MainBase;
import de.unbound.game.model.entities.mobile.Collector;
import de.unbound.game.model.entities.mobile.MobileEntity;
import de.unbound.game.model.entities.mobile.Player;
import de.unbound.game.model.entities.mobile.Projectile;

public class CollisionDetection {

	private Player player;
	private ArrayList<Projectile> bullets;
	private ArrayList<MobileEntity> enemies;
	private ArrayList<Collector> collectors;
	private ArrayList<ImmobileEntity> immobileEntites;
	Entity n;
	private MainBase mainBase;

	public CollisionDetection() {
		// TODO - implement CollisionDetection.CollisionDetection
		throw new UnsupportedOperationException();
	}

	public void init() {
		// TODO - implement CollisionDetection.init
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param deltaTime
	 */
	public void update(double deltaTime) {
		// TODO - implement CollisionDetection.update
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param waveEntites
	 */
	public void addWave(ArrayList<MobileEntity> waveEntites) {
		// TODO - implement CollisionDetection.addWave
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param bullet
	 */
	public void add(Projectile bullet) {
		// TODO - implement CollisionDetection.add
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param enemyEntity
	 */
	private void add(de.unbound.game.model.entities.mobile.MobileEntity enemyEntity) {
		// TODO - implement CollisionDetection.add
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param collector
	 */
	public void add(Collector collector) {
		// TODO - implement CollisionDetection.add
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param immobileEntity
	 */
	public void add(ImmobileEntity immobileEntity) {
		// TODO - implement CollisionDetection.add
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param player
	 */
	private void add(Player player) {
		// TODO - implement CollisionDetection.add
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param bullet
	 */
	private void remove(Projectile bullet) {
		// TODO - implement CollisionDetection.remove
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param enemyEntity
	 */
	private void remove(de.unbound.game.model.entities.mobile.MobileEntity enemyEntity) {
		// TODO - implement CollisionDetection.remove
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param collector
	 */
	private void remove(Collector collector) {
		// TODO - implement CollisionDetection.remove
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param immobileEntity
	 */
	public void remove(ImmobileEntity immobileEntity) {
		// TODO - implement CollisionDetection.remove
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param mainBase
	 */
	private void add(MainBase mainBase) {
		// TODO - implement CollisionDetection.add
		throw new UnsupportedOperationException();
	}

}
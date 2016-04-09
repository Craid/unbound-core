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
	private ArrayList<Projectile> enemyProjectiles;
	private ArrayList<Projectile> friendlyProjectiles;
	private ArrayList<MobileEntity> enemies;
	private ArrayList<Collector> collectors;
	private ArrayList<ImmobileEntity> immobileEntities;
	private ArrayList<Entity> entitiesForNextUpdate; // Alle Entitäten auf dem Battlefield!
	private ArrayList<Entity> gameObjects; // Alle Entitäten auf dem Battlefield!
	private static BattleField battleField;

	private BattleField() {
		init();
	}
	
	
	
	public void update(double deltaTime) {
		//test
//		for (Entity e : entitiesForNextUpdate){
//			gameObjects.add(e);
//		}
		gameObjects.addAll(entitiesForNextUpdate);
	}	
	
	

	public static void setBattleField(BattleField battleField) {
		BattleField.battleField = battleField;
	}

	public static BattleField getBattleField(){
		if(battleField == null)
			battleField = new BattleField();
		return battleField;
	}

	public void init() {
		// Selektive Listen
		enemyProjectiles = new ArrayList<Projectile>();
		friendlyProjectiles = new ArrayList<Projectile>();
		enemies = new ArrayList<MobileEntity>();
		collectors = new ArrayList<Collector>();
		immobileEntities = new ArrayList<ImmobileEntity>();
		// Liste für alle Game Objects
		entitiesForNextUpdate = new ArrayList<Entity>();
		gameObjects = new ArrayList<Entity>();
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
		for(MobileEntity e : waveEntities)
			add(e);
	}
	
	// Add Commands
	public void add(Projectile projectile) {  
		if (projectile.isHostile()) enemyProjectiles.add(projectile); //Wenn feindlich...
		else friendlyProjectiles.add(projectile); // wenn freundlich...
		entitiesForNextUpdate.add(projectile); // 
	}
	
	public void add(MobileEntity mobileEntity) {
		enemies.add(mobileEntity); 
		entitiesForNextUpdate.add(mobileEntity);
	}
	
	public void add(Collector collector) {
		collectors.add(collector); 
		entitiesForNextUpdate.add(collector);
	}
	
	public void add(ImmobileEntity immobileEntity) {
		immobileEntities.add(immobileEntity); 
		entitiesForNextUpdate.add(immobileEntity);
	}

	/**
	 * 
	 * @param immobileEntity
	 */
	public void addImmobileEntity(ImmobileEntity immobileEntity) {
		
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param entity
	 */
	public void remove(Entity entity) {
		
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param projectile
	 */
	private void remove(Projectile projectile) {
		
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param enemy
	 */
	private void remove(MobileEntity enemy) {
		
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param collectors
	 */
	private void remove(Collector collectors) {
		
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param immobileEntity
	 */
	private void remove(ImmobileEntity immobileEntity) {
		
		throw new UnsupportedOperationException();
	}


	public void setEnemyProjectiles(ArrayList<Projectile> enemyProjectiles) {
		this.enemyProjectiles = enemyProjectiles;
	}

	public ArrayList<Projectile> getFriendlyProjectiles() {
		return friendlyProjectiles;
	}

	public void setFriendlyProjectiles(ArrayList<Projectile> friendlyProjectiles) {
		this.friendlyProjectiles = friendlyProjectiles;
	}

	public ArrayList<MobileEntity> getEnemies() {
		return enemies;
	}

	public void setEnemies(ArrayList<MobileEntity> enemies) {
		this.enemies = enemies;
	}

	public ArrayList<Collector> getCollectors() {
		return collectors;
	}

	public void setCollectors(ArrayList<Collector> collectors) {
		this.collectors = collectors;
	}

	public ArrayList<ImmobileEntity> getImmobileEntities() {
		return immobileEntities;
	}

	public void setImmobileEntities(ArrayList<ImmobileEntity> immobileEntities) {
		this.immobileEntities = immobileEntities;
	}

	public ArrayList<Entity> getGameObjects() {
		return gameObjects;
	}

	public void setGameObjects(ArrayList<Entity> gameObjects) {
		this.gameObjects = gameObjects;
	}

	public Player getPlayer() {
		return player;
	}

	public MainBase getMainBase() {
		return mainBase;
	}
	public ArrayList<Projectile> getEnemyProjectiles() {
		return enemyProjectiles;
	}
	public ArrayList<Entity> getEntitiesForNextUpdate() {
		return entitiesForNextUpdate;
	}

	public void setEntitiesForNextUpdate(ArrayList<Entity> entitiesForNextUpdate) {
		this.entitiesForNextUpdate = entitiesForNextUpdate;
	}

}
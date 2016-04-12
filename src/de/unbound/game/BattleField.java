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
	private ArrayList<Projectile> enemyProjectiles, enemyProjectilesForNextUpdate;
	private ArrayList<Projectile> friendlyProjectiles, friendlyProjectilesForNextUpdate;
	private ArrayList<MobileEntity> enemies, enemiesForNextUpdate;
	private ArrayList<Collector> collectors, collectorsForNextUpdate;
	private ArrayList<ImmobileEntity> immobileEntities, immobileEntitiesForNextUpdate;
	private ArrayList<Entity> gameObjects, gameObjectsForNextUpdate; ; // Alle Entitäten auf dem Battlefield!
	public static BattleField battleField;
	
	public static BattleField getBattleField(){
		if(battleField == null)
			battleField = new BattleField();
		return battleField;
	}
	
	private BattleField() {
		init();
	}
	
	public void init() {
		enemyProjectiles = new ArrayList<Projectile>();
		enemyProjectilesForNextUpdate = new ArrayList<Projectile>();
		friendlyProjectiles = new ArrayList<Projectile>();
		friendlyProjectilesForNextUpdate = new ArrayList<Projectile>();
		enemies = new ArrayList<MobileEntity>();
		enemiesForNextUpdate = new ArrayList<MobileEntity>();
		collectors = new ArrayList<Collector>();
		collectorsForNextUpdate = new ArrayList<Collector>();
		immobileEntities = new ArrayList<ImmobileEntity>();
		immobileEntitiesForNextUpdate = new ArrayList<ImmobileEntity>();

		gameObjectsForNextUpdate = new ArrayList<Entity>();
		gameObjects = new ArrayList<Entity>();
	}
	
	public void update(double deltaTime) {
		updateLists(gameObjects, gameObjectsForNextUpdate);
		updateLists(enemyProjectiles, enemyProjectilesForNextUpdate);
		updateLists(friendlyProjectiles, friendlyProjectilesForNextUpdate);
		updateLists(enemies, enemiesForNextUpdate);
		updateLists(collectors, collectorsForNextUpdate);
		updateLists(immobileEntities, immobileEntitiesForNextUpdate);
	}
	
	private <T extends Entity> void updateLists(ArrayList<T> currentList, ArrayList<T> forNextUpdateList){
		currentList.addAll(forNextUpdateList);
		forNextUpdateList.clear();
		for(Entity e : currentList)
			if(!e.getActive())
				currentList.remove(e);
	}

	// Add Commands
	public void add(Projectile projectile) {  
		if (projectile.isHostile()) enemyProjectilesForNextUpdate.add(projectile); //Wenn feindlich...
		else friendlyProjectilesForNextUpdate.add(projectile); // wenn freundlich...
		gameObjectsForNextUpdate.add(projectile); // 
	}
	
	public void add(MobileEntity mobileEntity) {
		enemiesForNextUpdate.add(mobileEntity); 
		gameObjectsForNextUpdate.add(mobileEntity);
	}
	
	public void add(Collector collector) {
		collectorsForNextUpdate.add(collector); 
		gameObjectsForNextUpdate.add(collector);
	}
	
	public void add(ImmobileEntity immobileEntity) {
		immobileEntitiesForNextUpdate.add(immobileEntity); 
		gameObjectsForNextUpdate.add(immobileEntity);
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


	public ArrayList<Projectile> getFriendlyProjectiles() {
		return friendlyProjectiles;
	}

	public ArrayList<MobileEntity> getEnemies() {
		return enemies;
	}

	public ArrayList<Collector> getCollectors() {
		return collectors;
	}

	public ArrayList<ImmobileEntity> getImmobileEntities() {
		return immobileEntities;
	}

	public ArrayList<Entity> getGameObjects() {
		return gameObjects;
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
		return gameObjectsForNextUpdate;
	}

}
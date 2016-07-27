package de.unbound.game;

import java.util.ArrayList;

import de.unbound.game.model.entities.Entity;

public class BattleField {

	private Entity player, mainBase;
	private ArrayList<Entity> enemyProjectiles, projectilesForNextUpdate;
	private ArrayList<Entity> friendlyProjectiles;
	private ArrayList<Entity> enemies, enemiesForNextUpdate;
	private ArrayList<Entity> collectors, collectorsForNextUpdate;
	private ArrayList<Entity> immobileEntities, immobileEntitiesForNextUpdate;
	private ArrayList<Entity> gameObjects, gameObjectsForNextUpdate; ; // Alle Entitäten auf dem Battlefield!
	private int score;
	
	public BattleField() {
		init();
	}
	
	public void init() {
		enemyProjectiles = new ArrayList<Entity>();
		projectilesForNextUpdate = new ArrayList<Entity>();
		friendlyProjectiles = new ArrayList<Entity>();
		enemies = new ArrayList<Entity>();
		enemiesForNextUpdate = new ArrayList<Entity>();
		collectors = new ArrayList<Entity>();
		collectorsForNextUpdate = new ArrayList<Entity>();
		immobileEntities = new ArrayList<Entity>();
		immobileEntitiesForNextUpdate = new ArrayList<Entity>();

		gameObjectsForNextUpdate = new ArrayList<Entity>();
		gameObjects = new ArrayList<Entity>();
		
		score = 0;
	}
	
	public void update(double deltaTime) {
		updateLists(gameObjects, gameObjectsForNextUpdate);
		updateProjectilesList();
		updateLists(enemies, enemiesForNextUpdate);
		updateLists(collectors, collectorsForNextUpdate);
		updateLists(immobileEntities, immobileEntitiesForNextUpdate);
	}
	
	private void updateLists(ArrayList<Entity> currentList, ArrayList<Entity> forNextUpdateList){
		currentList.addAll(forNextUpdateList);
		forNextUpdateList.clear();
		clearInactiveEntities(currentList);
	}
	
	private void updateProjectilesList(){
		for(Entity projectile : projectilesForNextUpdate){
			if(projectile.isHostile())
				enemyProjectiles.add(projectile);
			else
				friendlyProjectiles.add(projectile);
		}
		projectilesForNextUpdate.clear();
		clearInactiveEntities(enemyProjectiles);
		clearInactiveEntities(friendlyProjectiles);
	}

	private void clearInactiveEntities(ArrayList<Entity> currentList) {
		for(int i = 0; i < currentList.size(); i++)
			if(!currentList.get(i).isActive()){
				if(currentList.get(i).isHostile() && !currentList.get(i).getTextureName().contains("Projectile"))
					addScore(100);
				currentList.remove(currentList.get(i));
			}
	}
	
	public void addScore(int score){
		this.score += score;
	}

	// Add Commands
	public void add(Entity e) {
		String temp = e.getModel().getTextureName();
		
		if(temp.contains("Projectile"))
			projectilesForNextUpdate.add(e);
		else if(temp.contains("Collectors"))
			collectorsForNextUpdate.add(e);
		else if(temp.contains("Player"))
			player = e;
		else if(temp.contains("MainBase"))
			mainBase = e;
		else if(temp.contains("Spawner"))
			; //do nothing
		else if(e.isImmobile())
			immobileEntitiesForNextUpdate.add(e);
		else if(!e.isImmobile())
			enemiesForNextUpdate.add(e);
			
		gameObjectsForNextUpdate.add(e);
	}
	
	public ArrayList<Entity> getFriendlyProjectiles() {
		return friendlyProjectiles;
	}

	public ArrayList<Entity> getEnemies() {
		return enemies;
	}

	public ArrayList<Entity> getCollectors() {
		return collectors;
	}

	public ArrayList<Entity> getImmobileEntities() {
		return immobileEntities;
	}

	public ArrayList<Entity> getGameObjects() {
		return gameObjects;
	}

	public Entity getPlayer() {
		return player;
	}

	public Entity getMainBase() {
		return mainBase;
	}
	
	public ArrayList<Entity> getEnemyProjectiles() {
		return enemyProjectiles;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
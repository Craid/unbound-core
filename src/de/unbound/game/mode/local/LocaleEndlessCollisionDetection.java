package de.unbound.game.mode.local;

import java.util.ArrayList;

import de.unbound.game.collisionhandler.BodyCollisionHandler;
import de.unbound.game.collisionhandler.VisionCollisionHandler;
import de.unbound.game.mode.CollisionDetection;
import de.unbound.game.model.entities.Entity;

public class LocaleEndlessCollisionDetection extends CollisionDetection {

	public LocaleEndlessCollisionDetection() {
		super(new  BodyCollisionHandler(), new VisionCollisionHandler());
	}

	public void update(double deltaTime) {
		updateEnemies();
		updateOwn();
	}

	/**
	 * Already checks player and projectiles. 
	 * That's why they are missing in updateOwn()
	 */
	private void updateEnemies() {
		ArrayList<Entity> player = new ArrayList<Entity>();
		player.add(battleField.getPlayers().get(0));
		for (Entity me : battleField.getEnemies()) {
			checkVisionAndBodyCollision(me, battleField.getCollectors());
			checkVisionAndBodyCollision(me, battleField.getFriendlyProjectiles());
			checkVisionAndBodyCollision(me, battleField.getImmobileEntities());
			checkVisionAndBodyCollision(me, player);
			limit(me);
		}
		for (Entity projectile : battleField.getEnemyProjectiles()) {
			checkBodyCollision(projectile, battleField.getCollectors());
			checkBodyCollision(projectile, battleField.getImmobileEntities());
			checkBodyCollision(projectile, player);
			limit(projectile);
		}
	}

	/**
	 * see updateEnemies()
	 */
	private void updateOwn() {
		for(Entity c : battleField.getCollectors()){
			checkBodyCollision(c,battleField.getImmobileEntities());
			limit(c);
		}
		for(Entity im : battleField.getImmobileEntities())
			checkVision(im, battleField.getEnemies());

		for(Entity projectile : battleField.getFriendlyProjectiles())
			limit(projectile);
		
		limit(battleField.getPlayers().get(0));
	}

	
	
	

}
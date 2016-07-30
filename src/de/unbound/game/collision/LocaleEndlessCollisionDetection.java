package de.unbound.game.collision;

import java.util.ArrayList;

import de.unbound.game.collision.handler.BodyCollisionHandler;
import de.unbound.game.collision.handler.VisionCollisionHandler;
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
			if(outOfHeight(projectile) || outOfWidth(projectile))
				projectile.setActive(false);
			checkBodyCollision(projectile, battleField.getCollectors());
			checkBodyCollision(projectile, battleField.getImmobileEntities());
			checkBodyCollision(projectile, player);
		}
	}

	/**
	 * see updateEnemies()
	 */
	private void updateOwn() {
		for(Entity c : battleField.getCollectors())
			checkBodyCollision(c,battleField.getImmobileEntities());
		for(Entity im : battleField.getImmobileEntities())
			checkVision(im, battleField.getEnemies());
	}

	
	
	

}
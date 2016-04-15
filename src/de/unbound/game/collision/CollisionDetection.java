package de.unbound.game.collision;

import java.util.ArrayList;

import de.unbound.game.BattleField;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.mobile.Collector;
import de.unbound.game.model.entities.mobile.MobileEntity;
import de.unbound.game.model.entities.mobile.Player;
import de.unbound.game.model.entities.mobile.Projectile;

public class CollisionDetection {

	private BattleField battleField;
	private ArrayList<Entity> gameObjects;

	public CollisionDetection() {
		init();
	}

	public void init() {
		this.battleField = BattleField.getBattleField();
	}

	/**
	 * 
	 * @param deltaTime
	 */
	public void update(double deltaTime) {
		gameObjects = battleField.getGameObjects();

		updateEnemies();
		updateOwn();

	}

	private void updateOwn() {

	}

	private void updateEnemies() {
		ArrayList<Player> player = new ArrayList<Player>();
		player.add(battleField.getPlayer());
		for (MobileEntity me : battleField.getEnemies()) {
			checkMobileEntityCollision(me, battleField.getCollectors());
			checkMobileEntityCollision(me, battleField.getFriendlyProjectiles());
			checkMobileEntityCollision(me, battleField.getImmobileEntities());
			checkMobileEntityCollision(me, player);
		}
		for (Projectile projectile : battleField.getEnemyProjectiles()) {
			for (Entity e : gameObjects) {
				if (e.isHostile() != projectile.isHostile()) {
					float xD = e.getPosition().x - projectile.getPosition().x;
					float yD = e.getPosition().y - projectile.getPosition().y;
					float sqDist = xD * xD + yD * yD; // square distance

					boolean bodyCollision = sqDist <= (Math.pow(projectile
							.getModel().getRangeofCollision()
							+ e.getModel().getRangeofCollision(), 2));
					// handle body collision
				}
			}
		}
	}

	private <T extends Entity, K extends MobileEntity> void checkMobileEntityCollision(
			K mobileEntity, ArrayList<T> list) {
		for (T entity : list) {
			if (entity.isHostile() != mobileEntity.isHostile()) {
				float xD = entity.getPosition().x
						- mobileEntity.getPosition().x;
				float yD = entity.getPosition().y
						- mobileEntity.getPosition().y;
				float sqDist = xD * xD + yD * yD;
				boolean visionCollision = sqDist <= (Math.pow(mobileEntity
						.getModel().getRangeOfVision()
						+ entity.getModel().getRangeofCollision(), 2));
				// hashmap.get(MobileEntity"Vision")
				if (visionCollision) {
					boolean bodyCollision = sqDist <= (Math.pow(mobileEntity
							.getModel().getRangeofCollision()
							+ entity.getModel().getRangeofCollision(), 2));
					if (bodyCollision) {
						mobileEntity.setActive(false);
						// hashmap.get(MobileEntityCollision)
					}
				}
			}
		}
	}

}
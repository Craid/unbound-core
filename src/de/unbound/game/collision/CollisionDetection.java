package de.unbound.game.collision;

import java.util.ArrayList;

import de.unbound.game.BattleField;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.mobile.MobileEntity;
import de.unbound.game.model.entities.mobile.Player;
import de.unbound.game.model.entities.mobile.Projectile;

public class CollisionDetection {

	private BattleField battleField;
	private ArrayList<Entity> gameObjects;
	private VisionCollisionHandler visionHandler;
	private BodyCollisionHandler bodyHandler;

	public CollisionDetection() {
		init();
	}

	public void init() {
		this.battleField = BattleField.getBattleField();
		visionHandler = new VisionCollisionHandler();
		bodyHandler = new BodyCollisionHandler();
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
			checkVisionAndBodyCollision(me, battleField.getCollectors());
			checkVisionAndBodyCollision(me, battleField.getFriendlyProjectiles());
			checkVisionAndBodyCollision(me, battleField.getImmobileEntities());
			checkVisionAndBodyCollision(me, player);
		}
//		for (Projectile projectile : battleField.getEnemyProjectiles()) {
//			for (Entity e : gameObjects) {
//				if (e.isHostile() != projectile.isHostile()) {
//					float xD = e.getPosition().x - projectile.getPosition().x;
//					float yD = e.getPosition().y - projectile.getPosition().y;
//					float sqDist = xD * xD + yD * yD; // square distance
//
//					boolean bodyCollision = sqDist <= (Math.pow(projectile
//							.getModel().getRangeofCollision()
//							+ e.getModel().getRangeofCollision(), 2));
//					// handle body collision
//				}
//			}
//		}
	}

	private <T extends MobileEntity, E extends Entity> void checkVisionAndBodyCollision(T subject, ArrayList<E> list) {
		double subjectRoV = subject.getModel().getRangeOfVision();
		double subjectRoC = subject.getModel().getRangeofCollision();
		float subjectX = subject.getPosition().x;
		float subjectY = subject.getPosition().y;
		
		for (E object : list) {
			if(!subject.isActive())
				return;
			if (object.isHostile() != subject.isHostile() && object.isActive()) {
				float xD = object.getPosition().x - subjectX;
				float yD = object.getPosition().y - subjectY;
				float sqDist = xD * xD + yD * yD;
				
				double objectRoV = object.getModel().getRangeofCollision();
				boolean visionCollision = sqDist <= (Math.pow(subjectRoV + objectRoV, 2));

				if (visionCollision) {
//					visionHandler.handle(subject, object);
				
					boolean bodyCollision = sqDist <= (Math.pow(subjectRoC + objectRoV, 2));
					if (bodyCollision)
						bodyHandler.handle(subject, object);
				}
			}
		}
	}

}
package de.unbound.game.collision;

import java.util.ArrayList;

import de.unbound.game.BattleField;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.mobile.MobileEntity;
import de.unbound.game.model.entities.mobile.Player;
import de.unbound.game.model.entities.mobile.Projectile;

public class CollisionDetection {

	private BattleField battleField;
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
		updateEnemies();
		updateOwn();
	}

	/**
	 * @see updateEnemies()
	 */
	private void updateOwn() {

	}

	/**
	 * Already checks player and projectiles. 
	 * That's why they are missing in updateOwn()
	 */
	private void updateEnemies() {
		ArrayList<Player> player = new ArrayList<Player>();
		player.add(battleField.getPlayer());
		for (MobileEntity me : battleField.getEnemies()) {
			checkVisionAndBodyCollision(me, battleField.getCollectors());
			checkVisionAndBodyCollision(me, battleField.getFriendlyProjectiles());
			checkVisionAndBodyCollision(me, battleField.getImmobileEntities());
			checkVisionAndBodyCollision(me, player);
		}
		for (Projectile projectile : battleField.getEnemyProjectiles()) {
			checkBodyCollision(projectile, battleField.getCollectors());
			checkBodyCollision(projectile, battleField.getImmobileEntities());
			checkBodyCollision(projectile, player);
		}
	}

	private <T extends MobileEntity, E extends Entity> void checkVisionAndBodyCollision(T subject, ArrayList<E> list) {
		double subjectRoV = subject.getModel().getRangeOfVision();
		double subjectRoC = subject.getModel().getRangeofCollision();
		float subjectX = subject.getPosition().x;
		float subjectY = subject.getPosition().y;
		
		boolean firstSight = true;
		
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
					if(firstSight){
						visionHandler.handle(subject, object);
						firstSight = false;
					}
				
					boolean bodyCollision = sqDist <= (Math.pow(subjectRoC + objectRoV, 2));
					if (bodyCollision)
						bodyHandler.handle(subject, object);
				}
			}
		}
	}
	
	private <T extends MobileEntity, E extends Entity> void checkBodyCollision(T subject, ArrayList<E> list) {
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
				
				double objectRoC = object.getModel().getRangeofCollision();
				boolean bodyCollision = sqDist <= (Math.pow(subjectRoC + objectRoC, 2));

				if (bodyCollision)
					bodyHandler.handle(subject, object);
			}
		}
	}
	

}
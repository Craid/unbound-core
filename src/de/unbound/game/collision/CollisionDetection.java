package de.unbound.game.collision;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.BattleField;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.move.MoveStateRandom;
import de.unbound.utility.UnboundConstants;

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
		for(Entity c : battleField.getCollectors())
			checkBodyCollision(c,battleField.getImmobileEntities());
		for(Entity im : battleField.getImmobileEntities())
			checkVision(im, battleField.getEnemies());
	}

	/**
	 * Already checks player and projectiles. 
	 * That's why they are missing in updateOwn()
	 */
	private void updateEnemies() {
		ArrayList<Entity> player = new ArrayList<Entity>();
		player.add(battleField.getPlayer());
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

	private void checkVisionAndBodyCollision(Entity subject, ArrayList<Entity> list) {
		double subjectRoV = subject.getModel().getRangeOfVision();
		double subjectRoC = subject.getModel().getRangeOfCollision();
		float subjectX = subject.getPosition().x;
		float subjectY = subject.getPosition().y;
		
		boolean firstSight = true;
		
		for (Entity object : list) {
			if(!subject.isActive())
				return;
			if (object.isHostile() != subject.isHostile() && object.isActive()) {
				float xD = object.getPosition().x - subjectX;
				float yD = object.getPosition().y - subjectY;
				float sqDist = xD * xD + yD * yD;
				
				double objectRoV = object.getModel().getRangeOfCollision();
				
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
	
	private void checkBodyCollision(Entity subject, ArrayList<Entity> list) {
		double subjectRoC = subject.getModel().getRangeOfCollision();
		float subjectX = subject.getPosition().x;
		float subjectY = subject.getPosition().y;
		
		for (Entity object : list) {
			if(!subject.isActive())
				return;
			if (object.isHostile() != subject.isHostile() && object.isActive()) {
				float xD = object.getPosition().x - subjectX;
				float yD = object.getPosition().y - subjectY;
				float sqDist = xD * xD + yD * yD;
				
				double objectRoC = object.getModel().getRangeOfCollision();
				boolean bodyCollision = sqDist <= (Math.pow(subjectRoC + objectRoC, 2));

				if (bodyCollision)
					bodyHandler.handle(subject, object);
			}
		}
	}
	


	private void checkVision(Entity subject, ArrayList<Entity> list) {
		double subjectRoV = subject.getModel().getRangeOfVision();
		float subjectX = subject.getPosition().x;
		float subjectY = subject.getPosition().y;
		
		for (Entity object : list) {
			if(!subject.isActive())
				return;
			if (object.isHostile() != subject.isHostile() && object.isActive()) {
				float xD = object.getPosition().x - subjectX;
				float yD = object.getPosition().y - subjectY;
				float sqDist = xD * xD + yD * yD;
				
				double objectRoV = object.getModel().getRangeOfCollision();
				
				boolean visionCollision = sqDist <= (Math.pow(subjectRoV + objectRoV, 2));

				if (visionCollision) {
					visionHandler.handle(object, subject);
					return;
				}
			}
		}
	}
	
	/**
	 * This method prevents entities from leaving the map
	 * 
	 * @param e
	 */
	private void limit(Entity e) {
		boolean outOfWidth = outOfWidth(e);
		boolean outOfHeight = outOfHeight(e);
		if(outOfHeight || outOfWidth){
			Vector2 newDirection = e.getDirection().cpy();
			Vector2 newVelocity = e.getUpdateState().getMove().getVelocity().cpy();
			if(outOfWidth){
				newDirection.x = -newDirection.x;
				newVelocity.x = -newVelocity.x;

				e.setPosition(new Vector2(clamp(e.getPosition().x, 0, UnboundConstants.WORLDWIDTH),e.getPosition().y));
			}
			if(outOfHeight){
				newDirection.y = -newDirection.y;
				newVelocity.y = -newVelocity.y;
				e.setPosition(new Vector2(e.getPosition().x,clamp(e.getPosition().y, 0, UnboundConstants.WORLDHEIGHT)));
			}
			e.setDirection(newDirection);
			e.getUpdateState().getMove().setVelocity(newVelocity);
			e.getUpdateState().setMove(new MoveStateRandom(e));
		}
			
	}
	
	private float clamp(float pos, float start, float end){
		return Math.min(end, Math.max(pos, start));
	}

	private boolean outOfHeight(Entity e) {
		return e.getPosition().y < 0 || e.getPosition().y > UnboundConstants.WORLDHEIGHT;
	}

	private boolean outOfWidth(Entity e) {
		return e.getPosition().x < 0 || e.getPosition().x > UnboundConstants.WORLDWIDTH;
	}

}
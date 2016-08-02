package de.unbound.game.mode;

import java.util.ArrayList;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import de.unbound.game.BattleField;
import de.unbound.game.collisionhandler.BodyCollisionHandler;
import de.unbound.game.collisionhandler.VisionCollisionHandler;
import de.unbound.game.model.entities.Entity;
import de.unbound.utility.UnboundConstants;

public abstract class CollisionDetection {

	protected BattleField battleField;
	protected BodyCollisionHandler bodyHandler;
	protected VisionCollisionHandler visionHandler;

	public CollisionDetection(BodyCollisionHandler bodyHandler,
			VisionCollisionHandler visionHandler) {
		this.bodyHandler = bodyHandler;
		this.visionHandler = visionHandler;
	}

	public abstract void update(double deltaTime);
	
	protected void checkVisionAndBodyCollision(Entity subject, ArrayList<Entity> list) {
		boolean firstSight = true;
		
		for (Entity object : list) {
			if(!subject.isActive())
				return;
			if (object.isHostile() != subject.isHostile() && object.isActive()) {
				if (canBeSeen(subject, object)) {
					if(firstSight){
						visionHandler.handle(subject, object);
						firstSight = false;
					}
				
					if (areTouching(subject, object))
						bodyHandler.handle(subject, object);
				}
			}
		}
	}

	protected void checkBodyCollision(Entity subject, ArrayList<Entity> list) {
		for (Entity object : list) {
			if (!subject.isActive())
				return;
			if (object.isHostile() != subject.isHostile() && object.isActive()) {
				if (areTouching(subject, object))
					bodyHandler.handle(subject, object);
			}
		}
	}

	protected void checkVision(Entity subject, ArrayList<Entity> list) {
		for (Entity object : list) {
			if (!subject.isActive())
				return;
			if (object.isHostile() != subject.isHostile() && object.isActive())
				if (canBeSeen(subject, object)) {
					visionHandler.handle(object, subject);
					return;
				}
		}
	}

	private boolean areTouching(Entity subject, Entity object) {
		float subjectRange = subject.getModel().getRangeOfCollision();
		return isInDistance(subject, object, subjectRange);
	}

	private boolean canBeSeen(Entity subject, Entity object) {
		float subjectRange = subject.getModel().getRangeOfVision();
		return isInDistance(subject, object, subjectRange);
	}

	private boolean isInDistance(Entity subject, Entity object, float subjectRange) {
		float objectRange = object.getModel().getRangeOfCollision();
		float distance = subject.getPosition().dst(object.getPosition());

		return distance <= (subjectRange + objectRange);
	}
	
	/**
	 * This method prevents entities from leaving the map
	 * 
	 * @param e
	 */
	protected void limit(Entity e) {
		int width = UnboundConstants.WORLDWIDTH;
		int height = UnboundConstants.WORLDHEIGHT;
		boolean outOfWidth = outOfRange(e.getPosition().x,width);
		boolean outOfHeight = outOfRange(e.getPosition().y,height);
		if (outOfHeight || outOfWidth) {
			if(e.getTextureName().contains(UnboundConstants.MobileEntity.Projectile.name())){
				e.setActive(false);
			}else{
				Vector2 newDirection = e.getDirection().cpy();
				Vector2 newVelocity = e.getUpdateState().getMove().getVelocity().cpy();
				if (outOfWidth) {
					newDirection.x = -newDirection.x;
					newVelocity.x = -newVelocity.x;
				
					e.setPosition(new Vector2(MathUtils.clamp(e.getPosition().x, 0,width), e.getPosition().y));
				}
				if (outOfHeight) {
					newDirection.y = -newDirection.y;
					newVelocity.y = -newVelocity.y;
					e.setPosition(new Vector2(e.getPosition().x, MathUtils.clamp(e.getPosition().y, 0, height)));
				}
				e.setDirection(newDirection);
				e.getUpdateState().getMove().setVelocity(newVelocity);
			}
		}
	}
	
	protected boolean outOfRange(float value, int upperBound) {
		return value < 0 || value > upperBound;
	}

	public BattleField getBattleField() {
		return battleField;
	}

	public void setBattleField(BattleField battleField) {
		this.battleField = battleField;
	}

}
package de.unbound.game.collision;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.BattleField;
import de.unbound.game.collision.handler.BodyCollisionHandler;
import de.unbound.game.collision.handler.VisionCollisionHandler;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.move.MoveStateRandom;
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
		double subjectRange = subject.getModel().getRangeOfCollision();
		double objectRange = object.getModel().getRangeOfCollision();

		return isInRange(subject, object, subjectRange, objectRange);
	}

	private boolean canBeSeen(Entity subject, Entity object) {
		double subjectRange = subject.getModel().getRangeOfVision();
		double objectRange = object.getModel().getRangeOfCollision();

		return isInRange(subject, object, subjectRange, objectRange);
	}

	private boolean isInRange(Entity subject, Entity object,
			double subjectRange, double objectRange) {
		return calcSqDist(subject, object) <= (Math.pow(subjectRange
				+ objectRange, 2));
	}

	private float calcSqDist(Entity subject, Entity object) {
		float xD = object.getPosition().x - subject.getPosition().x;
		float yD = object.getPosition().y - subject.getPosition().y;
		return xD * xD + yD * yD;
	}

	/**
	 * This method prevents entities from leaving the map
	 * 
	 * @param e
	 */
	protected void limit(Entity e) {
		boolean outOfWidth = outOfWidth(e);
		boolean outOfHeight = outOfHeight(e);
		if (outOfHeight || outOfWidth) {
			Vector2 newDirection = e.getDirection().cpy();
			Vector2 newVelocity = e.getUpdateState().getMove().getVelocity()
					.cpy();
			if (outOfWidth) {
				newDirection.x = -newDirection.x;
				newVelocity.x = -newVelocity.x;
				e.setPosition(new Vector2(clamp(e.getPosition().x, 0,
						UnboundConstants.WORLDWIDTH), e.getPosition().y));
			}
			if (outOfHeight) {
				newDirection.y = -newDirection.y;
				newVelocity.y = -newVelocity.y;
				e.setPosition(new Vector2(e.getPosition().x, clamp(
						e.getPosition().y, 0, UnboundConstants.WORLDHEIGHT)));
			}
			e.setDirection(newDirection);
			e.getUpdateState().getMove().setVelocity(newVelocity);
			e.getUpdateState().setMove(new MoveStateRandom(e));
		}

	}

	private float clamp(float pos, float start, float end) {
		return Math.min(end, Math.max(pos, start));
	}

	protected boolean outOfHeight(Entity e) {
		return e.getPosition().y < 0
				|| e.getPosition().y > UnboundConstants.WORLDHEIGHT;
	}

	protected boolean outOfWidth(Entity e) {
		return e.getPosition().x < 0
				|| e.getPosition().x > UnboundConstants.WORLDWIDTH;
	}

	public BattleField getBattleField() {
		return battleField;
	}

	public void setBattleField(BattleField battleField) {
		this.battleField = battleField;
	}

}
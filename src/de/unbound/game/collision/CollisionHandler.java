package de.unbound.game.collision;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.mobile.MobileEntity;

public abstract class CollisionHandler<T extends MobileEntity,K extends Entity> {

	protected static void debugPrint(Entity subject, Entity object) {
		System.out.print("\nSubject: " + subject.getClass().getSimpleName() + " , Object: " + object.getClass().getSimpleName());
	}
	
	public abstract void handle(T subject, K object);

}
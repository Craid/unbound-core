package de.unbound.game.collision;

import de.unbound.game.model.entities.Entity;

public abstract class CollisionHandler{

	protected static void debugPrint(Entity subject, Entity object) {
		System.out.print("\nSubject: " + subject.getModel().getTextureName() + " , Object: " + object.getModel().getTextureName());
	}
	
	public abstract void handle(Entity subject, Entity object);
	
}
package de.unbound.game.collision;

import de.unbound.game.model.entities.Entity;

public abstract class CollisionHandler<T extends Entity> {

	/**
	 * 
	 * @param subject
	 * @param object
	 */
	public abstract void handle(T subject, Entity object);

	
	
}
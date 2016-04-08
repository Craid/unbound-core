package de.unbound.game.collision;

import de.unbound.game.model.entities.Entity;

public class NoneCollisionHandler extends CollisionHandler<Entity> {
	
	public static final NoneCollisionHandler instance = new NoneCollisionHandler();
	
	private NoneCollisionHandler() {
	}

	@Override
	public void handle(Entity subject, Entity object) {
		//None
		//Intentionally unimplemented
	}

}
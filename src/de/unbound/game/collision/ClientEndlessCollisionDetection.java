package de.unbound.game.collision;

import de.unbound.game.model.entities.Entity;

public class ClientEndlessCollisionDetection extends CollisionDetection {

	public ClientEndlessCollisionDetection() {
		super(null, null);
	}

	public void update(double deltaTime) {
		//Intentionally no cd
		//just limiting the entities to the world
		for(Entity e : battleField.getGameObjects())
			limit(e);
	}

}
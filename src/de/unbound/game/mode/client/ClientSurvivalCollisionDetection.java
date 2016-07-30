package de.unbound.game.mode.client;

import de.unbound.game.mode.CollisionDetection;
import de.unbound.game.model.entities.Entity;

public class ClientSurvivalCollisionDetection extends CollisionDetection {

	public ClientSurvivalCollisionDetection() {
		super(null, null);
	}

	public void update(double deltaTime) {
		//Intentionally no cd
		//just limiting the entities to the world
		for(Entity e : battleField.getGameObjects())
			limit(e);
	}

}
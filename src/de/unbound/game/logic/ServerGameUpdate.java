package de.unbound.game.logic;

import de.unbound.game.model.entities.Entity;


public class ServerGameUpdate extends AbstractGameUpdate{

	@Override
	public void update(double deltaTime) {
		if (battleField.getMainBase().isActive()) {

			world.getWaveHandler().update(deltaTime);

			createNextWaveIfReadyAndPushToBattlefield();
			battleField.update(deltaTime); // To be generated Objects in actual
											// List

			collisionDetection.update(deltaTime);

			for (Entity e : battleField.getGameObjects()) {
				e.update(deltaTime);
			}

		} else {
			//inform game over
		}
		
	}

}

package de.unbound.game.logic;


public class ServerSurvivalGameUpdate extends AbstractGameUpdate{

	@Override
	public boolean isGameOver() {
		return battleField.getMainBase().isActive();
	}	
	
	@Override
	public void doBeforeUpdate() {
		//get updated entites!
		//add them to battlefield!
	}

	@Override
	public void doAfterUpdate() {
		//Do nothing normally rendering
	}

	@Override
	public void onGameEnd() {
		//send game Over Message
	}

	@Override
	public void onCollisionHandling(double deltaTime) {
		collisionDetection.update(deltaTime);
	}

}

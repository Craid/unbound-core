package de.unbound.game;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import de.unbound.game.factories.EntityFactory;
import de.unbound.game.mode.AbstractGameUpdate;
import de.unbound.game.mode.GameMode;
import de.unbound.game.mode.WaveHandler;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.attack.AttackStateNone;
import de.unbound.game.model.state.move.MoveStateStraightSpinning;
import de.unbound.utility.UnboundConstants;
import de.unbound.utility.UnboundConstants.Race;

public class World {
	
	private static World instance;

	private WaveHandler waveHandler;
	private AbstractGameUpdate gameUpdate;

	private World(){
		init();
	}
	
	public void init(){
		tempPosition = new Vector3();
		waveHandler = null;
		gameUpdate = null;
	}
	
	public static World getInstance(){
		if(instance == null)
			instance = new World();
		return instance;
	}
	
	public void setGameMode(GameMode gameMode){
		instance.gameUpdate = gameMode.getGameUpdate();
		instance.gameUpdate.setWorld(instance);
		instance.waveHandler = gameMode.getWaveHandler();
		instance.waveHandler.setBattleFieldForFactories(instance.getBattleField());
	}

	/**
	 * 
	 * @param deltaTime
	 */
	public void update(double deltaTime) {
		gameUpdate.update(deltaTime);
	}

	public WaveHandler getWaveHandler() {
		return waveHandler;
	}

	public AbstractGameUpdate getGameUpdate() {
		return gameUpdate;
	}
	
	public BattleField getBattleField(){
		return gameUpdate.getBattleField();
	}

	public Entity createTower(float x, float y) {
		Entity tower = waveHandler.getOwnFactory().createEntity(UnboundConstants.ImmobileEntity.Tower.name());
		tower.setDirection(new Vector2(0, 1));
		tower.setPosition(new Vector2(x,y));
		tower.getUpdateState().setAttack(new AttackStateNone(tower));
		return tower;
	}

	public Entity createProjectile(Entity e) {
		Entity p = null;
		p = getMatchingFactory(e.getTextureName()).createEntity(UnboundConstants.MobileEntity.Projectile.name());

		p.setDirection(e.getDirection().cpy());
		p.setPosition(e.getPosition().cpy());
		p.getUpdateState().setMove(new MoveStateStraightSpinning(p));
		p.getUpdateState().getMove().setVelocity(p.getDirection().cpy().nor().scl(p.getModel().getMeta().getMaxVelocity()));
		
		return p;
	}

	public EntityFactory getMatchingFactory(String entityName) {
		String race = "";
		for(Race r : UnboundConstants.Race.values())
			if(entityName.contains(r.name()))
				race = r.name();

		if(race.equals(getWaveHandler().getEnemyFactory().getRace()))
			return getWaveHandler().getEnemyFactory();
		if(race.equals(getWaveHandler().getOwnFactory().getRace()))
			return getWaveHandler().getOwnFactory();
		System.out.println("This shouldn't happen, but there was a race entity, that has no matching factory!");
		return null;
	}

	private Vector3 tempPosition; 
	
	public boolean isOnScreen(Entity e){
		Camera c = gameUpdate.getCamera();
		tempPosition.set(e.getPosition(), 0);
		float spereRadius = (float)e.getModel().getRangeOfCollision();
		return c.frustum.sphereInFrustum(tempPosition, spereRadius); 
	}

}
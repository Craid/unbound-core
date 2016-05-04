package de.unbound.game.factories;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.BattleField;
import de.unbound.game.model.entities.immobile.Tower;
import de.unbound.game.model.entities.mobile.Player;
import de.unbound.game.model.state.attack.AttackStateNone;

public class TowerBuilder {
	
	private static TowerBuilder instance;
	
	private RaceDuckFactory duckFactory;
	private RacePrelateFactory prelateFactory;
	
	public static TowerBuilder getInstance(){
		if(instance == null)
			instance = new TowerBuilder();
		return instance;
	}
	
	private TowerBuilder(){
		duckFactory = RaceDuckFactory.getInstance();
		prelateFactory = RacePrelateFactory.getInstance();
	}
	
	/**
	 * This function only works, when classes follow the convention, 
	 * that race specific start with their Race name and that the
	 * first three Letters of a race are not the same for any other races!
	 * 
	 * @param entity - A specific EntityObject
	 * @return a specific Projectile according to race
	 */
	public Tower createTower(float x, float y){
		Tower tower = null;
		Player entity = BattleField.getBattleField().getPlayer();
		switch(entity.getClass().getSimpleName().substring(0, 3)){
		case "Pre": tower = prelateFactory.createTower(); break;
		case "Duc": tower = duckFactory.createTower(); break;
		}
		tower.setHostile(false);
		tower.setDirection(new Vector2(0, 1));
		tower.setPosition(new Vector2(x,y));
		tower.setAttack(new AttackStateNone(tower));
		return tower;
	}

}

package de.unbound.game.factories;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.BattleField;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.attack.AttackStateNone;

public class TowerBuilder {
	
	private static TowerBuilder instance;
	
	private EntityFactory duckFactory;
	private EntityFactory prelateFactory;
	
	public static TowerBuilder getInstance(){
		if(instance == null)
			instance = new TowerBuilder();
		return instance;
	}
	
	private TowerBuilder(){
		duckFactory = new EntityFactory("Duck");
		prelateFactory = new EntityFactory("Prelate");
	}
	
	/**
	 * This function only works, when classes follow the convention, 
	 * that race specific start with their Race name and that the
	 * first three Letters of a race are not the same for any other races!
	 * 
	 * @param entity - A specific EntityObject
	 * @return a specific Projectile according to race
	 */
	public Entity createTower(float x, float y){
		Entity tower = null;
		Entity entity = BattleField.getBattleField().getPlayer();
		switch(entity.getModel().getTextureName().substring(0, 3)){
		case "Pre": tower = prelateFactory.createEntity("Tower"); break;
		case "Duc": tower = duckFactory.createEntity("Tower"); break;
		}
		tower.setDirection(new Vector2(0, 1));
		tower.setPosition(new Vector2(x,y));
		tower.getUpdateState().setAttack(new AttackStateNone(tower));
		return tower;
	}

}

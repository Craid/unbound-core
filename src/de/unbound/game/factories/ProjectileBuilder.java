package de.unbound.game.factories;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.move.MoveStateStraightSpinning;

public class ProjectileBuilder {
	
	private static ProjectileBuilder instance;
	
	private EntityFactory duckFactory;
	private EntityFactory prelateFactory;
	
	public static ProjectileBuilder getInstance(){
		if(instance == null)
			instance = new ProjectileBuilder();
		return instance;
	}
	
	private ProjectileBuilder(){
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
	public Entity createProjectile(Entity entity){
		Entity p = null;
		switch(entity.getModel().getTextureName().substring(0, 3)){
		case "Pre": p = prelateFactory.createEntity("Projectile"); break;
		case "Duc": p = duckFactory.createEntity("Projectile"); break;
		}
		p.setHostile(entity.isHostile());
		p.setDirection(entity.getDirection().cpy());
		p.setPosition(entity.getPosition().cpy());
		p.getUpdateState().setMove(new MoveStateStraightSpinning(p));
		p.getUpdateState().getMove().setVelocity(p.getDirection().cpy().nor().scl(p.getModel().getMeta().getMaxVelocity()));
		return p;
	}

}

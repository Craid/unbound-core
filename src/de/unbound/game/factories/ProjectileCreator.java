package de.unbound.game.factories;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.mobile.Projectile;
import de.unbound.game.model.state.move.MoveStateStraightSpinning;

public class ProjectileCreator {
	
	private static ProjectileCreator instance;
	
	private RaceDuckFactory duckFactory;
	private RacePrelateFactory prelateFactory;
	
	public static ProjectileCreator getInstance(){
		if(instance == null)
			instance = new ProjectileCreator();
		return instance;
	}
	
	private ProjectileCreator(){
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
	public <T extends Entity> Projectile createProjectile(T entity){
		Projectile p = null;
		switch(entity.getClass().getSimpleName().substring(0, 3)){
		case "Pre": p = prelateFactory.createProjectile(); break;
		case "Duc": p = duckFactory.createProjectile(); break;
		}
		p.setHostile(entity.isHostile());
		p.setDirection(entity.getDirection().cpy());
		p.setPosition(entity.getPosition().cpy());
		p.setVelocity(p.getDirection().cpy().nor().scl(p.getModel().getMaxVelocity()));
		p.setMove(new MoveStateStraightSpinning(p));
		return p;
	}

}

package de.unbound.game.collision;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.immobile.ImmobileEntity;
import de.unbound.game.model.entities.mobile.MobileEntity;
import de.unbound.game.model.entities.mobile.Projectile;

public class ProjectileMobileEffectiveCollisionHandler extends CollisionHandler<Projectile> {

	public static final ProjectileMobileEffectiveCollisionHandler instance = new ProjectileMobileEffectiveCollisionHandler();
	
	private ProjectileMobileEffectiveCollisionHandler() {
	}
	
	@Override
	public void handle(Projectile subject, Entity object) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param subject
	 * @param object
	 */
	public void handle(Projectile subject, MobileEntity object) {
		// TODO - implement ProjectileMobileEffectiveCollisionHandler.handle
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param subject
	 * @param object
	 */
	public void handle(Projectile subject, ImmobileEntity object) {
		// TODO - implement ProjectileMobileEffectiveCollisionHandler.handle
		throw new UnsupportedOperationException();
	}

}
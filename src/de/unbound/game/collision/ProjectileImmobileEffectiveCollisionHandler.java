package de.unbound.game.collision;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.immobile.ImmobileEntity;
import de.unbound.game.model.entities.mobile.MobileEntity;
import de.unbound.game.model.entities.mobile.Projectile;

public class ProjectileImmobileEffectiveCollisionHandler extends CollisionHandler<Projectile> {

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
		// TODO - implement ProjectileImmobileEffectiveCollisionHandler.handle
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param subject
	 * @param object
	 */
	public void handle(Projectile subject, ImmobileEntity object) {
		// TODO - implement ProjectileImmobileEffectiveCollisionHandler.handle
		throw new UnsupportedOperationException();
	}



}
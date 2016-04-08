package de.unbound.game.collision;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.immobile.ImmobileEntity;
import de.unbound.game.model.entities.mobile.MobileEntity;
import de.unbound.game.model.entities.mobile.Projectile;

public class MobileCollisionHandler extends CollisionHandler<MobileEntity> {

	@Override
	public void handle(MobileEntity subject, Entity object) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 * @param subject
	 * @param object
	 */
	public void handle(MobileEntity subject, Projectile object) {
		// TODO - implement MobileCollisionHandler.handle
		throw new UnsupportedOperationException();
		//subject.takeDamage(object.getDamage());
		//object.die();
	}

	/**
	 * 
	 * @param subject
	 * @param object
	 */
	public void handle(MobileEntity subject, MobileEntity object) {
		// TODO - implement MobileCollisionHandler.handle
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param subject
	 * @param object
	 */
	public void handle(MobileEntity subject, ImmobileEntity object) {
		// TODO - implement MobileCollisionHandler.handle
		throw new UnsupportedOperationException();
	}



}
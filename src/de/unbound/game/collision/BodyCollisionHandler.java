package de.unbound.game.collision;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.immobile.ImmobileEntity;
import de.unbound.game.model.entities.mobile.MobileEntity;
import de.unbound.game.model.entities.mobile.Projectile;

public class BodyCollisionHandler extends CollisionHandler<MobileEntity,Entity>{
	
	private void projectileHit(Projectile p, Entity hitted){
		p.setActive(false);
		hitted.takeDamage(p.getDamage());
	}
	
	private void changeDirection(MobileEntity me){
		me.setDirection(me.getDirection().scl(-1f));
		me.setVelocity(me.getVelocity().scl(-1f));
	}
	
	public void handle(MobileEntity subject, Projectile object) {
		projectileHit(object, subject);
	}

	public void handle(MobileEntity subject, MobileEntity object) {
		changeDirection(subject);
		changeDirection(object);
		subject.takeDamage(50);
		object.takeDamage(50);
	}

	public void handle(MobileEntity subject, ImmobileEntity object) {
		changeDirection(subject);
		subject.takeDamage(50);
		object.takeDamage(50);
	}
	
	public void handle(Projectile subject, Entity object) {
		projectileHit(subject, object);
	}

	@Override
	public void handle(MobileEntity subject, Entity object){
		if(subject instanceof Projectile)
			handle((Projectile)subject,object);
		else if(object instanceof Projectile)
			handle(subject,(Projectile)object);
		else if(object instanceof MobileEntity)
			handle(subject,(MobileEntity)object);
		else if(object instanceof ImmobileEntity)
			handle(subject,(ImmobileEntity)object);
		else{			
			debugPrint(subject, object);
			System.out.print("Unbekannte Collision!");
		}
	}
	
}

package de.unbound.game.collision.handler;

import de.unbound.game.model.entities.Entity;

public class BodyCollisionHandler extends CollisionHandler{
	
	private void projectileHit(Entity p, Entity hitted){
		p.setActive(false);
		hitted.getUpdateState().takeDamage(p.getModel().getDamageOnContact());
	}
	
	private void changeDirection(Entity me){
		me.setDirection(me.getDirection().scl(-1f));
		me.getUpdateState().getMove().setVelocity(me.getUpdateState().getMove().getVelocity().scl(-1f));
	}
	
	private void handleMobileMobile(Entity subject, Entity object) {
		changeDirection(subject);
		changeDirection(object);
		subject.getUpdateState().takeDamage(object.getModel().getDamageOnContact());
		object.getUpdateState().takeDamage(subject.getModel().getDamageOnContact());
	}

	private void handleMobileImmobile(Entity subject, Entity object) {
		changeDirection(subject);
		subject.getUpdateState().takeDamage(object.getModel().getDamageOnContact());
		object.getUpdateState().takeDamage(subject.getModel().getDamageOnContact());
	}
	
	private void handleProjectileMobile(Entity subject, Entity object) {
		projectileHit(subject, object);
	}

	@Override
	public void handle(Entity subject, Entity object){
		if(subject.getModel().getTextureName().contains("Projectile"))
			handleProjectileMobile(subject,object);
		else if(object.getModel().getTextureName().contains("Projectile"))
			handleProjectileMobile(object,subject);
		else if(!object.isImmobile())
			handleMobileMobile(subject,object);
		else if(object.isImmobile())
			handleMobileImmobile(subject,object);
		else{			
			debugPrint(subject, object);
			System.out.print("Unbekannte Collision!");
		}
	}
	
}

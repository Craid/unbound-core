package de.unbound.game.collision;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.mobile.MobileEntity;

public class VisionCollisionHandler extends CollisionHandler<MobileEntity,Entity>{
	
	@Override
	public void handle(MobileEntity subject, Entity object){
//		debugPrint(subject, object);
//		System.out.print("Unbekannte Vision Collision!");
	}

}

package de.unbound.game.factories;

import java.util.HashMap;

import de.unbound.game.collision.MobileCollisionHandler;
import de.unbound.game.collision.NoneCollisionHandler;
import de.unbound.game.collision.ProjectileImmobileEffectiveCollisionHandler;
import de.unbound.game.collision.ProjectileMobileEffectiveCollisionHandler;
import de.unbound.game.model.EntityFlyweight;
import de.unbound.game.model.EntityFlyweightModel;
import de.unbound.utility.EntitiyFlyweightModelJsonHelper;

public class FlyweightFactory {

	public static final FlyweightFactory instance = new FlyweightFactory();
	private HashMap<String, EntityFlyweight> flyweights;
	private HashMap<String, EntityFlyweightModel> flyweightUberModels;

	private FlyweightFactory() {
		flyweights = new HashMap<String, EntityFlyweight>();
		flyweightUberModels = EntitiyFlyweightModelJsonHelper.instance
				.readDocument();
	}

	/**
	 * 
	 * @param name
	 */
	public EntityFlyweight getFlyweight(String name) {
		if (flyweights.get(name) == null){
			flyweights.put(name, createEntityFlywight(name));
			System.out.println(flyweightUberModels.get(name).getName());
		}
		return flyweights.get(name);
	}

	private EntityFlyweight createEntityFlywight(String name) {
		EntityFlyweightModel efm = flyweightUberModels.get(name);
		EntityFlyweight ef = new EntityFlyweight();

		ef.setRangeofCollision(efm.getRangeOfCollision());
		ef.setRangeOfVision(efm.getRangeOfVision());
		ef.setUpgrades(efm.getUpgrades());

		switch (efm.getCollisionHandler()) {
		case 0:
			ef.setCollisionHandler(MobileCollisionHandler.instance);
			break;
		case 1:
			ef.setCollisionHandler(ProjectileMobileEffectiveCollisionHandler.instance);
			break;
		case 2:
			ef.setCollisionHandler(ProjectileImmobileEffectiveCollisionHandler.instance);
			break;
		default:
			ef.setCollisionHandler(NoneCollisionHandler.instance);
		}

		// TODO Code for loading assets!
		// AssetsManager.gibAus efm.graphic den Teilausschnitt efm.name
		
		return ef;
	}

}
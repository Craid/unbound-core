package de.unbound.game.factories;

import java.util.HashMap;

import de.unbound.game.model.EntityFlyweight;
import de.unbound.game.model.EntityFlyweightModel;
import de.unbound.utility.AssetsManagingHelper;
import de.unbound.utility.EntitiyFlyweightModelJsonHelper;

public class FlyweightFactory {

	public static final FlyweightFactory instance = new FlyweightFactory();
	private HashMap<String, EntityFlyweight> flyweights;
	private HashMap<String, EntityFlyweightModel> flyweightUberModels;

	private FlyweightFactory() {
		flyweights = new HashMap<String, EntityFlyweight>();
		flyweightUberModels = EntitiyFlyweightModelJsonHelper.instance.readDocument();
	}

	/**
	 * 
	 * @param name
	 */
	public EntityFlyweight getFlyweight(String name) {
		if (flyweights.get(name) == null){
			flyweights.put(name, createEntityFlywight(name));
		}
		return flyweights.get(name);
	}

	/**
	 * 
	 * @param textureName Is the same as the Class Name of the Entity
	 * @return
	 */
	private EntityFlyweight createEntityFlywight(String textureName) {
		EntityFlyweightModel efm = flyweightUberModels.get(textureName);
		EntityFlyweight ef = new EntityFlyweight();

		ef.setRangeofCollision(efm.getRangeOfCollision());
		ef.setRangeOfVision(efm.getRangeOfVision());
		ef.setUpgrades(efm.getUpgrades());

		ef.setGraphic(AssetsManagingHelper.instance.getSprite(efm.getAtlasName(), efm.getTextureName()));
		
		return ef;
	}

}
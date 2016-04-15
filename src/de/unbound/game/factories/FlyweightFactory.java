package de.unbound.game.factories;

import java.util.HashMap;

import de.unbound.game.model.EntityFlyweight;
import de.unbound.game.model.EntityFlyweightModel;
import de.unbound.utility.AssetsManagingHelper;
import de.unbound.utility.EntitiyFlyweightModelJsonHelper;

public class FlyweightFactory {

	private static FlyweightFactory instance;
	private HashMap<String, EntityFlyweight> flyweights;
	private HashMap<String, EntityFlyweightModel> flyweightTextModels;

	private FlyweightFactory() {
		flyweights = new HashMap<String, EntityFlyweight>();
		flyweightTextModels = EntitiyFlyweightModelJsonHelper.instance.readDocument();
	}

	public static FlyweightFactory getInstance(){
		if(instance == null)
			instance = new FlyweightFactory();
		return instance;
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
		EntityFlyweightModel efm = flyweightTextModels.get(textureName);
		EntityFlyweight ef = new EntityFlyweight();
		
		ef.setModel(efm);
		ef.setGraphic(AssetsManagingHelper.instance.getSprite(efm.getTextureName()));
		
		return ef;
	}

}
package de.unbound.game.factories;

import java.util.HashMap;

import de.unbound.game.model.entities.EntityFlyweight;
import de.unbound.game.model.entities.EntityFlyweight.EntityFlyweightMeta;
import de.unbound.utility.AssetsManagingHelper;
import de.unbound.utility.EntitiyFlyweightModelJsonHelper;

public class FlyweightFactory {

	private static FlyweightFactory instance;
	private HashMap<String, EntityFlyweight> flyweights;
	private HashMap<String, EntityFlyweightMeta> meta;

	private FlyweightFactory() {
		flyweights = new HashMap<String, EntityFlyweight>();
		meta = EntitiyFlyweightModelJsonHelper.instance.readDocument();
	}

	public static FlyweightFactory getInstance(){
		if(instance == null)
			instance = new FlyweightFactory();
		return instance;
	}
	
	public EntityFlyweight getFlyweight(String name) {
		if (flyweights.get(name) == null){
			flyweights.put(name, createEntityFlywight(name));
		}
		return flyweights.get(name);
	}
	
	public EntityFlyweight getFlyweight(int id) {
		for(EntityFlyweightMeta f : meta.values())
			if(f.getId() == id)
				return getFlyweight(f.getTextureName());
		return null;
	}

	/**
	 * 
	 * @param textureName Is the same as the Class Name of the Entity
	 * @return
	 */
	private EntityFlyweight createEntityFlywight(String textureName) {
		EntityFlyweightMeta efm = meta.get(textureName);
		EntityFlyweight ef = new EntityFlyweight();
		
		ef.setMeta(efm);
		ef.setGraphic(AssetsManagingHelper.instance.getSprite(efm.getTextureName()));
		
		return ef;
	}

}
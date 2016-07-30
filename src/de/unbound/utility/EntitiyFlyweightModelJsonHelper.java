package de.unbound.utility;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

import de.unbound.game.model.entities.EntityFlyweight.EntityFlyweightMeta;

public class EntitiyFlyweightModelJsonHelper {
	
	public static final EntitiyFlyweightModelJsonHelper instance = new EntitiyFlyweightModelJsonHelper();
	
	private EntitiyFlyweightModelJsonHelper(){

		//TODO uncomment to update flyweightmodel.json
		//needs to be moved from desktop/<root> to android/assests/model/
		initDocument();
	}

	public HashMap<String, EntityFlyweightMeta> readDocument() {
		HashMap<String, EntityFlyweightMeta> flyweightMeta = new HashMap<String, EntityFlyweightMeta>();
		Json json = new Json();
		@SuppressWarnings("unchecked")
		ArrayList<EntityFlyweightMeta> list = json.fromJson(ArrayList.class, Gdx.files.internal("model/flyweightentitymodel.json"));
		for (EntityFlyweightMeta v : list) 
			flyweightMeta.put(v.getTextureName(), v);
		
		return flyweightMeta;
	}
	
	/**
	 * Only used to initialize the JSON File!
	 * Can be used for Generating new EntityFlyweightMeta's
	 */
	private void initDocument() {
		ArrayList<EntityFlyweightMeta> efml = new ArrayList<EntityFlyweightMeta>();

		int temp = UnboundConstants.SINGLEGRIDHEIGHT/2;
		//double rangeOfVision, double rangeOfCollision, int upgrades, String textureName, 
		//	.. float accelaration, float maxVelocity, double damage
		addList(efml, temp,UnboundConstants.Race.Duck.name());

		addList(efml, temp,UnboundConstants.Race.Prelate.name());
		
		Json json = new Json();
		FileHandle file = Gdx.files.local("flyweightentitymodel.json");
		file.writeString(json.toJson(efml), false);
		
		System.out.println("Generated JSON");
	}

	private void addList(ArrayList<EntityFlyweightMeta> efml, int temp, String race) {
		efml.add(new EntityFlyweightMeta(6*temp, temp, race+"Boss", 50,3,50,200));
		efml.add(new EntityFlyweightMeta(6*temp, temp, race+"Collector", 90,5,50,20));
		efml.add(new EntityFlyweightMeta(6*temp, temp, race+"Commander", 80,6.2f,50,100));
		efml.add(new EntityFlyweightMeta(6*temp, temp, race+"Deposit", 0,0,50,500));
		efml.add(new EntityFlyweightMeta(6*temp, temp*2, race+"MainBase", 0,0,50,1500));
		efml.add(new EntityFlyweightMeta(6*temp, temp, race+"Pawn", 70,6,50,50));
		efml.add(new EntityFlyweightMeta(6*temp, temp, race+"Player", 80,7,50,500));
		efml.add(new EntityFlyweightMeta(6*temp, temp/9, race+"Projectile", 50,8,100,8));
		efml.add(new EntityFlyweightMeta(6*temp, temp, race+"Scavenger", 50,3,50,30));
		efml.add(new EntityFlyweightMeta(6*temp, temp*2, race+"Spawner", 0,0,50,99999999));
		efml.add(new EntityFlyweightMeta(6*temp, temp, race+"Tower", 0,0,50,200));
	}

}

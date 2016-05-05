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
		//initDocument();
	}

	public HashMap<String, EntityFlyweightMeta> readDocument() {
		HashMap<String, EntityFlyweightMeta> flyweightMeta = new HashMap<String, EntityFlyweightMeta>();
		Json json = new Json();
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
		
		//rangeofSight,rangeOfCollision,upgrades,ClassName,accekeration, maxVelocity
		efml.add(new EntityFlyweightMeta(6*temp, temp, 0, "PrelateBoss", 50,3,50));
		efml.add(new EntityFlyweightMeta(6*temp, temp, 0, "PrelateCollector", 90,5,50));
		efml.add(new EntityFlyweightMeta(6*temp, temp, 0, "PrelateCommander", 80,6.2f,50));
		efml.add(new EntityFlyweightMeta(6*temp, temp, 0, "PrelateDeposit", 0,0,50));
		efml.add(new EntityFlyweightMeta(6*temp, temp, 0, "PrelateMainBase", 0,0,50));
		efml.add(new EntityFlyweightMeta(6*temp, temp, 0, "PrelatePawn", 70,6,50));
		efml.add(new EntityFlyweightMeta(6*temp, temp, 0, "PrelatePlayer", 80,7,50));
		efml.add(new EntityFlyweightMeta(6*temp, temp/9, 0, "PrelateProjectile", 50,8,100));
		efml.add(new EntityFlyweightMeta(6*temp, temp, 0, "PrelateScavenger", 50,3,50));
		efml.add(new EntityFlyweightMeta(6*temp, temp, 0, "PrelateSpawner", 0,0,50));
		efml.add(new EntityFlyweightMeta(6*temp, temp, 0, "PrelateTower", 0,0,50));

		efml.add(new EntityFlyweightMeta(6*temp, temp, 0, "DuckBoss", 50,3,50));
		efml.add(new EntityFlyweightMeta(6*temp, temp, 0, "DuckCommander", 80,6.2f,50));
		efml.add(new EntityFlyweightMeta(6*temp, temp, 0, "DuckPawn", 70,6,50));
		efml.add(new EntityFlyweightMeta(6*temp, temp/9, 0, "DuckProjectile", 50,8,100));
		efml.add(new EntityFlyweightMeta(6*temp, temp, 0, "DuckScavenger", 50,3,50));
		efml.add(new EntityFlyweightMeta(6*temp, temp, 0, "DuckSpawner", 0,0,50));
		efml.add(new EntityFlyweightMeta(6*temp, temp, 0, "DuckPlayer", 80,7,50));
		efml.add(new EntityFlyweightMeta(6*temp, temp, 0, "DuckCollector", 90,5,50));
		efml.add(new EntityFlyweightMeta(6*temp, temp, 0, "DuckDeposit", 0,0,50));
		efml.add(new EntityFlyweightMeta(6*temp, temp, 0, "DuckMainBase", 0,0,50));
		efml.add(new EntityFlyweightMeta(6*temp, temp, 0, "DuckTower", 0,0,50));

		Json json = new Json();
		FileHandle file = Gdx.files.local("flyweightentitymodel.json");
		file.writeString(json.toJson(efml), false);
	}

}

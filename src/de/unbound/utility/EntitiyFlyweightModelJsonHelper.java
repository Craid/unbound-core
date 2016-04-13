package de.unbound.utility;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

import de.unbound.game.model.EntityFlyweightModel;

public class EntitiyFlyweightModelJsonHelper {
	
	public static final EntitiyFlyweightModelJsonHelper instance = new EntitiyFlyweightModelJsonHelper();
	
	private EntitiyFlyweightModelJsonHelper(){
		//uncomment to update flyweightmodel.json
		//needs to be moved from desktop/<root> to android/assests/model/
		initDocument();
	}

	public HashMap<String, EntityFlyweightModel> readDocument() {
		HashMap<String, EntityFlyweightModel> flyweightUberModels = new HashMap<String, EntityFlyweightModel>();
		Json json = new Json();
		ArrayList<EntityFlyweightModel> list = json.fromJson(ArrayList.class, Gdx.files.internal("model/flyweightentitymodel.json"));
		for (EntityFlyweightModel v : list) {
			flyweightUberModels.put(v.getTextureName(), v);
		}
		return flyweightUberModels;
	}
	
	/**
	 * Only used to initialize the JSON File!
	 * Can be used for Generating new EntityFlyweightModel's
	 */
	private void initDocument() {
		ArrayList<EntityFlyweightModel> efml = new ArrayList<EntityFlyweightModel>();

		
		//rangeofSight,rangeOfCollision,upgrades,ClassName,atlas
		efml.add(new EntityFlyweightModel(3, 1, 0, "PrelateBoss", 50,3));
		efml.add(new EntityFlyweightModel(3, 1, 0, "PrelateCollector", 50,3));
		efml.add(new EntityFlyweightModel(3, 1, 0, "PrelateCommander", 50,3));
		efml.add(new EntityFlyweightModel(3, 1, 0, "PrelateDeposit", 50,3));
		efml.add(new EntityFlyweightModel(3, 1, 0, "PrelateMainBase", 50,3));
		efml.add(new EntityFlyweightModel(3, 1, 0, "PrelatePawn", 50,3));
		efml.add(new EntityFlyweightModel(3, 1, 0, "PrelatePlayer", 50,3));
		efml.add(new EntityFlyweightModel(3, 1, 0, "PrelateProjectile", 50,3));
		efml.add(new EntityFlyweightModel(3, 1, 0, "PrelateScavenger", 50,3));
		efml.add(new EntityFlyweightModel(3, 1, 0, "PrelateSpawner", 50,3));
		efml.add(new EntityFlyweightModel(3, 1, 0, "PrelateTower", 50,3));

		efml.add(new EntityFlyweightModel(3, 1, 0, "DuckBoss", 50,3));
		efml.add(new EntityFlyweightModel(3, 1, 0, "DuckCommander", 50,3));
		efml.add(new EntityFlyweightModel(3, 1, 0, "DuckPawn", 50,3));
		efml.add(new EntityFlyweightModel(3, 1, 0, "DuckProjectile", 50,3));
		efml.add(new EntityFlyweightModel(3, 1, 0, "DuckScavenger", 50,3));
		efml.add(new EntityFlyweightModel(3, 1, 0, "DuckSpawner", 50,3));
		efml.add(new EntityFlyweightModel(3, 1, 0, "DuckPlayer", 50,3));
		efml.add(new EntityFlyweightModel(3, 1, 0, "DuckCollector", 50,3));
		efml.add(new EntityFlyweightModel(3, 1, 0, "DuckDeposit", 50,3));
		efml.add(new EntityFlyweightModel(3, 1, 0, "DuckMainBase", 50,3));
		efml.add(new EntityFlyweightModel(3, 1, 0, "DuckTower", 50,3));

		Json json = new Json();
		FileHandle file = Gdx.files.local("flyweightentitymodel.json");
		file.writeString(json.toJson(efml), false);
	}

}

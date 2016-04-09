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
//		initDocument(); 
	}

	public HashMap<String, EntityFlyweightModel> readDocument() {
		HashMap<String, EntityFlyweightModel> flyweightUberModels = new HashMap<String, EntityFlyweightModel>();
		Json json = new Json();
		ArrayList<EntityFlyweightModel> list = json.fromJson(ArrayList.class, Gdx.files.internal("model/flyweightentitymodel.json"));
		for (EntityFlyweightModel v : list) {
			flyweightUberModels.put(v.getName(), v);
		}
		return flyweightUberModels;
	}
	
	/**
	 * Only used to initialize the JSON File!
	 * Can be used for Generating new EntityFlyweightModel's
	 */
	private void initDocument() {
		ArrayList<EntityFlyweightModel> ffml = new ArrayList<EntityFlyweightModel>();

		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelatePlayer", "Prelate"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelateBoss", "Prelate"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelateCollector", "Prelate"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelateCommander", "Prelate"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelatePawn", "Prelate"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelateProjectile", "Prelate"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelateScavenger", "Prelate"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelateBase", "Prelate"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelateDeposit", "Prelate"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelateMainBase", "Prelate"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelateSpawner", "Prelate"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelateTower", "Prelate"));

		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckPlayer", "Duck"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckBoss", "Duck"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckCollector", "Duck"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckCommander", "Duck"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckPawn", "Duck"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckProjectile", "Duck"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckScavenger", "Duck"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckBase", "Duck"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckDeposit", "Duck"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckMainBase", "Duck"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckSpawner", "Duck"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckTower", "Duck"));

		Json json = new Json();
		FileHandle file = Gdx.files.local("flyweightentitymodel.json");
		file.writeString(json.toJson(ffml), false);
	}

}

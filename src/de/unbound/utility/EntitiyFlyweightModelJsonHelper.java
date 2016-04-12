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
		//initDocument();
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
		ArrayList<EntityFlyweightModel> ffml = new ArrayList<EntityFlyweightModel>();

		
		//rangeofSight,rangeOfCollision,upgrades,ClassName,atlas
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelateBoss", "PrelateAttacker",50,3));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelateCommander", "PrelateAttacker",50,3));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelatePawn", "PrelateAttacker",50,3));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelateProjectile", "PrelateAttacker",50,3));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelateScavenger", "PrelateAttacker",50,3));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelateSpawner", "PrelateAttacker",50,3));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelatePlayer", "PrelateDefender",50,3));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelateCollector", "PrelateDefender",50,3));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelateDeposit", "PrelateDefender",50,3));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelateMainBase", "PrelateDefender",50,3));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "PrelateTower", "PrelateDefender",50,3));

		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckBoss", "DuckAttacker",50,3));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckCommander", "DuckAttacker",50,3));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckPawn", "DuckAttacker",50,3));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckProjectile", "DuckAttacker",50,3));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckScavenger", "DuckAttacker",50,3));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckSpawner", "DuckAttacker",50,3));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckPlayer", "DuckDefender",50,3));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckCollector", "DuckDefender",50,3));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckDeposit", "DuckDefender",50,3));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckMainBase", "DuckDefender",50,3));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "DuckTower", "DuckDefender",50,3));

		Json json = new Json();
		FileHandle file = Gdx.files.local("flyweightentitymodel.json");
		file.writeString(json.toJson(ffml), false);
	}

}

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

		ffml.add(new EntityFlyweightModel(3, 1, 0, "Boss", "PrelateAttacker"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "Commander", "PrelateAttacker"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "Pawn", "PrelateAttacker"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "Projectile", "PrelateAttacker"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "Scavenger", "PrelateAttacker"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "Spawner", "PrelateAttacker"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "Player", "PrelateDefender"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "Collector", "PrelateDefender"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "Deposit", "PrelateDefender"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "MainBase", "PrelateDefender"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "Tower", "PrelateDefender"));

		ffml.add(new EntityFlyweightModel(3, 1, 0, "Boss", "DuckAttacker"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "Commander", "DuckAttacker"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "Pawn", "DuckAttacker"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "Projectile", "DuckAttacker"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "Scavenger", "DuckAttacker"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "Spawner", "DuckAttacker"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "Player", "DuckDefender"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "Collector", "DuckDefender"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "Deposit", "DuckDefender"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "MainBase", "DuckDefender"));
		ffml.add(new EntityFlyweightModel(3, 1, 0, "Tower", "DuckDefender"));

		Json json = new Json();
		FileHandle file = Gdx.files.local("flyweightentitymodel.json");
		file.writeString(json.toJson(ffml), false);
	}

}

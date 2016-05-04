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

		//TODO uncomment to update flyweightmodel.json
		//needs to be moved from desktop/<root> to android/assests/model/
		//initDocument();
	}

	public HashMap<String, EntityFlyweightModel> readDocument() {
		HashMap<String, EntityFlyweightModel> flyweightUberModels = new HashMap<String, EntityFlyweightModel>();
		Json json = new Json();
		ArrayList<EntityFlyweightModel> list = json.fromJson(ArrayList.class, Gdx.files.internal("model/flyweightentitymodel.json"));
		for (EntityFlyweightModel v : list) 
			flyweightUberModels.put(v.getTextureName(), v);
		
		return flyweightUberModels;
	}
	
	/**
	 * Only used to initialize the JSON File!
	 * Can be used for Generating new EntityFlyweightModel's
	 */
	private void initDocument() {
		ArrayList<EntityFlyweightModel> efml = new ArrayList<EntityFlyweightModel>();

		int smallEntity = UnboundConstants.SINGLEGRIDHEIGHT/2;
		int bigEntity = UnboundConstants.SINGLEBIGUNITWIDTH;
		
		//rangeofSight,rangeOfCollision,upgrades,ClassName,accekeration, maxVelocity
		efml.add(new EntityFlyweightModel(6*smallEntity, smallEntity, 0, "PrelateBoss", 50,3));
		efml.add(new EntityFlyweightModel(6*smallEntity, smallEntity, 0, "PrelateCollector", 90,5));
		efml.add(new EntityFlyweightModel(6*smallEntity, smallEntity, 0, "PrelateCommander", 80,6.2f));
		efml.add(new EntityFlyweightModel(6*smallEntity, smallEntity, 0, "PrelateDeposit", 0,0));
		efml.add(new EntityFlyweightModel(6*smallEntity, bigEntity, 0, "PrelateMainBase", 0,0));
		efml.add(new EntityFlyweightModel(6*smallEntity, smallEntity, 0, "PrelatePawn", 70,6));
		efml.add(new EntityFlyweightModel(6*smallEntity, smallEntity, 0, "PrelatePlayer", 80,7));
		efml.add(new EntityFlyweightModel(6*smallEntity, smallEntity/9, 0, "PrelateProjectile", 50,8));
		efml.add(new EntityFlyweightModel(6*smallEntity, smallEntity, 0, "PrelateScavenger", 50,3));
		efml.add(new EntityFlyweightModel(6*smallEntity, bigEntity, 0, "PrelateSpawner", 0,0));
		efml.add(new EntityFlyweightModel(6*smallEntity, smallEntity, 0, "PrelateTower", 0,0));

		efml.add(new EntityFlyweightModel(6*smallEntity, smallEntity, 0, "DuckBoss", 50,3));
		efml.add(new EntityFlyweightModel(6*smallEntity, smallEntity, 0, "DuckCommander", 80,6.2f));
		efml.add(new EntityFlyweightModel(6*smallEntity, smallEntity, 0, "DuckPawn", 70,6));
		efml.add(new EntityFlyweightModel(6*smallEntity, smallEntity/9, 0, "DuckProjectile", 50,8));
		efml.add(new EntityFlyweightModel(6*smallEntity, smallEntity, 0, "DuckScavenger", 50,3));
		efml.add(new EntityFlyweightModel(6*smallEntity, bigEntity, 0, "DuckSpawner", 0,0));
		efml.add(new EntityFlyweightModel(6*smallEntity, smallEntity, 0, "DuckPlayer", 80,7));
		efml.add(new EntityFlyweightModel(6*smallEntity, smallEntity, 0, "DuckCollector", 90,5));
		efml.add(new EntityFlyweightModel(6*smallEntity, smallEntity, 0, "DuckDeposit", 0,0));
		efml.add(new EntityFlyweightModel(6*smallEntity, bigEntity, 0, "DuckMainBase", 0,0));
		efml.add(new EntityFlyweightModel(6*smallEntity, smallEntity, 0, "DuckTower", 0,0));

		Json json = new Json();
		FileHandle file = Gdx.files.local("flyweightentitymodel.json");
		file.writeString(json.toJson(efml), false);
	}

}

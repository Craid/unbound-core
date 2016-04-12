package de.unbound.utility;

import java.util.HashMap;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;

public class AssetsManagingHelper implements Disposable{

	public static final String TAG = AssetsManagingHelper.class.getName();
	
	public HashMap<String, RaceAssetsModel> raceAssets;
	private AssetManager assetManager;
	private static final String ATTACKER = "Attacker", DEFENDER = "Defender";

	public static final AssetsManagingHelper instance = new AssetsManagingHelper();

	private AssetsManagingHelper(){
		init();
	}
	
	public void init(){
		this.assetManager = new AssetManager();
		raceAssets = new HashMap<String, RaceAssetsModel>();
		
		String[] races = {"Duck","Prelate"};
		

		assetManager.load("img/duck/DuckDefender.pack", TextureAtlas.class);
		assetManager.load("img/prelate/PrelateAttacker.pack", TextureAtlas.class);
		
//		for(String race : races)
//			initLoadRaceAssets(race);
		
		//Synchrones laden!
		assetManager.finishLoading();
		
		updateTextureFilterAndAddToRaceAssetsMap("Duck", DEFENDER);
		updateTextureFilterAndAddToRaceAssetsMap("Prelate", ATTACKER);
		
//		for(String race : races)
//			finishLoadRaceAssets(race);
		
	}
	
	/**
	 * 
	 * @param race
	 */
	private void initLoadRaceAssets(String race){
		assetManager.load("img/"+race.toLowerCase()+"/"+race+"Attacker.pack", TextureAtlas.class);
		assetManager.load("img/"+race.toLowerCase()+"/"+race+"Defender.pack", TextureAtlas.class);
	}
	
	/**
	 * 
	 * @param race
	 */
	private void finishLoadRaceAssets(String race){
		updateTextureFilterAndAddToRaceAssetsMap(race, ATTACKER);
		updateTextureFilterAndAddToRaceAssetsMap(race, DEFENDER);
	}

	private void updateTextureFilterAndAddToRaceAssetsMap(String race, String type) {
		TextureAtlas atlas = assetManager.get("img/"+race.toLowerCase()+"/"+race+type+".pack");
		for(Texture t : atlas.getTextures())
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		raceAssets.put(race+type, new RaceAssetsModel(atlas));
	}
	
	public Sprite getSprite(String atlas, String name){
		if(raceAssets.get(atlas) != null && raceAssets.get(atlas).getSprite(name) != null)
			return raceAssets.get(atlas).getSprite(name);
		return new Sprite();
	}
	
	public void dispose() {
		for(RaceAssetsModel ram : raceAssets.values())
			ram.dispose();
	}
	
}

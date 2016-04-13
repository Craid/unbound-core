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
	
	public RaceAssetsModel raceAssets;
	private AssetManager assetManager;

	public static final AssetsManagingHelper instance = new AssetsManagingHelper();

	private AssetsManagingHelper(){
		init();
	}
	
	public void init(){
		this.assetManager = new AssetManager();

		assetManager.load("img/races.pack", TextureAtlas.class);
		
		//Synchrones laden!
		assetManager.finishLoading();
		
		TextureAtlas atlas = assetManager.get("img/races.pack");
		for(Texture t : atlas.getTextures())
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		raceAssets = new RaceAssetsModel(atlas);
	}

	
	public Sprite getSprite(String name){
		if(raceAssets.getSprite(name) != null)
			return raceAssets.getSprite(name);
		return new Sprite();
	}
	
	public void dispose() {
		raceAssets.dispose();
	}
	
}

package de.unbound.utility;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Disposable;

public class AssetsManager implements Disposable{

	public static final String TAG = AssetsManager.class.getName();
	
	public AssetPrelate prelate;
	public AssetDuckOwn duckOwn;
	private AssetManager assetManager;

	public static final AssetsManager instance = new AssetsManager();

	//Singleton pattern
	private AssetsManager(){}
	
	public void init(AssetManager assetManager){
		this.assetManager = assetManager;
		
		//NOTE: This is like the Swing-MediaTracker
		assetManager.load("model/img/duck/Duck.atlas", TextureAtlas.class);
		assetManager.load("model/img/prelate/Prelate.atlas", TextureAtlas.class);
		
		//assetManager.load("music/ForestNoises.mp3", Music.class); 
		//Music is streamed directly from the location and mustn't be loaded 
		//Because Of The Low RAM On Smartphones
		//Loading the Sound Files Into The Sound Manager HashMap
		//SoundManager.load("sounds/Jump_Gras.mp3", "Jump_Gras");
		
		assetManager.finishLoading();
		Gdx.app.log(TAG,"Finished loading!");
		//The data is now allocated in the RAM 
		
		//Gets the Textures and the TextureRegions
		TextureAtlas atlas = assetManager.get("model/img/duck/Duck.atlas");
		//With TextureFilters we can smooth the pixel when upscaled or downscaled
		for(Texture t : atlas.getTextures()){
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}
		
		//Gets the Textures and the TextureRegions
		atlas = assetManager.get("model/img/prelate/Prelate.atlas");
		//With TextureFilters we can smooth the pixel when upscaled or downscaled
		for(Texture t : atlas.getTextures()){
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}

		//The TextureRegions are assigned in the Constructors of these Inner-Classes
		duckOwn = new AssetDuckOwn(atlas);
		prelate = new AssetPrelate(atlas);
	}
	
	public class AssetDuckOwn{
		public final Sprite deposit, mainBase, spawner, tower;
		
		public AssetDuckOwn(TextureAtlas atlas){
			deposit = new Sprite(atlas.findRegion("DuckDeposit"));
			mainBase = new Sprite(atlas.findRegion("DuckMainBase"));
			spawner = new Sprite(atlas.findRegion("DuckSpawner"));
			tower = new Sprite(atlas.findRegion("DuckTower"));
		}
		
		private Sprite getSprite(String name){
			switch(name){
			case "DuckDeposit": return deposit;
			case "DuckMainBase": return mainBase;
			case "DuckSpawner": return spawner;
			case "DuckTower": return tower;
			}
			return new Sprite();
		}
	}
	
	public class AssetPrelate{
		public final Sprite pawn, projectile, boss,commander,scavenger;
		
		public AssetPrelate(TextureAtlas atlas){
			pawn = new Sprite(atlas.findRegion("PrelatePawn"));
			projectile = new Sprite(atlas.findRegion("PrelateProjectile"));
			boss = new Sprite(atlas.findRegion("PrelateBoss"));
			commander = new Sprite(atlas.findRegion("PrelateCommander"));
			scavenger = new Sprite(atlas.findRegion("PrelateScavenger"));
		}
		
		private Sprite getSprite(String name){
			switch(name){
			case "PrelatePawn": return pawn;
			case "PrelateProjectile": return projectile;
			case "PrelateBoss": return boss;
			case "PrelateCommander": return commander;
			case "PrelateScavenger": return scavenger;
			}
			return new Sprite();
		}
		
	}
	
	public Sprite getSprite(String atlas, String name){
		switch(atlas){
		case "DuckOwn": return duckOwn.getSprite(name);
		case "Prelate": return prelate.getSprite(name);
		}
		return new Sprite();
	}
	
	public void dispose() {
		assetManager.dispose();
		
	}
	
}

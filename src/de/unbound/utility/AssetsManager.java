package de.unbound.utility;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Disposable;

public class AssetsManager implements Disposable{

	public static final String TAG = AssetsManager.class.getName();
	
	public AssetPlayer player;
	public AssetWall wall;
	public AssetEnemy enemy;
	private AssetManager assetManager;

	public static final AssetsManager instance = new AssetsManager();

	//Singleton pattern
	private AssetsManager(){}
	
	public void init(AssetManager assetManager){
		this.assetManager = assetManager;
		//NOTE: This is like the Swing-MediaTracker
		assetManager.load("img/testLevel.pack", TextureAtlas.class);
//		assetManager.load("sounds/Jump_Gras.mp3", Sound.class);
//		assetManager.load("sounds/JumpOnGrass.mp3", Sound.class);
//		assetManager.load("sounds/LandOnAnything.mp3", Sound.class);
		//assetManager.load("music/ForestNoises.mp3", Music.class); 
		//Music is streamed directly from the location and mustn't be loaded 
		//Because Of The Low RAM On Smartphones
		assetManager.finishLoading();
		Gdx.app.log(TAG,"Finished loading!");
		//The data is now allocated in the RAM 
		
//		//Loading the Sound Files Into The Sound Manager HashMap
//		SoundManager.load("sounds/Jump_Gras.mp3", "Jump_Gras");
//		SoundManager.load("sounds/JumpOnGrass.mp3", "JumpOnGrass");
//		SoundManager.load("sounds/LandOnAnything.mp3", "LandOnAnything");
		
		//Gets the Textures and the TextureRegions
		TextureAtlas atlas = assetManager.get("img/testLevel.pack");
		//With TextureFilters we can smooth the pixel when upscaled or downscaled
		for(Texture t : atlas.getTextures()){
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}

		//The TextureRegions are assigned in the Constructors of these Inner-Classes
		player = new AssetPlayer(atlas);
		wall = new AssetWall(atlas);
		enemy = new AssetEnemy(atlas);
		
		
	}
	
	public class AssetPlayer{
		public final AtlasRegion player;
		
		public AssetPlayer(TextureAtlas atlas){
			player = atlas.findRegion("Main");
		}
	}
	
	public class AssetWall{
		public final AtlasRegion edgeLeft;
		public final AtlasRegion edgeRight;
		public final AtlasRegion borderLeft;
		public final AtlasRegion borderRight;
		public final AtlasRegion top;
		public final AtlasRegion all;
		
		public AssetWall(TextureAtlas atlas){
			top = atlas.findRegion("001TOP");
			all = atlas.findRegion("002ALL");
			edgeLeft = atlas.findRegion("003LEFTEDGE");
			edgeRight = atlas.findRegion("004RIGHTEDGE");
			borderLeft = atlas.findRegion("005LEFTBORDER");
			borderRight = atlas.findRegion("006RIGHTBORDER");
		}
	}
	
	public class AssetEnemy{
		public final AtlasRegion enemy;
		
		public AssetEnemy(TextureAtlas atlas){
			enemy = atlas.findRegion("Enemy");
		}
	}

	public void dispose() {
		assetManager.dispose();
		
	}
	
}

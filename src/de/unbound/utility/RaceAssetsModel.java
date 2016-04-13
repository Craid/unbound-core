package de.unbound.utility;

import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Disposable;

public class RaceAssetsModel implements Disposable{
	
	private final HashMap<String,Sprite> sprites;
	
	public RaceAssetsModel(TextureAtlas atlas){
		sprites = new HashMap<String, Sprite>();
		for(AtlasRegion ar : atlas.getRegions()){
			Sprite e = new Sprite(ar);
			e.setOriginCenter();
			sprites.put(ar.name, e);
		}
	}
	
	public Sprite getSprite(String name){
		try{
			return sprites.get(name);
		}catch(Exception e){}
		return new Sprite();
	}

	@Override
	public void dispose() {
		for(Sprite sprite : sprites.values())
			sprite.getTexture().dispose();
	}

}

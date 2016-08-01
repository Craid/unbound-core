package de.unbound.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameCamera extends OrthographicCamera{
	
	
	public GameCamera(int width, int height){
		super(width,height);
		
		initialize();
	}
	
	public GameCamera() {
		this(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
	}
	
	private void initialize(){
		//camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
	}
	
}

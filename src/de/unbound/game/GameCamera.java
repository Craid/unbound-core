package de.unbound.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameCamera extends OrthographicCamera{
	
	public static GameCamera camera;
	
	public static GameCamera getInstance(){
		if(camera == null)
			camera = new GameCamera();
		return camera;
	}

	private GameCamera() {
		super(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		initialize();
	}
	
	private void initialize(){
		//camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
	}
	
}

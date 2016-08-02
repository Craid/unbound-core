package de.unbound.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.entities.Entity;
import de.unbound.utility.UnboundConstants;

public class GameCamera extends OrthographicCamera{
	

	private Vector2 upperCorner, halfViewport;
	
	
	public GameCamera(int width, int height){
		super(width,height);
		
		init();
	}
	
	public GameCamera() {
		this(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
	}
	
	private void init(){
		upperCorner = new Vector2(UnboundConstants.WORLDWIDTH,UnboundConstants.WORLDHEIGHT);
		halfViewport = new Vector2(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
	}
	
	public void setPositionToEntity(Entity e){
		float entityPosX = e.getPosition().x;
		float entityPosY = e.getPosition().y;
		
		position.x = MathUtils.clamp(entityPosX, halfViewport.x, upperCorner.x - halfViewport.x);
		position.y = MathUtils.clamp(entityPosY, halfViewport.y*2, upperCorner.y - halfViewport.y);
		
		zoom = 2.4f;
		update();
	}
	
}

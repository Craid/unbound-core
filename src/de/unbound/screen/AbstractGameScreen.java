package de.unbound.screen;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;

import de.unbound.UnboundGame;

public abstract class AbstractGameScreen implements Screen {
	
	protected UnboundGame game;

	public AbstractGameScreen (UnboundGame game) {
		this.game = game;
	}

	public abstract void render (float deltaTime);

	public void resize (int width, int height){}

	public void show(){}

	public void hide(){}

	public void pause(){}

	public InputProcessor getInputProcessor(){ return null;}

	public void resume(){}

	public void dispose(){}
}

package de.unbound.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.InputProcessor;

import de.unbound.game.World;
import de.unbound.game.wave.LocaleEndlessWaveHandler;

public class GameScreen extends AbstractGameScreen{
	
	private World world;

	public GameScreen(Game game) {
		super(game);
		world = new World(LocaleEndlessWaveHandler.createLocaleEndlessWaveHandlerPreset());
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float deltaTime) {
		world.update(deltaTime);
	}

	@Override
	public void resize(int w, int h) {
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InputProcessor getInputProcessor() {
		// TODO Auto-generated method stub
		return null;
	}
}
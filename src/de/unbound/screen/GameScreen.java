package de.unbound.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;

import de.unbound.game.World;
import de.unbound.game.inputhandling.ActionSequencer;
import de.unbound.game.inputhandling.handler.PCInputHandler;
import de.unbound.game.wave.LocaleEndlessWaveHandler;

public class GameScreen extends AbstractGameScreen{
	
	private World world;
	private ActionSequencer sequence;

	public GameScreen(Game game) {
		super(game);
		world = new World(LocaleEndlessWaveHandler.createLocaleEndlessWaveHandlerPreset());
		initializeInputProcessor();
	}

	private void initializeInputProcessor(){
		//Hier muss noch geprüft werden, ob Android oder Desktop(Maus und Tastatur) angewandt wird
		InputMultiplexer im = new InputMultiplexer();
		//InputProcessor ip = new PCInputHandler();
		PCInputHandler ip = new PCInputHandler();
		im.addProcessor(ip);
		Gdx.input.setInputProcessor(im);
		sequence =  ip.getSequencer();
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
		sequence.update();
		
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
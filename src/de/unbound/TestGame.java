package de.unbound;

import com.badlogic.gdx.Gdx;

import de.unbound.screen.StartScreen;

public class TestGame extends UnboundGame {
	
	@Override
	public void create () {
		//screen = new GameScreen(this,LocaleEndlessWaveHandler.createLocaleEndlessWaveHandlerPreset(),new LocalGameUpdate());
		screen = new StartScreen(this);
	}

	@Override
	public void render () {
		screen.render(Gdx.graphics.getDeltaTime());
	}
	
}

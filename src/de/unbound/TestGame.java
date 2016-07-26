package de.unbound;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import de.unbound.game.logic.LocalGameUpdate;
import de.unbound.game.wave.LocaleEndlessWaveHandler;
import de.unbound.screen.AbstractGameScreen;
import de.unbound.screen.GameScreen;

public class TestGame extends Game {
	
	private AbstractGameScreen screen;
	
	@Override
	public void create () {
		screen = new GameScreen(this,LocaleEndlessWaveHandler.createLocaleEndlessWaveHandlerPreset(),new LocalGameUpdate());
	}

	@Override
	public void render () {
		screen.render(Gdx.graphics.getDeltaTime());
	}
}

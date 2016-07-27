package de.unbound;

import com.badlogic.gdx.Gdx;

import de.unbound.screen.AbstractGameScreen;
import de.unbound.screen.StartScreen;

public class TestMenuGame extends UnboundGame {
	
	private AbstractGameScreen screen;
	
	@Override
	public void create () {
		screen = new StartScreen(this);
	}

	@Override
	public void render () {
		screen.render(Gdx.graphics.getDeltaTime());
	}
}

package de.unbound;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import de.unbound.screen.AbstractGameScreen;
import de.unbound.screen.SplashScreen;

public class UnboundGame extends Game {
	
	private AbstractGameScreen screen;
	
	
	@Override
	public void create () {
		screen = new SplashScreen(this);
	}

	@Override
	public void render () {
		screen.render(Gdx.graphics.getDeltaTime());
	}
}

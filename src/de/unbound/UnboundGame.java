package de.unbound;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import de.unbound.screen.AbstractGameScreen;
import de.unbound.screen.SplashScreen;

public class UnboundGame extends Game {
	
	protected AbstractGameScreen screen;
	
	@Override
	public void create () {
		screen = new SplashScreen(this);
		System.out.println("Started!");
	}
	
	@Override
	public void render () {
		screen.render(Gdx.graphics.getDeltaTime());
	}
	
	public void setScreen(AbstractGameScreen screen){
		System.out.println("Set new screen");
		this.screen = screen;
	}
}

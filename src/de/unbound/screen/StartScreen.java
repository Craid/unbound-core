package de.unbound.screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.unbound.UnboundGame;
import de.unbound.game.logic.LocalGameUpdate;
import de.unbound.game.wave.LocaleEndlessWaveHandler;

public class StartScreen extends AbstractGameScreen{

	OrthographicCamera camera;
	UnboundGame game;
	SpriteBatch batch;
	BitmapFont font;
	
	public StartScreen(UnboundGame game) { 
		super(game); 
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		this.game = game;
		batch = new SpriteBatch();
		font = new BitmapFont();
	}
/*
Exception in thread "LWJGL Application" com.badlogic.gdx.utils.GdxRuntimeException: java.lang.ExceptionInInitializerError
	at com.badlogic.gdx.backends.lwjgl.LwjglApplication$1.run(LwjglApplication.java:127)
Caused by: java.lang.ExceptionInInitializerError
	at de.unbound.game.factories.FlyweightFactory.createEntityFlywight(FlyweightFactory.java:48)
	at de.unbound.game.factories.FlyweightFactory.getFlyweight(FlyweightFactory.java:33)
	at de.unbound.game.factories.EntityFactory.createEntity(EntityFactory.java:84)
	at de.unbound.game.factories.EntityFactory.createMap(EntityFactory.java:36)
	at de.unbound.game.wave.WaveHandler.setBattleFieldForFactories(WaveHandler.java:31)
	at de.unbound.game.World.setGameRules(World.java:44)
	at de.unbound.screen.GameScreen.<init>(GameScreen.java:22)
	at de.unbound.screen.StartScreen.render(StartScreen.java:61)
	at de.unbound.TestGame.render(TestGame.java:18)
	*/ 
	//er wirft immernoch fehler X.X Json ist neu reingekommen. Glaub sogar von dir. 
	// ok, moment ich mache skype an
	
	//yup hab es gerade nochmal aktualisiert
	//kurz skype video übertragung? hab aber kein mikro :(
	//egal muss ja nur kurz sehen, was da abgeht
	
	//s0
	
	@Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        
        font.draw(batch, "Unbound Startscreen", 100, 150);
        font.draw(batch, "(Vorerst) Klicke mit der Maus/Touchpad 1x um das Spiel zu starten", 100, 100);
        batch.end();
        // moment
        if (Gdx.input.isTouched()) { 
            game.setScreen(new GameScreen(game,LocaleEndlessWaveHandler.createLocaleEndlessWaveHandlerPreset(),new LocalGameUpdate()));
            dispose();
        }
    }
}
package de.unbound.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;

import de.unbound.UnboundGame;
import de.unbound.game.World;
import de.unbound.game.inputhandling.ActionSequencer;
import de.unbound.game.inputhandling.handler.PCInputHandler;
import de.unbound.game.mode.GameMode;

public class GameScreen extends AbstractGameScreen {

	private World world;
	private ActionSequencer sequence;

	public GameScreen(UnboundGame game, GameMode gameMode) {
		super(game);
		world = World.getInstance();
		world.setGameMode(gameMode);
		initializeInputProcessor();
	}

	private void initializeInputProcessor() {
		// Hier muss noch geprÃ¼ft werden, ob Android oder Desktop(Maus und
		// Tastatur) angewandt wird
		InputMultiplexer im = new InputMultiplexer();
		// InputProcessor ip = new PCInputHandler();
		PCInputHandler ip = new PCInputHandler();
		im.addProcessor(ip);
		Gdx.input.setInputProcessor(im);

		// TODO das hier ist seltsam! warum gibt es nur einen sequencer?
		// therotisch können mehrere Input Module registriert werden
		sequence = ip.getSequencer();
	}

	@Override
	public void render(float deltaTime) {
		world.update(deltaTime);
		sequence.update();
	}

}
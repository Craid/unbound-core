package de.unbound.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import de.unbound.UnboundGame;
import de.unbound.game.mode.client.ClientSurvivalGameMode;
import de.unbound.game.mode.client.util.ClientSurvivalConfig;
import de.unbound.game.mode.client.util.TCPInitCommandHandler;
import de.unbound.game.mode.local.LocalEndlessGameMode;
import de.unbound.game.network.ConnectionHandler;

public class StartScreen extends AbstractGameScreen {

	OrthographicCamera camera;
	UnboundGame game;
	SpriteBatch batch;
	BitmapFont font;
	Skin skin;
	Stage stage;
	String userInputIP = "localhost";
	boolean startMultiplayer = false;
	private boolean clickedMultiplayer;
	protected ConnectionHandler connectionHandler;
	protected TCPInitCommandHandler handler;

	public StartScreen(UnboundGame game) {
		super(game);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		this.game = game;
		batch = new SpriteBatch();
		font = new BitmapFont();
		clickedMultiplayer = false;
		create();
	}

	public void create() {
		batch = new SpriteBatch();
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		// A skin can be loaded via JSON or defined programmatically, either is
		// fine. Using a skin is optional but strongly
		// recommended solely for the convenience of getting a texture, region,
		// etc as a drawable, tinted drawable, etc.
		skin = new Skin();
		// Generate a 1x1 white texture and store it in the skin named "white".
		Pixmap pixmap = new Pixmap(400, 100, Format.RGBA8888);
		pixmap.setColor(Color.GREEN);
		pixmap.fill();

		skin.add("white", new Texture(pixmap));

		// Store the default libgdx font under the name "default".
		BitmapFont bfont = new BitmapFont();
		// bfont.scale(1);
		skin.add("default", bfont);

		// Configure a TextButtonStyle and name it "default". Skin resources are
		// stored by type, so this doesn't overwrite the font.
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.down = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
		textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);

		textButtonStyle.font = skin.getFont("default");

		skin.add("default", textButtonStyle);

		// Create a button with the "default" TextButtonStyle. A 3rd parameter
		// can be used to specify a name other than "default".
		final TextButton buttonSinglePlayer = new TextButton(
				"Play Singleplayer", textButtonStyle);
		buttonSinglePlayer.setPosition(200, 350);
		stage.addActor(buttonSinglePlayer);

		// Add a listener to the button. ChangeListener is fired when the
		// button's checked state changes, eg when clicked,
		// Button#setChecked() is called, via a key press, etc. If the
		// event.cancel() is called, the checked state will be reverted.
		// ClickListener could have been used, but would only fire when clicked.
		// Also, canceling a ClickListener event won't
		// revert the checked state.
		buttonSinglePlayer.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				buttonSinglePlayer.setText("Starting new game");
				game.setScreen(new GameScreen(game, new LocalEndlessGameMode()));
			}
		});
		final TextButton buttonMultiPlayer = new TextButton("Play Multiplayer",
				textButtonStyle);
		buttonMultiPlayer.setPosition(200, 200);
		stage.addActor(buttonMultiPlayer);

		// Add a listener to the button. ChangeListener is fired when the
		// button's checked state changes, eg when clicked,
		// Button#setChecked() is called, via a key press, etc. If the
		// event.cancel() is called, the checked state will be reverted.
		// ClickListener could have been used, but would only fire when clicked.
		// Also, canceling a ClickListener event won't
		// revert the checked state.
		buttonMultiPlayer.addListener(new ChangeListener() {
			
			public void changed(ChangeEvent event, Actor actor) {
				connectionHandler = new ConnectionHandler();
				handler = new TCPInitCommandHandler(connectionHandler);
				clickedMultiplayer = true;
			}
			
		});

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		// font.draw(batch, "Unbound Startscreen", 100, 150);
		// font.draw(batch,
		// "(Vorerst) Klicke mit der Maus/Touchpad 1x um das Spiel zu starten",
		// 100, 100);
		batch.end();
		if(clickedMultiplayer)
			handleMultiplayer();
	}
	
	private void handleMultiplayer(){
		if(!handler.isAllReceived()){
			handler.handleInput();
		}else{
			connectionHandler.setInitializedConnection(true);
		
			ClientSurvivalConfig config = new ClientSurvivalConfig();
			config.desList = handler.getDesList();
			config.connectionHandler = connectionHandler;

			System.out.println("Starting new game");
			game.setScreen(new GameScreen(game, new ClientSurvivalGameMode(config)));
			System.out.println("Started");
		}
	}
	
}
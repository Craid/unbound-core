package de.unbound.game.mode.client;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.unbound.game.GameCamera;
import de.unbound.game.World;
import de.unbound.game.mode.AbstractGameUpdate;
import de.unbound.game.mode.client.util.ClientSurvivalConfig;
import de.unbound.game.mode.client.util.EntityUpdater;
import de.unbound.game.mode.client.util.TCPGameCommandHandler;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.network.ConnectionHandler;
import de.unbound.game.network.serialization.PacketDeserializer;
import de.unbound.game.network.serialization.PacketSerializer;

public class ClientSurvivalGameUpdate extends AbstractGameUpdate {

	private BitmapFont font;
	private SpriteBatch batch;
	private SpriteBatch hudBatch;
	private double timeStamp;
	public PacketDeserializer packetDeserializer;
	private PacketSerializer packetSerializer;
	private byte[] clientData;
	private EntityUpdater entityUdpater;
	private ConnectionHandler connectionHandler;
	private TCPGameCommandHandler tcpCommandHandler;
	

	public ClientSurvivalGameUpdate(ClientSurvivalConfig config) {
		super(new ClientSurvivalCollisionDetection());
		init();
		timeStamp = -1;
		packetDeserializer = new PacketDeserializer();
		packetSerializer = new PacketSerializer();
		clientData = new byte[8+29]; //timestamp + entity data for player
		
		connectionHandler = config.connectionHandler;
		connectionHandler.startUDP();
		
		entityUdpater = new EntityUpdater(this);
		
		tcpCommandHandler = new TCPGameCommandHandler(connectionHandler.tcpConnecter);
		
	}

	protected void init() {
		batch = new SpriteBatch();
		hudBatch = new SpriteBatch();
		camera = new GameCamera();
		font = new BitmapFont();
	}

	@Override
	public boolean isGameOver() {
		return battleField.getMainBase().isActive();
	}	
	
	@Override
	public void doBeforeUpdate() {
		handleUDPInput();
		tcpCommandHandler.handleInput();
	}


	private void handleUDPInput() {
		byte[] data = connectionHandler.udpReceiver.getLatestBytes();
		double tempTimeStamp = packetDeserializer.getTimeStampFromByteArray(data);
		if(tempTimeStamp > timeStamp){
			timeStamp = tempTimeStamp;
			entityUdpater.updateEntities(data);
		}else{
			//ignore packet!
		}
	}

	@Override
	public void onCollisionHandling(double deltaTime) {
		collisionDetection.update(deltaTime);
	}

	@Override
	public void doAfterUpdate() {
		render();
		sendPlayerToServer();
	}

	private void sendPlayerToServer() {
		int index = 0;
		for(byte b : packetSerializer.getTimeStampAsByteArray())
			clientData[index++] = b;
		for(byte b : packetSerializer.getPlayerAsByteArray())
			clientData[index++] = b;
		
		connectionHandler.udpSender.sendData(clientData);
	}

	@Override
	public void onGameEnd() {
		renderGameOver();
	}


	public void render() {
		Gdx.gl.glClearColor( 0, 0, 0.10f, 1 );
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
		updateCameraPosition();
		batch.setProjectionMatrix(camera.combined); 
		batch.begin();
		background.draw(batch);
		
		for(Entity e : battleField.getGameObjects()){
			e.render(batch);
		}
		renderEntity(battleField.getPlayers().get(0));
		
		batch.end();
		hudBatch.begin();
		String temp = String.format("Punkte: %010d", battleField.getScore());
		font.draw(hudBatch, temp, Gdx.graphics.getWidth()-140, Gdx.graphics.getHeight()-15);
		temp = String.format("Player-HP: %03d/500", (int)battleField.getPlayers().get(0).getHp());
		font.draw(hudBatch, temp, 10, Gdx.graphics.getHeight()-30);
		temp = String.format("MainBase-HP: %03d/1500", (int)battleField.getMainBase().getHp());
		font.draw(hudBatch, temp, 10, Gdx.graphics.getHeight()-15);
		hudBatch.end();
	}
	
	private void renderGameOver() {
		render();
		hudBatch.begin();
		String temp = "GameOver!";
		font.draw(hudBatch, temp, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		hudBatch.end();
	}

	private void updateCameraPosition(){
		camera.setPositionToEntity(followingEntity);
	}

	@Override
	public void updateWaveHandler(double deltaTime) {
		
	}

	@Override
	public void renderEntity(Entity e) {
		Sprite sprite = e.getModel().getGraphic();
		sprite.setPosition(e.getPosition().x-(sprite.getWidth()/2), e.getPosition().y-(sprite.getHeight()/2));
		sprite.setRotation(e.getDirection().angle());
		if(World.getInstance().isOnScreen(e))
			sprite.draw(batch);
	}

	@Override
	public boolean isPaused() {
		return false;
	}

	@Override
	public void onGamePaused() {
		//do nothing!
	}

}

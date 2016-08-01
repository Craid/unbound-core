package de.unbound.game.mode.client;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.sun.xml.internal.ws.api.policy.PolicyResolver.ClientContext;

import de.unbound.game.GameCamera;
import de.unbound.game.World;
import de.unbound.game.factories.EntityFactory;
import de.unbound.game.factories.FlyweightFactory;
import de.unbound.game.mode.AbstractGameUpdate;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.EntityFlyweight;
import de.unbound.game.network.ConnectionHandler;
import de.unbound.game.network.serialization.PacketDeserializer;
import de.unbound.game.network.serialization.PacketDeserializer.DeserializedEntity;
import de.unbound.game.network.serialization.PacketSerializer;
import de.unbound.utility.UnboundConstants;

public class ClientSurvivalGameUpdate extends AbstractGameUpdate {

	private BitmapFont font;
	private SpriteBatch batch;
	private SpriteBatch hudBatch;
	private double timeStamp;
	private PacketDeserializer packetDeserializer;
	private PacketSerializer packetSerializer;
	private byte[] clientData;

	public ClientSurvivalGameUpdate() {
		super(new ClientSurvivalCollisionDetection());
		init();
		timeStamp = -1;
		packetDeserializer = new PacketDeserializer();
		packetSerializer = new PacketSerializer();
		clientData = new byte[8+29]; //timestamp + entity data for player
		ConnectionHandler.getInstance().startUDP();
		background.setScale(1.33f*battleField.getScaleX(), 1.08f*battleField.getScaleY());
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
		//ConnectionHandler.instance.
		byte[] data = ConnectionHandler.getInstance().udpReceiver.lastPacket.getData();
		double tempTimeStamp = packetDeserializer.getTimeStampFromByteArray(data);
		if(tempTimeStamp > timeStamp){
			timeStamp = tempTimeStamp;
			updateEntities(data);
		}else{
			//ignore packet!
		}
	}

	private void updateEntities(byte[] data) {
		for(DeserializedEntity e : packetDeserializer.getDeserializedEntityFromByteArray(data,8)){
			System.out.println(e.id + " = " + e.posX + " : " + e.posY);
			Entity entity = battleField.getEntitybyId(e.id);
			updateOrCreateEntity(e, entity);
		}
	}

	private void updateOrCreateEntity(DeserializedEntity e, Entity entity) {
		System.out.println(e.id);
		if(entity != null){
			System.out.println("update!");
			updateEntity(e, entity);
		}else{
			System.out.println("create!");
			createEntity(e);
		}
	}

	private void createEntity(DeserializedEntity e) {
		EntityFlyweight f  = FlyweightFactory.getInstance().getFlyweight(e.type);
		if(f != null){
			EntityFactory factory = World.getInstance().getMatchingFactory(f.getTextureName());
			String type = removeRace(f.getTextureName());
			factory.createEntity(type);
		}
	}

	private String removeRace(String raceAndType) {
		for(UnboundConstants.Race r : UnboundConstants.Race.values())
			raceAndType = raceAndType.replace(r.name(), "");
		return raceAndType;
	}

	private void updateEntity(DeserializedEntity e, Entity entity) {
		
		if(battleField.getPlayers().get(0).getId() != entity.getId()){
			
			entity.setPosition(new Vector2(e.posX,e.posY));
			entity.setDirection(new Vector2(e.dirX, e.dirY));
			entity.getUpdateState().getMove().setVelocity(new Vector2(e.velX,e.velY));
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
		//clientData wird aktualisiert
		int index = 0;
		for(byte b : packetSerializer.getTimeStampAsByteArray())
			clientData[index++] = b;
		for(byte b : packetSerializer.getPlayerAsByteArray())
			clientData[index++] = b;
		
		//TODO sende clientData an server udpsender
		ConnectionHandler.getInstance().udpSender.sendData(clientData);
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
		camera.position.x = battleField.getPlayers().get(0).getPosition().x;
		camera.position.y = battleField.getPlayers().get(0).getPosition().y;
		camera.zoom = 2.4f;
		camera.update();
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

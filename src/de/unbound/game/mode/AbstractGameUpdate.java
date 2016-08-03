package de.unbound.game.mode;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import de.unbound.game.BattleField;
import de.unbound.game.GameCamera;
import de.unbound.game.World;
import de.unbound.game.model.entities.Entity;
import de.unbound.utility.UnboundConstants;

public abstract class AbstractGameUpdate {

	protected World world;
	protected CollisionDetection collisionDetection;
	protected BattleField battleField;
	protected GameCamera camera;
	protected Sprite background;
	public Entity followingEntity;
	public String commands;
	protected AbstractCommandHandler commandHandler;
	
	public AbstractGameUpdate(CollisionDetection collisionDetection){
		initAbstract(collisionDetection);
	}
	
	private void initAbstract(CollisionDetection collisionDetection){
		battleField = new BattleField();
		this.collisionDetection = collisionDetection;
		this.collisionDetection.setBattleField(battleField);
		commands = "";
		initBackground();
	}

	private void initBackground() {
		background = new Sprite(new Texture(Gdx.files.internal("img/bathtub.png")));
		background.setPosition(-560, -260);
		background.setOrigin(0, 0);
		background.setScale(1.33f, 1.08f);
	}

	public void update(double deltaTime){
		if(!isPaused()){
			if (isGameOver()) {
				doBeforeUpdate();
				
				handleCommands();
				
				toggleFollowEntity();
			
				updateWaveHandler(deltaTime);
				updateBattleField(deltaTime);
			
				onCollisionHandling(deltaTime);

				for (Entity e : battleField.getGameObjects()) {
					e.update(deltaTime);
				}

				doAfterUpdate();
			} else {
				onGameEnd();
			}
		}else{
			onGamePaused();
		}
	}
	
	private void handleCommands() {
		commandHandler.handleInput();
	}

	private void toggleFollowEntity(){
		if(Gdx.input.isKeyPressed(Input.Keys.NUM_1))
			followingEntity = battleField.getMainBase();
		if(Gdx.input.isKeyPressed(Input.Keys.NUM_2))
			followingEntity = battleField.getPlayers().get(0);
		if(Gdx.input.isKeyPressed(Input.Keys.NUM_3)){
			Entity spawner = null;
			String spawnerType = World.getInstance().getWaveHandler().getEnemyFactory().getRace()
					+UnboundConstants.ImmobileEntity.Spawner.name();
			for(Entity e : battleField.getGameObjects()){
				if(e.getTextureName().equals(spawnerType)){
					spawner = e;
					break;
				}
			}
			followingEntity = spawner;
		}
	}

	public abstract boolean isGameOver();

	public abstract void doBeforeUpdate();
	
	private void updateBattleField(double deltaTime){
		battleField.update(deltaTime);
	}

	public abstract void updateWaveHandler(double deltaTime);
	
	public abstract void onCollisionHandling(double deltaTime);
	
	public abstract void doAfterUpdate();
	
	public abstract void onGameEnd();
	
	public abstract void renderEntity(Entity e);

	public abstract boolean isPaused();

	public abstract void onGamePaused();
	
	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public BattleField getBattleField() {
		return battleField;
	}
	
	public Camera getCamera(){
		return camera;
	}
	
	public String[] getCommands() {
		String[] allCommands = new String[0];
		if (commands.length() != 0) {
			synchronized (commands) {
				allCommands = new String(commands).split("\n");
				commands = "";
			}
		}
		return allCommands;
	}

	public void appendCommands(String commands) {
		synchronized (this.commands) {
			this.commands += commands + "\n";
		}
	}
	
}

package de.unbound.game.factories;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.BattleField;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.WaveOrder;
import de.unbound.utility.UnboundConstants;

public abstract class EntityFactory {

	protected FlyweightFactory flyweightFactory;
	protected BattleField battlefield;

	private String race;
	private boolean hostile;
	
	public EntityFactory(String race, boolean hostile) {
		flyweightFactory = FlyweightFactory.getInstance();
		this.race = race;
		this.hostile = hostile;
	}

	public void createMap(double seed) {
		int width = UnboundConstants.WORLDWIDTH;
		int height = UnboundConstants.WORLDHEIGHT;
		Entity mainBase = createEntity(UnboundConstants.ImmobileEntity.MainBase.name());
		mainBase.setPosition(new Vector2(width / 2, UnboundConstants.SINGLEGRIDHEIGHT*2));
		
		Entity tower = createEntity(UnboundConstants.ImmobileEntity.Tower.name());
		tower.setPosition(new Vector2(width / 2, height / 3));

		tower = createEntity(UnboundConstants.ImmobileEntity.Tower.name());
		tower.setPosition(new Vector2(width / 2, height * 2 / 3));

		Random random = new Random((long) seed);

		for (int i = 0; i < 6; i++) {
			Entity tempDeposit = createEntity(UnboundConstants.ImmobileEntity.Deposit.name());
			float x = (float) ((int) (random.nextFloat() * width));
			float y = (float) ((int) (random.nextFloat()
					* UnboundConstants.SINGLEGRIDHEIGHT * 2) + (i / 2)
					* height / 3);
			tempDeposit.setPosition(new Vector2(x, y));
		}
	}
	
	public Entity createPlayer(){
		Entity player = createEntity(UnboundConstants.MobileEntity.Player.name());
		player.setPosition(new Vector2(UnboundConstants.ENEMY_SPAWNPOINT.x, UnboundConstants.SINGLEGRIDHEIGHT*2));
		return player;
	}
	
	public Entity createSpawner(){
		Entity spawner = createEntity(UnboundConstants.ImmobileEntity.Spawner.name());
		spawner.setDirection(new Vector2(0,-1));
		return spawner;
	}
	
	public Entity createMainBase(){
		Entity mainBase = createEntity(UnboundConstants.ImmobileEntity.MainBase.name());
		mainBase.setPosition(new Vector2(UnboundConstants.ENEMY_SPAWNPOINT.x, UnboundConstants.SINGLEGRIDHEIGHT*2));
		mainBase.setDirection(new Vector2(0,1));
		return mainBase;
	}

	/**
	 * 
	 * @param order
	 */
	public void createWave(WaveOrder order) {
		ArrayList<Entity> wave = new ArrayList<>();
		for (int i = 0; i < order.getBossNumber(); i++)
			wave.add(createEntity(UnboundConstants.MobileEntity.Boss.name()));
		for (int i = 0; i < order.getCommanderNumber(); i++)
			wave.add(createEntity(UnboundConstants.MobileEntity.Commander.name()));
		for (int i = 0; i < order.getScavengerNumber(); i++)
			wave.add(createEntity(UnboundConstants.MobileEntity.Scavenger.name()));
		for (int i = 0; i < order.getPawnNumber(); i++)
			wave.add(createEntity(UnboundConstants.MobileEntity.Pawn.name()));
		
	}

	public Entity createEntity(String type) {
		Entity e = new Entity();
		e.setModel(flyweightFactory.getFlyweight(race + type));
		e.setPosition(UnboundConstants.ENEMY_SPAWNPOINT.cpy());
		e.setHostile(hostile);
		updateTypeAttributes(e,type);
		e.setHp(e.getModel().getInitialHP());
		battlefield.add(e);
		return e;
	}

	protected abstract void updateTypeAttributes(Entity e,String type);

	public void setBattlefield(BattleField battlefield) {
		this.battlefield = battlefield;
		UnboundConstants.ENEMY_SPAWNPOINT.set(UnboundConstants.WORLDWIDTH / 2,
				UnboundConstants.WORLDHEIGHT - UnboundConstants.SINGLEGRIDHEIGHT);
	}

	public String getRace() {
		return race;
	}

	public boolean isHostile() {
		return hostile;
	}
	
}
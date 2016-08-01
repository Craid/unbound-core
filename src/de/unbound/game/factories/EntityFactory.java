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
	private BattleField battlefield;

	private String race;
	private boolean hostile;
	
	private static Vector2 SPAWNPOINT = new Vector2(UnboundConstants.WORLDWIDTH / 2,
			UnboundConstants.WORLDHEIGHT - UnboundConstants.SINGLEGRIDHEIGHT);

	public EntityFactory(String race, boolean hostile) {
		flyweightFactory = FlyweightFactory.getInstance();
		this.race = race;
		this.hostile = hostile;
	}

	public void createMap(double seed) {
		int width = UnboundConstants.WORLDWIDTH*battlefield.getScaleX();
		int height = UnboundConstants.WORLDHEIGHT*battlefield.getScaleY();
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
		
		Entity player = createEntity(UnboundConstants.MobileEntity.Player.name());
		player.setPosition(new Vector2(width / 2, UnboundConstants.SINGLEGRIDHEIGHT*2));
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
		e.setPosition(SPAWNPOINT.cpy());
		e.setHostile(hostile);
		updateTypeAttributes(e,type);
		e.setHp(e.getModel().getInitialHP());
		battlefield.add(e);
		return e;
	}

	protected abstract void updateTypeAttributes(Entity e,String type);

	public void setBattlefield(BattleField battlefield) {
		System.out.println(battlefield);
		this.battlefield = battlefield;
		System.out.println(this.battlefield);
		System.out.println(this.battlefield.getScaleX());
		System.out.println(UnboundConstants.WORLDWIDTH);
		System.out.println(SPAWNPOINT);
		SPAWNPOINT.set(UnboundConstants.WORLDWIDTH*battlefield.getScaleX() / 2,
				UnboundConstants.WORLDHEIGHT*battlefield.getScaleY() - UnboundConstants.SINGLEGRIDHEIGHT);
	}

	public String getRace() {
		return race;
	}

	public boolean isHostile() {
		return hostile;
	}
	
}
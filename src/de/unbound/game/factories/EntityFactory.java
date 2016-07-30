package de.unbound.game.factories;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.BattleField;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.wave.WaveOrder;
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

	public abstract void createMap(double seed);

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
		this.battlefield = battlefield;
	}

	public String getRace() {
		return race;
	}

	public boolean isHostile() {
		return hostile;
	}
	
}
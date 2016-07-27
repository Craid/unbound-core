package de.unbound.game.factories;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.BattleField;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.update.UpdateStateImmobile;
import de.unbound.game.model.state.update.UpdateStateMobile;
import de.unbound.game.model.state.update.UpdateStatePlayer;
import de.unbound.game.model.state.update.UpdateStateProjectile;
import de.unbound.game.wave.WaveOrder;
import de.unbound.utility.UnboundConstants;

public class EntityFactory {

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

		Entity mainBase = createEntity(UnboundConstants.ImmobileEntity.MainBase.name());
		mainBase.setPosition(new Vector2(UnboundConstants.WORLDWIDTH / 2,
				UnboundConstants.SINGLEGRIDHEIGHT*2));
		
		Entity tempEntity = createEntity(UnboundConstants.ImmobileEntity.Tower.name());
		tempEntity.setPosition(new Vector2(UnboundConstants.WORLDWIDTH / 2,
				UnboundConstants.WORLDHEIGHT / 3));

		tempEntity = createEntity(UnboundConstants.ImmobileEntity.Tower.name());
		tempEntity.setPosition(new Vector2(UnboundConstants.WORLDWIDTH / 2,
				UnboundConstants.WORLDHEIGHT * 2 / 3));

		Random random = new Random((long) seed);

		for (int i = 0; i < 6; i++) {
			Entity tempDeposit = createEntity(UnboundConstants.ImmobileEntity.Deposit.name());
			float x = (float) ((int) (random.nextFloat()
					* UnboundConstants.SINGLEGRIDWIDTH * UnboundConstants.GRIDWIDTH) + UnboundConstants.SINGLEGRIDWIDTH);
			float y = (float) ((int) (random.nextFloat()
					* UnboundConstants.SINGLEGRIDHEIGHT * 2) + (i / 2)
					* UnboundConstants.WORLDHEIGHT / 3);
			tempDeposit.setPosition(new Vector2(x, y));
		}
		
		Entity player = createEntity(UnboundConstants.MobileEntity.Player.name());
		player.setPosition(new Vector2(UnboundConstants.WORLDWIDTH / 2,
				UnboundConstants.SINGLEGRIDHEIGHT*2));
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

	private void updateTypeAttributes(Entity e,String type) {
		if(type.contains(UnboundConstants.MobileEntity.Player.name()))
			e.setUpdateState(new UpdateStatePlayer(e));
		else if(type.contains(UnboundConstants.MobileEntity.Projectile.name()))
			e.setUpdateState(new UpdateStateProjectile(e));
		else if(!e.isImmobile())
			e.setUpdateState(new UpdateStateMobile(e));
		else
			e.setUpdateState(new UpdateStateImmobile(e));
	}

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
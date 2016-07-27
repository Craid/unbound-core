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
	protected BattleField battlefield;
	private String race;
	private boolean hostile;
	
	private static Vector2 SPAWNPOINT = new Vector2(UnboundConstants.WORLDWIDTH / 2,
			UnboundConstants.WORLDHEIGHT - UnboundConstants.SINGLEGRIDHEIGHT);

	public EntityFactory(String race, boolean hostile) {
		flyweightFactory = FlyweightFactory.getInstance();
		battlefield = BattleField.getInstance();
		this.race = race;
		this.hostile = hostile;
	}

	public void createMap(double seed) {

		Entity mainBase = createEntity("MainBase");
		mainBase.setPosition(new Vector2(UnboundConstants.WORLDWIDTH / 2,
				UnboundConstants.SINGLEGRIDHEIGHT*2));
		
		Entity tempEntity = createEntity("Tower");
		tempEntity.setPosition(new Vector2(UnboundConstants.WORLDWIDTH / 2,
				UnboundConstants.WORLDHEIGHT / 3));

		tempEntity = createEntity("Tower");
		tempEntity.setPosition(new Vector2(UnboundConstants.WORLDWIDTH / 2,
				UnboundConstants.WORLDHEIGHT * 2 / 3));

		Random random = new Random((long) seed);

		for (int i = 0; i < 6; i++) {
			Entity tempDeposit = createEntity("Deposit");
			float x = (float) ((int) (random.nextFloat()
					* UnboundConstants.SINGLEGRIDWIDTH * UnboundConstants.GRIDWIDTH) + UnboundConstants.SINGLEGRIDWIDTH);
			float y = (float) ((int) (random.nextFloat()
					* UnboundConstants.SINGLEGRIDHEIGHT * 2) + (i / 2)
					* UnboundConstants.WORLDHEIGHT / 3);
			tempDeposit.setPosition(new Vector2(x, y));
		}
		
		Entity player = createEntity("Player");
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
			wave.add(createEntity("Boss"));
		for (int i = 0; i < order.getCommanderNumber(); i++)
			wave.add(createEntity("Commander"));
		for (int i = 0; i < order.getScavengerNumber(); i++)
			wave.add(createEntity("Scavenger"));
		for (int i = 0; i < order.getPawnNumber(); i++)
			wave.add(createEntity("Pawn"));
		
	}

	public Entity createEntity(String type) {
		Entity e = new Entity();
		e.setModel(flyweightFactory.getFlyweight(race + type));
		e.setPosition(SPAWNPOINT.cpy());
		e.setHostile(hostile);
		updateTypeAttributes(e,type);
		battlefield.add(e);
		return e;
	}

	private void updateTypeAttributes(Entity e,String type) {
		if(type.contains("Player"))
			updatePlayer(e);
		else if(type.contains("Projectile"))
			updateProjectile(e);
		else if(!e.isImmobile())
			e.setUpdateState(new UpdateStateMobile(e));
		else
			e.setUpdateState(new UpdateStateImmobile(e));
	}

	private void updateProjectile(Entity e) {
		e.setUpdateState(new UpdateStateProjectile(e));
		e.setHp(8);
	}

	private void updatePlayer(Entity e) {
		e.setUpdateState(new UpdateStatePlayer(e));
	}
}
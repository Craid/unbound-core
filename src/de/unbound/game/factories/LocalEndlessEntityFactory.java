package de.unbound.game.factories;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.update.UpdateStateImmobile;
import de.unbound.game.model.state.update.UpdateStateMobile;
import de.unbound.game.model.state.update.UpdateStatePlayer;
import de.unbound.game.model.state.update.UpdateStateProjectile;
import de.unbound.utility.UnboundConstants;

public class LocalEndlessEntityFactory extends EntityFactory {
	
	public LocalEndlessEntityFactory(String race, boolean hostile) {
		super(race, hostile);
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
	
	protected void updateTypeAttributes(Entity e,String type) {
		if(type.contains(UnboundConstants.MobileEntity.Player.name()))
			e.setUpdateState(new UpdateStatePlayer(e));
		else if(type.contains(UnboundConstants.MobileEntity.Projectile.name()))
			e.setUpdateState(new UpdateStateProjectile(e));
		else if(!e.isImmobile())
			e.setUpdateState(new UpdateStateMobile(e));
		else
			e.setUpdateState(new UpdateStateImmobile(e));
	}

}

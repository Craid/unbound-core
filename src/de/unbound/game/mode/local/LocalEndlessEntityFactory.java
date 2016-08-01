package de.unbound.game.mode.local;

import de.unbound.game.factories.EntityFactory;
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

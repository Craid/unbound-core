package de.unbound.game.factories;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.update.UpdateStateImmobileNotAttacking;
import de.unbound.game.model.state.update.UpdateStateMobileNotAttacking;
import de.unbound.game.model.state.update.UpdateStatePlayer;
import de.unbound.game.model.state.update.UpdateStateProjectile;
import de.unbound.utility.UnboundConstants;

public class ClientEndlessEntityFactory extends EntityFactory {
	
	public ClientEndlessEntityFactory(String race, boolean hostile) {
		super(race, hostile);
	}

	public void createMap(double seed) {
		//Die Generierung wird vom Server übernommen
	}
	
	protected void updateTypeAttributes(Entity e,String type) {
		if(type.contains(UnboundConstants.MobileEntity.Player.name()))
			e.setUpdateState(new UpdateStatePlayer(e));
		else if(type.contains(UnboundConstants.MobileEntity.Projectile.name()))
			e.setUpdateState(new UpdateStateProjectile(e));
		else if(!e.isImmobile())
			e.setUpdateState(new UpdateStateMobileNotAttacking(e));
		else
			e.setUpdateState(new UpdateStateImmobileNotAttacking(e));
	}

}

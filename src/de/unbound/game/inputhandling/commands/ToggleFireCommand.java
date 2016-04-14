package de.unbound.game.inputhandling.commands;

import de.unbound.game.BattleField;
import de.unbound.game.factories.RacePrelateFactory;
import de.unbound.game.model.entities.mobile.Projectile;
import de.unbound.game.model.state.move.MoveStateStraightSpinning;

public class ToggleFireCommand extends Command {
	
	public ToggleFireCommand(){
		
	}
	
	public void execute(){
		Projectile p;
		p = RacePrelateFactory.getRacePrelateFactory().createProjectile();
		p.setDirection(BattleField.getBattleField().getPlayer().getDirection().cpy());
		p.setPosition(BattleField.getBattleField().getPlayer().getPosition().cpy());
		p.setVelocity(BattleField.getBattleField().getPlayer().getVelocity().cpy());
		p.setMove(new MoveStateStraightSpinning(p));
	}
	
}
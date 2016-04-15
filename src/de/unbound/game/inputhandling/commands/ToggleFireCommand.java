package de.unbound.game.inputhandling.commands;

import de.unbound.game.BattleField;
import de.unbound.game.factories.ProjectileBuilder;
import de.unbound.game.model.entities.mobile.Player;

public class ToggleFireCommand extends Command {
	
	public ToggleFireCommand(){
		
	}
	
	public void execute(){
		Player player = BattleField.getBattleField().getPlayer();
		ProjectileBuilder.getInstance().createProjectile(player);
	}
	
}
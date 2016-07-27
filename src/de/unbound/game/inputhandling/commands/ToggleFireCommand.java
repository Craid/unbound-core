package de.unbound.game.inputhandling.commands;

import de.unbound.game.BattleField;
import de.unbound.game.factories.ProjectileBuilder;
import de.unbound.game.model.entities.Entity;

public class ToggleFireCommand extends Command {
	
	public ToggleFireCommand(){
		
	}
	
	public void execute(){
		Entity player = BattleField.getInstance().getPlayer();
		ProjectileBuilder.getInstance().createProjectile(player);
	}
	
}
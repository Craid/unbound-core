package de.unbound.game.inputhandling.commands;

import de.unbound.game.World;

public class ToggleFireCommand extends Command {
	
	public ToggleFireCommand(){
		
	}
	
	public void execute(){
		World.getInstance().createProjectile(World.getInstance().getBattleField().getPlayers().get(0));
		World.getInstance().getGameUpdate().appendCommands("Projectile");
	}
	
}
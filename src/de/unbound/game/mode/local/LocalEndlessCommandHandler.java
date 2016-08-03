package de.unbound.game.mode.local;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.World;
import de.unbound.game.mode.AbstractCommandHandler;
import de.unbound.utility.UnboundConstants;

public class LocalEndlessCommandHandler extends AbstractCommandHandler{

	LocalEndlessGameUpdate gameUpdate;
	
	public LocalEndlessCommandHandler(LocalEndlessGameUpdate gameUpdate) {
		this.gameUpdate = gameUpdate;
	}

	@Override
	public String[] getCommands() {
		return gameUpdate.getCommands();
	}

	@Override
	public void handleCommand(String command) {
		System.out.println(command);
		String[] commandSep = command.split(":");
		switch(commandSep[0]){
		case "Projectile": {
			World.getInstance().createProjectile(World.getInstance().getBattleField().getPlayers().get(0));
		}; break;
		case "Tower": {
				Vector2 pos = new Vector2(Float.parseFloat(commandSep[1]),Float.parseFloat((commandSep[2])));
				System.out.println(pos);
				if(UnboundConstants.WORLD.contains(pos) && !UnboundConstants.SPAWNER.contains(pos)){
					World.getInstance().createTower(pos.x, pos.y);
				}
			}; 
			break;
		}
	}

}

package de.unbound.game.inputhandling.commands;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.World;
import de.unbound.utility.UnboundConstants;

public class CreateTowerCommand extends Command {
	
	private Vector2 pos; 
	
	public CreateTowerCommand(float posX, float posY){
		pos = new Vector2(posX, posY);
	}
	
	public void execute(){
		if(UnboundConstants.WORLD.contains(pos) && !UnboundConstants.SPAWNER.contains(pos)){
			World.getInstance().getGameUpdate().appendCommands("Tower:"+pos.x+":"+pos.y);
		}
	} 
}

package de.unbound.game.inputhandling.commands;

import de.unbound.game.World;

public class CreateTowerCommand extends Command {
	
	float posX, posY;
	
	public CreateTowerCommand(float posX, float posY){
		this.posX = posX;
		this.posY = posY;
	}
	
	public void execute(){
		World.getInstance().createTower(posX, posY);
	} 
}

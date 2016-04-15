package de.unbound.game.inputhandling.commands;

import de.unbound.game.factories.TowerBuilder;

public class CreateTowerCommand extends Command {
	
	float posX, posY;
	
	public CreateTowerCommand(float posX, float posY){
		this.posX = posX;
		this.posY = posY;
	}
	
	public void execute(){
		TowerBuilder.getInstance().createTower(posX, posY);
	} 
}

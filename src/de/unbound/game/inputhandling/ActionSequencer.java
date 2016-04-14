package de.unbound.game.inputhandling;

import java.util.ArrayList;

import de.unbound.game.inputhandling.commands.Command;

public class ActionSequencer {

	private ArrayList<Command> sequence;

	public ActionSequencer(){
		sequence = new ArrayList<Command>();
	}
	
	public void update(){
		executeCommands();
	}
	
	public void executeCommands() {
		for (Command c : sequence){
			c.execute();
			}
		sequence.clear();
		//throw new UnsupportedOperationException();
	}
	
	public void addCommandToSequence(Command c){
		sequence.add(c);
	}

}
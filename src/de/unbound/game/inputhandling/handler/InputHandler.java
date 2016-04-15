package de.unbound.game.inputhandling.handler;

import com.badlogic.gdx.InputAdapter;

import de.unbound.game.inputhandling.ActionSequencer;
import de.unbound.game.inputhandling.commands.Command;

public abstract class InputHandler extends InputAdapter{

	ActionSequencer sequencer;

	public InputHandler() {
		sequencer = new ActionSequencer();
	}
	
	public void addCommandToSequencer(Command c){
		sequencer.addCommandToSequence(c);
	}

	public abstract Command createMoveUpCommand();

	public abstract Command createMoveDownCommand();

	public abstract Command createMoveLeftCommand();
	
	public abstract Command createMoveRightCommand();

	public abstract Command createMoveCommand(double xAxis, double yAxis);

	// GETTERS AND SETTERS
	
	public ActionSequencer getSequencer() {
		return sequencer;
	}

	public void setSequencer(ActionSequencer sequencer) {
		this.sequencer = sequencer;
	}


}
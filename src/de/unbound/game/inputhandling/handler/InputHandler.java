package de.unbound.game.inputhandling.handler;

import java.awt.Event;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.input.GestureDetector.GestureListener;

import de.unbound.game.inputhandling.ActionSequencer;
import de.unbound.game.inputhandling.commands.Command;

public class InputHandler {

	ActionSequencer sequencer;



	public InputHandler() {
		sequencer = new ActionSequencer();
	}
	
	public void addCommandToSequencer(Command c){
		sequencer.addCommandToSequence(c);
	}

	public Command createMoveUpCommand() {
		
		return null;
	}

	public Command createMoveDownCommand() {

		return null;
	}

	public Command createMoveLeftCommand() {

		return null;
	}

	public Command createMoveRightCommand() {

		return null;
	}

	public Command createMoveCommand(double xAxis, double yAxis) {

		return null;
	}

	// GETTERS AND SETTERS
	
	public ActionSequencer getSequencer() {
		return sequencer;
	}

	public void setSequencer(ActionSequencer sequencer) {
		this.sequencer = sequencer;
	}


}
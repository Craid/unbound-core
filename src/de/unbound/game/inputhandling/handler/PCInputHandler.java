
package de.unbound.game.inputhandling.handler;

import de.unbound.game.inputhandling.commands.Command;
import de.unbound.game.inputhandling.commands.ToggleFireCommand;

public class PCInputHandler extends InputHandler{
	

	@Override
	public boolean keyDown(int arg0) {
		addCommandToSequencer(new ToggleFireCommand());
//		System.out.println(arg0);
		return false;
	}

	@Override
	public boolean keyTyped(char arg0) {
		return false;
	}

	@Override
	public boolean keyUp(int arg0) {
		return false;
	}

	@Override
	public boolean mouseMoved(int arg0, int arg1) {
		return false;
	}

	@Override
	public boolean scrolled(int arg0) {
		return false;
	}

	@Override
	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
		buildTower();
		return false;
	}

	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		buildTower();
		return false;
	}

	@Override
	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		return false;
	}

	@Override
	public Command createMoveUpCommand() {
		return null;
	}

	@Override
	public Command createMoveDownCommand() {
		return null;
	}

	@Override
	public Command createMoveLeftCommand() {
		return null;
	}

	@Override
	public Command createMoveRightCommand() {
		return null;
	}

	@Override
	public Command createMoveCommand(double xAxis, double yAxis) {
		return null;
	}
	
	
}
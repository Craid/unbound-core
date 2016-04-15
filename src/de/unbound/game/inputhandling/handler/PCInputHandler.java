
package de.unbound.game.inputhandling.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;

import de.unbound.game.GameCamera;
import de.unbound.game.inputhandling.commands.Command;
import de.unbound.game.inputhandling.commands.CreateTowerCommand;
import de.unbound.game.inputhandling.commands.ToggleFireCommand;

public class PCInputHandler extends InputHandler{

	@Override
	public boolean keyDown(int arg0) {
		// TODO Auto-generated method stub
		addCommandToSequencer(new ToggleFireCommand());
//		System.out.println(arg0);
		return false;
	}

	@Override
	public boolean keyTyped(char arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
		Vector3 touchPos = new Vector3();
	    touchPos.set(Gdx.input.getX(), Gdx.input.getY(),0);
	    GameCamera.getGameCamera().unproject(touchPos);
	    addCommandToSequencer(new CreateTowerCommand(touchPos.x, touchPos.y));
	    //System.out.println(touchPos.x+" = X ///"+ touchPos.y + " = Y");
		
		return false;
	}

	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Command createMoveUpCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Command createMoveDownCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Command createMoveLeftCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Command createMoveRightCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Command createMoveCommand(double xAxis, double yAxis) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
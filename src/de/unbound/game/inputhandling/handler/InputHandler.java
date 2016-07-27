package de.unbound.game.inputhandling.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector3;

import de.unbound.game.World;
import de.unbound.game.inputhandling.ActionSequencer;
import de.unbound.game.inputhandling.commands.Command;
import de.unbound.game.inputhandling.commands.CreateTowerCommand;

public abstract class InputHandler extends InputAdapter{

	ActionSequencer sequencer;

	double lastTowerBuild = 0;

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

	protected void buildTower() {
		if(System.currentTimeMillis() - lastTowerBuild > 500){
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(),0);
			World.getInstance().getGameUpdate().getCamera().unproject(touchPos);
			addCommandToSequencer(new CreateTowerCommand(touchPos.x, touchPos.y));
			lastTowerBuild = System.currentTimeMillis();
		}
	}
	
	// GETTERS AND SETTERS
	
	public ActionSequencer getSequencer() {
		return sequencer;
	}

	public void setSequencer(ActionSequencer sequencer) {
		this.sequencer = sequencer;
	}


}
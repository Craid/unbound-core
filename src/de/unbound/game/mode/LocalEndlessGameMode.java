package de.unbound.game.mode;

import de.unbound.game.logic.LocalGameUpdate;
import de.unbound.game.wave.LocalEndlessWaveHandler;

public class LocalEndlessGameMode extends GameMode{
	public LocalEndlessGameMode(){
		super(LocalEndlessWaveHandler.createLocalEndlessWaveHandlerPreset(),new LocalGameUpdate());
	}
}

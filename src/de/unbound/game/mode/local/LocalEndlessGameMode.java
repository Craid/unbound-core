package de.unbound.game.mode.local;

import de.unbound.game.mode.GameMode;

public class LocalEndlessGameMode extends GameMode{
	public LocalEndlessGameMode(){
		super(LocalEndlessWaveHandler.createLocalEndlessWaveHandlerPreset(),new LocalEndlessGameUpdate());
	}
}

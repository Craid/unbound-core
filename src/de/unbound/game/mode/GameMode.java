package de.unbound.game.mode;


public abstract class GameMode {
	
	private WaveHandler waveHandler;
	private AbstractGameUpdate gameUpdate;
	
	public GameMode(WaveHandler wh, AbstractGameUpdate abgu){
		waveHandler = wh;
		gameUpdate = abgu;
	}
	
	public WaveHandler getWaveHandler() {
		return waveHandler;
	}

	public void setWaveHandler(WaveHandler waveHandler) {
		this.waveHandler = waveHandler;
	}

	public AbstractGameUpdate getGameUpdate() {
		return gameUpdate;
	}

	public void setGameUpdate(AbstractGameUpdate gameUpdate) {
		this.gameUpdate = gameUpdate;
	}

}

package de.unbound.game.wave;

import de.unbound.game.factories.EntityFactory;

public class LocalEndlessWaveHandler extends WaveHandler {
	
	/**
	 * Timeout in seconds
	 */
	private static final int WAVETIMEOUTS = 5;
	private double cummulativeTime;

	public LocalEndlessWaveHandler(EntityFactory ownFactory, EntityFactory enemyFactory) {
		super(ownFactory, enemyFactory);
		cummulativeTime = 2; //First Wave in 3 Seconds, next in steps of WAVETIMEOUTS
		level = 1;
	}
	
	public static LocalEndlessWaveHandler createLocalEndlessWaveHandlerPreset() {
		return new LocalEndlessWaveHandler(new EntityFactory("Prelate", false),new EntityFactory("Duck", true));
	}
	
	@Override
	public void update(double deltaTime) {
		cummulativeTime += deltaTime;
		if(cummulativeTime > WAVETIMEOUTS){
			cummulativeTime -= WAVETIMEOUTS;
			level++;
			setCurrentOrder(createWaveAccordingToDifficulity());
		}
	}

	private WaveOrder createWaveAccordingToDifficulity() {
		int boss = level/10;
		int commander = level/5;
		int scavenger = level%5;
		int pawn = (level%5) * 3;
		return new WaveOrder(boss, pawn, scavenger, commander, 0, 0, 0, 0);
	}
	
}
package de.unbound.game.wave;

import de.unbound.game.factories.AbstractRaceFactory;
import de.unbound.game.factories.RaceDuckFactory;
import de.unbound.game.factories.RacePrelateFactory;

public class LocaleEndlessWaveHandler extends WaveHandler {
	
	private static final int WAVETIMEOUTS = 10;
	private double cummulativeTime;
	private int difficulity;

	public LocaleEndlessWaveHandler(AbstractRaceFactory ownFactory, AbstractRaceFactory enemyFactory) {
		super(ownFactory, enemyFactory);
		cummulativeTime = 0;
		difficulity = 1;
	}
	
	public static LocaleEndlessWaveHandler createLocaleEndlessWaveHandlerPreset() {
		return new LocaleEndlessWaveHandler(new RaceDuckFactory(), new RacePrelateFactory());
	}
	
	@Override
	public void update(double deltaTime) {
		cummulativeTime += deltaTime;
		if(cummulativeTime > WAVETIMEOUTS){
			cummulativeTime -= WAVETIMEOUTS;
			difficulity++;
			setCurrentOrder(createWaveAccordingToDifficulity());
		}
	}

	private WaveOrder createWaveAccordingToDifficulity() {
		int boss = difficulity/10;
		int commander = difficulity/5;
		int scavenger = difficulity%5;
		int pawn = difficulity%10 * 3;
		return new WaveOrder(boss, pawn, scavenger, commander, 0, 0, 0, 0);
	}
}
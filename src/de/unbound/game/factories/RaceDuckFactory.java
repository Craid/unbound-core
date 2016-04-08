package de.unbound.game.factories;

import de.unbound.game.model.entities.immobile.Base;
import de.unbound.game.model.entities.immobile.Deposit;
import de.unbound.game.model.entities.immobile.MainBase;
import de.unbound.game.model.entities.immobile.Spawner;
import de.unbound.game.model.entities.immobile.Tower;
import de.unbound.game.model.entities.immobile.ducks.DuckBase;
import de.unbound.game.model.entities.immobile.ducks.DuckDeposit;
import de.unbound.game.model.entities.immobile.ducks.DuckMainBase;
import de.unbound.game.model.entities.immobile.ducks.DuckSpawner;
import de.unbound.game.model.entities.immobile.ducks.DuckTower;
import de.unbound.game.model.entities.mobile.Boss;
import de.unbound.game.model.entities.mobile.Collector;
import de.unbound.game.model.entities.mobile.Commander;
import de.unbound.game.model.entities.mobile.Pawn;
import de.unbound.game.model.entities.mobile.Player;
import de.unbound.game.model.entities.mobile.Scavenger;
import de.unbound.game.model.entities.mobile.ducks.DuckBoss;
import de.unbound.game.model.entities.mobile.ducks.DuckCollector;
import de.unbound.game.model.entities.mobile.ducks.DuckCommander;
import de.unbound.game.model.entities.mobile.ducks.DuckPawn;
import de.unbound.game.model.entities.mobile.ducks.DuckPlayer;
import de.unbound.game.model.entities.mobile.ducks.DuckScavenger;

public class RaceDuckFactory extends AbstractRaceFactory {

	@Override
	protected Boss createBoss() {
		return createEntitiy(DuckBoss.class);
	}

	@Override
	protected Commander createCommander() {
		return createEntitiy(DuckCommander.class);
	}

	@Override
	protected Scavenger createScavenger() {
		return createEntitiy(DuckScavenger.class);
	}

	@Override
	protected Pawn createPawn() {
		return createEntitiy(DuckPawn.class);
	}

	@Override
	public Player createPlayer() {
		return createEntitiy(DuckPlayer.class);
	}

	@Override
	public Collector createCollector() {
		return createEntitiy(DuckCollector.class);
	}

	@Override
	protected MainBase createMainBase() {
		return createEntitiy(DuckMainBase.class);
	}

	@Override
	protected Base createBase() {
		return createEntitiy(DuckBase.class);
	}

	@Override
	public Tower createTower() {
		return createEntitiy(DuckTower.class);
	}

	@Override
	protected Deposit createDeposit() {
		return createEntitiy(DuckDeposit.class);
	}

	@Override
	protected Spawner createSpawner() {
		return createEntitiy(DuckSpawner.class);
	}
}
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
		return new DuckBoss();
	}

	@Override
	protected Commander createCommander() {
		return new DuckCommander();
	}

	@Override
	protected Scavenger createScavenger() {
		return new DuckScavenger();
	}

	@Override
	protected Pawn createPawn() {
		return new DuckPawn();
	}

	@Override
	public Player createPlayer() {
		return new DuckPlayer();
	}

	@Override
	public Collector createCollector() {
		return new DuckCollector();
	}

	@Override
	protected MainBase createMainBase() {
		return new DuckMainBase();
	}

	@Override
	protected Base createBase() {
		return new DuckBase();
	}

	@Override
	public Tower createTower() {
		return new DuckTower();
	}

	@Override
	protected Deposit createDeposit() {
		return new DuckDeposit();
	}

	@Override
	protected Spawner createSpawner() {
		return new DuckSpawner();
	}
}
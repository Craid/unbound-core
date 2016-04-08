package de.unbound.game.factories;

import de.unbound.game.model.entities.immobile.Base;
import de.unbound.game.model.entities.immobile.Deposit;
import de.unbound.game.model.entities.immobile.MainBase;
import de.unbound.game.model.entities.immobile.Spawner;
import de.unbound.game.model.entities.immobile.Tower;
import de.unbound.game.model.entities.immobile.prelates.PrelateBase;
import de.unbound.game.model.entities.immobile.prelates.PrelateDeposit;
import de.unbound.game.model.entities.immobile.prelates.PrelateMainBase;
import de.unbound.game.model.entities.immobile.prelates.PrelateSpawner;
import de.unbound.game.model.entities.immobile.prelates.PrelateTower;
import de.unbound.game.model.entities.mobile.Boss;
import de.unbound.game.model.entities.mobile.Collector;
import de.unbound.game.model.entities.mobile.Commander;
import de.unbound.game.model.entities.mobile.Pawn;
import de.unbound.game.model.entities.mobile.Player;
import de.unbound.game.model.entities.mobile.Scavenger;
import de.unbound.game.model.entities.mobile.prelates.PrelateBoss;
import de.unbound.game.model.entities.mobile.prelates.PrelateCollector;
import de.unbound.game.model.entities.mobile.prelates.PrelateCommander;
import de.unbound.game.model.entities.mobile.prelates.PrelatePawn;
import de.unbound.game.model.entities.mobile.prelates.PrelatePlayer;
import de.unbound.game.model.entities.mobile.prelates.PrelateScavenger;

public class RacePrelateFactory extends AbstractRaceFactory {

	@Override
	protected Boss createBoss() {
		return new PrelateBoss();
	}

	@Override
	protected Commander createCommander() {
		return new PrelateCommander();
	}

	@Override
	protected Scavenger createScavenger() {
		return new PrelateScavenger();
	}

	@Override
	protected Pawn createPawn() {
		return new PrelatePawn();
	}

	@Override
	public Player createPlayer() {
		return new PrelatePlayer();
	}

	@Override
	public Collector createCollector() {
		return new PrelateCollector();
	}

	@Override
	protected MainBase createMainBase() {
		return new PrelateMainBase();
	}

	@Override
	protected Base createBase() {
		return new PrelateBase();
	}

	@Override
	public Tower createTower() {
		return new PrelateTower();
	}

	@Override
	protected Deposit createDeposit() {
		return new PrelateDeposit();
	}

	@Override
	protected Spawner createSpawner() {
		return new PrelateSpawner();
	}
}
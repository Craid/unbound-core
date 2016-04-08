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
		return createEntitiy(PrelateBoss.class);
	}

	@Override
	protected Commander createCommander() {
		return createEntitiy(PrelateCommander.class);
	}

	@Override
	protected Scavenger createScavenger() {
		return createEntitiy(PrelateScavenger.class);
	}

	@Override
	protected Pawn createPawn() {
		return createEntitiy(PrelatePawn.class);
	}

	@Override
	public Player createPlayer() {
		return createEntitiy(PrelatePlayer.class);
	}

	@Override
	public Collector createCollector() {
		return createEntitiy(PrelateCollector.class);
	}

	@Override
	protected MainBase createMainBase() {
		return createEntitiy(PrelateMainBase.class);
	}

	@Override
	protected Base createBase() {
		return createEntitiy(PrelateBase.class);
	}

	@Override
	public Tower createTower() {
		return createEntitiy(PrelateTower.class);
	}

	@Override
	protected Deposit createDeposit() {
		return createEntitiy(PrelateDeposit.class);
	}

	@Override
	protected Spawner createSpawner() {
		return createEntitiy(PrelateSpawner.class);
	}
}
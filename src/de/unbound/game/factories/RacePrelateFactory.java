package de.unbound.game.factories;

import de.unbound.game.model.entities.immobile.Deposit;
import de.unbound.game.model.entities.immobile.MainBase;
import de.unbound.game.model.entities.immobile.Spawner;
import de.unbound.game.model.entities.immobile.Tower;
import de.unbound.game.model.entities.immobile.prelates.PrelateDeposit;
import de.unbound.game.model.entities.immobile.prelates.PrelateMainBase;
import de.unbound.game.model.entities.immobile.prelates.PrelateSpawner;
import de.unbound.game.model.entities.immobile.prelates.PrelateTower;
import de.unbound.game.model.entities.mobile.Boss;
import de.unbound.game.model.entities.mobile.Collector;
import de.unbound.game.model.entities.mobile.Commander;
import de.unbound.game.model.entities.mobile.Pawn;
import de.unbound.game.model.entities.mobile.Player;
import de.unbound.game.model.entities.mobile.Projectile;
import de.unbound.game.model.entities.mobile.Scavenger;
import de.unbound.game.model.entities.mobile.prelates.PrelateBoss;
import de.unbound.game.model.entities.mobile.prelates.PrelateCollector;
import de.unbound.game.model.entities.mobile.prelates.PrelateCommander;
import de.unbound.game.model.entities.mobile.prelates.PrelatePawn;
import de.unbound.game.model.entities.mobile.prelates.PrelatePlayer;
import de.unbound.game.model.entities.mobile.prelates.PrelateProjectile;
import de.unbound.game.model.entities.mobile.prelates.PrelateScavenger;

public class RacePrelateFactory extends AbstractRaceFactory {
	
	private static RacePrelateFactory instance;
	
	public static RacePrelateFactory getRacePrelateFactory(){
		if(instance == null)
			instance = new RacePrelateFactory();
		return instance;
	}
	
	private RacePrelateFactory() {
	}

	@Override
	protected Boss createBoss() {
		Boss boss = createEntitiy(PrelateBoss.class);
		battlefield.add(boss);
		return boss;
	}

	@Override
	protected Commander createCommander() {
		Commander commander = createEntitiy(PrelateCommander.class);
		battlefield.add(commander);
		return commander;
	}

	@Override
	protected Scavenger createScavenger() {
		Scavenger scavenger = createEntitiy(PrelateScavenger.class);
		battlefield.add(scavenger);
		return scavenger;
	}

	@Override
	protected Pawn createPawn() {
		Pawn pawn = createEntitiy(PrelatePawn.class);
		battlefield.add(pawn);
		return pawn;
	}

	@Override
	public Player createPlayer() {
		Player player = createEntitiy(PrelatePlayer.class);
		battlefield.add(player);
		return player;
	}

	@Override
	public Collector createCollector() {
		Collector collector = createEntitiy(PrelateCollector.class);
		battlefield.add(collector);
		return collector;
	}

	@Override
	protected MainBase createMainBase() {
		MainBase mainBase = createEntitiy(PrelateMainBase.class);
		battlefield.add(mainBase);
		return mainBase;
	}

	@Override
	public Tower createTower() {
		Tower tower = createEntitiy(PrelateTower.class);
		battlefield.add(tower);
		return tower;
	}

	@Override
	protected Deposit createDeposit() {
		Deposit deposit = createEntitiy(PrelateDeposit.class);
		battlefield.add(deposit);
		return deposit;
	}

	@Override
	protected Spawner createSpawner() {
		Spawner spawner = createEntitiy(PrelateSpawner.class);
		battlefield.add(spawner);
		return spawner;
	}

	@Override
	public Projectile createProjectile() {
		Projectile commander = createEntitiy(PrelateProjectile.class);
		battlefield.add(commander);
		return commander;
	}
}
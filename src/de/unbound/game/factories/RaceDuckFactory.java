package de.unbound.game.factories;

import de.unbound.game.model.entities.immobile.Deposit;
import de.unbound.game.model.entities.immobile.MainBase;
import de.unbound.game.model.entities.immobile.Spawner;
import de.unbound.game.model.entities.immobile.Tower;
import de.unbound.game.model.entities.immobile.ducks.DuckDeposit;
import de.unbound.game.model.entities.immobile.ducks.DuckMainBase;
import de.unbound.game.model.entities.immobile.ducks.DuckSpawner;
import de.unbound.game.model.entities.immobile.ducks.DuckTower;
import de.unbound.game.model.entities.mobile.Boss;
import de.unbound.game.model.entities.mobile.Collector;
import de.unbound.game.model.entities.mobile.Commander;
import de.unbound.game.model.entities.mobile.Pawn;
import de.unbound.game.model.entities.mobile.Player;
import de.unbound.game.model.entities.mobile.Projectile;
import de.unbound.game.model.entities.mobile.Scavenger;
import de.unbound.game.model.entities.mobile.ducks.DuckBoss;
import de.unbound.game.model.entities.mobile.ducks.DuckCollector;
import de.unbound.game.model.entities.mobile.ducks.DuckCommander;
import de.unbound.game.model.entities.mobile.ducks.DuckPawn;
import de.unbound.game.model.entities.mobile.ducks.DuckPlayer;
import de.unbound.game.model.entities.mobile.ducks.DuckProjectile;
import de.unbound.game.model.entities.mobile.ducks.DuckScavenger;

public class RaceDuckFactory extends AbstractRaceFactory {
	
	private static RaceDuckFactory instance;
	
	public static RaceDuckFactory getRaceDuckFactory(){
		if(instance == null)
			instance = new RaceDuckFactory();
		return instance;
	}
	
	private RaceDuckFactory() {
	}

	@Override
	protected Boss createBoss() {
		Boss boss = createEntitiy(DuckBoss.class);
		battlefield.add(boss);
		return boss;
	}

	@Override
	protected Commander createCommander() {
		Commander commander = createEntitiy(DuckCommander.class);
		battlefield.add(commander);
		return commander;
	}

	@Override
	protected Scavenger createScavenger() {
		Scavenger scavenger = createEntitiy(DuckScavenger.class);
		battlefield.add(scavenger);
		return scavenger;
	}

	@Override
	protected Pawn createPawn() {
		Pawn pawn = createEntitiy(DuckPawn.class);
		battlefield.add(pawn);
		return pawn;
	}

	@Override
	public Player createPlayer() {
		Player player = createEntitiy(DuckPlayer.class);
		battlefield.add(player);
		return player;
	}

	@Override
	public Collector createCollector() {
		Collector collector = createEntitiy(DuckCollector.class);
		battlefield.add(collector);
		return collector;
	}

	@Override
	protected MainBase createMainBase() {
		MainBase mainBase = createEntitiy(DuckMainBase.class);
		battlefield.add(mainBase);
		return mainBase;
	}

	@Override
	public Tower createTower() {
		Tower tower = createEntitiy(DuckTower.class);
		battlefield.add(tower);
		return tower;
	}

	@Override
	protected Deposit createDeposit() {
		Deposit deposit = createEntitiy(DuckDeposit.class);
		battlefield.add(deposit);
		return deposit;
	}

	@Override
	protected Spawner createSpawner() {
		Spawner spawner = createEntitiy(DuckSpawner.class);
		battlefield.add(spawner);
		return spawner;
	}

	@Override
	public Projectile createProjectile() {
		Projectile commander = createEntitiy(DuckProjectile.class);
		battlefield.add(commander);
		return commander;
	}
}
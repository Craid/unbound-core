package de.unbound.game.factories;

import de.unbound.game.model.entities.immobile.ducks.DuckDeposit;
import de.unbound.game.model.entities.immobile.ducks.DuckMainBase;
import de.unbound.game.model.entities.immobile.ducks.DuckSpawner;
import de.unbound.game.model.entities.immobile.ducks.DuckTower;
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
	protected DuckBoss createBoss() {
		DuckBoss boss = createEntitiy(DuckBoss.class);
		battlefield.add(boss);
		return boss;
	}

	@Override
	protected DuckCommander createCommander() {
		DuckCommander commander = createEntitiy(DuckCommander.class);
		battlefield.add(commander);
		return commander;
	}

	@Override
	protected DuckScavenger createScavenger() {
		DuckScavenger scavenger = createEntitiy(DuckScavenger.class);
		battlefield.add(scavenger);
		return scavenger;
	}

	@Override
	protected DuckPawn createPawn() {
		DuckPawn pawn = createEntitiy(DuckPawn.class);
		battlefield.add(pawn);
		return pawn;
	}

	@Override
	public DuckPlayer createPlayer() {
		DuckPlayer player = createEntitiy(DuckPlayer.class);
		battlefield.add(player);
		return player;
	}

	@Override
	public DuckCollector createCollector() {
		DuckCollector collector = createEntitiy(DuckCollector.class);
		battlefield.add(collector);
		return collector;
	}

	@Override
	public DuckMainBase createMainBase() {
		DuckMainBase mainBase = createEntitiy(DuckMainBase.class);
		battlefield.add(mainBase);
		return mainBase;
	}

	@Override
	public DuckTower createTower() {
		DuckTower tower = createEntitiy(DuckTower.class);
		battlefield.add(tower);
		return tower;
	}

	@Override
	protected DuckDeposit createDeposit() {
		DuckDeposit deposit = createEntitiy(DuckDeposit.class);
		battlefield.add(deposit);
		return deposit;
	}

	@Override
	public DuckSpawner createSpawner() {
		DuckSpawner spawner = createEntitiy(DuckSpawner.class);
		battlefield.add(spawner);
		return spawner;
	}

	@Override
	public DuckProjectile createProjectile() {
		DuckProjectile projectile = createEntitiy(DuckProjectile.class);
		battlefield.add(projectile);
		return projectile;
	}
}
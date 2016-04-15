package de.unbound.game.factories;

import de.unbound.game.model.entities.immobile.prelates.PrelateDeposit;
import de.unbound.game.model.entities.immobile.prelates.PrelateMainBase;
import de.unbound.game.model.entities.immobile.prelates.PrelateSpawner;
import de.unbound.game.model.entities.immobile.prelates.PrelateTower;
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
	protected PrelateBoss createBoss() {
		PrelateBoss boss = createEntitiy(PrelateBoss.class);
		battlefield.add(boss);
		return boss;
	}

	@Override
	protected PrelateCommander createCommander() {
		PrelateCommander commander = createEntitiy(PrelateCommander.class);
		battlefield.add(commander);
		return commander;
	}

	@Override
	protected PrelateScavenger createScavenger() {
		PrelateScavenger scavenger = createEntitiy(PrelateScavenger.class);
		battlefield.add(scavenger);
		return scavenger;
	}

	@Override
	protected PrelatePawn createPawn() {
		PrelatePawn pawn = createEntitiy(PrelatePawn.class);
		battlefield.add(pawn);
		return pawn;
	}

	@Override
	public PrelatePlayer createPlayer() {
		PrelatePlayer player = createEntitiy(PrelatePlayer.class);
		battlefield.add(player);
		return player;
	}

	@Override
	public PrelateCollector createCollector() {
		PrelateCollector collector = createEntitiy(PrelateCollector.class);
		battlefield.add(collector);
		return collector;
	}

	@Override
	public PrelateMainBase createMainBase() {
		PrelateMainBase mainBase = createEntitiy(PrelateMainBase.class);
		battlefield.add(mainBase);
		return mainBase;
	}

	@Override
	public PrelateTower createTower() {
		PrelateTower tower = createEntitiy(PrelateTower.class);
		battlefield.add(tower);
		return tower;
	}

	@Override
	protected PrelateDeposit createDeposit() {
		PrelateDeposit deposit = createEntitiy(PrelateDeposit.class);
		battlefield.add(deposit);
		return deposit;
	}

	@Override
	public PrelateSpawner createSpawner() {
		PrelateSpawner spawner = createEntitiy(PrelateSpawner.class);
		battlefield.add(spawner);
		return spawner;
	}

	@Override
	public PrelateProjectile createProjectile() {
		PrelateProjectile projectile = createEntitiy(PrelateProjectile.class);
		battlefield.add(projectile);
		return projectile;
	}
}
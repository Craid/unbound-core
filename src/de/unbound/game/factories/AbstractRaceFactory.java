package de.unbound.game.factories;

import java.util.ArrayList;

import de.unbound.game.model.entities.immobile.Base;
import de.unbound.game.model.entities.immobile.Deposit;
import de.unbound.game.model.entities.immobile.ImmobileEntity;
import de.unbound.game.model.entities.immobile.MainBase;
import de.unbound.game.model.entities.immobile.Spawner;
import de.unbound.game.model.entities.immobile.Tower;
import de.unbound.game.model.entities.mobile.Boss;
import de.unbound.game.model.entities.mobile.Collector;
import de.unbound.game.model.entities.mobile.Commander;
import de.unbound.game.model.entities.mobile.MobileEntity;
import de.unbound.game.model.entities.mobile.Pawn;
import de.unbound.game.model.entities.mobile.Player;
import de.unbound.game.model.entities.mobile.Scavenger;
import de.unbound.game.wave.WaveOrder;

public abstract class AbstractRaceFactory {

	/**
	 * 
	 * @param order
	 */
	public ArrayList<MobileEntity> createWave(WaveOrder order) {
		ArrayList<MobileEntity> entities = new ArrayList<MobileEntity>();
		for(int i = 0; i < order.getBossNumber(); i++)
			entities.add(createBoss());
		for(int i = 0; i < order.getCommanderNumber(); i++)
			entities.add(createCommander());
		for(int i = 0; i < order.getScavengerNumber(); i++)
			entities.add(createScavenger());
		for(int i = 0; i < order.getPawnNumber(); i++)
			entities.add(createPawn());
		return entities;
	}

	protected abstract Boss createBoss();

	protected abstract Commander createCommander();

	protected abstract Scavenger createScavenger();

	protected abstract Pawn createPawn();

	public abstract Player createPlayer();

	public abstract Collector createCollector();

	/**
	 * 
	 * @param seed
	 */
	public ArrayList<ImmobileEntity> createImmobileEntities(double seed) {
		// TODO - implement AbstractRaceFactory.createImmobileEntities
		throw new UnsupportedOperationException();
	}

	protected abstract MainBase createMainBase();

	protected abstract Base createBase();

	public abstract Tower createTower();

	protected abstract Deposit createDeposit();

	protected abstract Spawner createSpawner();

}
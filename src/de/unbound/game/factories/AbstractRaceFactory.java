package de.unbound.game.factories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.entities.Entity;
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

	protected FlyweightFactory flyweightFactory;
	private ArrayList<MobileEntity> wave;

	public AbstractRaceFactory() {
		flyweightFactory = FlyweightFactory.instance;
		wave = new ArrayList<MobileEntity>();
	}
	
	/**
	 * 
	 * @param seed
	 */
	public ArrayList<ImmobileEntity> createImmobileEntities(double seed) {
		ArrayList<ImmobileEntity> immobileEntities = new ArrayList<ImmobileEntity>();
		immobileEntities.add(createMainBase());
		
		Tower tempTower = createTower();
		tempTower.setPosition(new Vector2(35,65));
		immobileEntities.add(tempTower);
		tempTower = createTower();
		tempTower.setPosition(new Vector2(35,130));
		immobileEntities.add(tempTower);
		
		Random random = new Random((long)seed);
		for(int i = 0; i < 6; i++){
			Deposit tempDeposit = createDeposit();
			float x = (float)(random.nextFloat()*20+20);
			float y = (float)(random.nextFloat()*20+20 + (i/2)*65);
			tempDeposit.setPosition(new Vector2(x, y));
			immobileEntities.add(tempDeposit);
		}
		
		return immobileEntities;
	}

	/**
	 * 
	 * @param order
	 */
	public ArrayList<MobileEntity> createWave(WaveOrder order) {
		wave.clear();

		for (int i = 0; i < order.getBossNumber(); i++)
			wave.add(createBoss());
		for (int i = 0; i < order.getCommanderNumber(); i++)
			wave.add(createCommander());
		for (int i = 0; i < order.getScavengerNumber(); i++)
			wave.add(createScavenger());
		for (int i = 0; i < order.getPawnNumber(); i++)
			wave.add(createPawn());

		Vector2 spawn = new Vector2(35, 190);
		for (MobileEntity e : wave){
			e.setHostile(true);
			e.setPosition(spawn);
		}
		
		Collections.shuffle(wave);

		return wave;
	}

	protected <T extends Entity> T createEntitiy(Class<T> c) {
		T t = null;
		try {
			t = c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		t.setModel(flyweightFactory.getFlyweight(c.getSimpleName()));
		return t;
	}
	
	protected abstract Boss createBoss();

	protected abstract Commander createCommander();

	protected abstract Scavenger createScavenger();

	protected abstract Pawn createPawn();

	public abstract Player createPlayer();

	public abstract Collector createCollector();

	protected abstract MainBase createMainBase();

	public abstract Tower createTower();

	protected abstract Deposit createDeposit();

	protected abstract Spawner createSpawner();

}
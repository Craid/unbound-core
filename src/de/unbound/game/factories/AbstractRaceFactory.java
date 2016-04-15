package de.unbound.game.factories;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.BattleField;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.immobile.Deposit;
import de.unbound.game.model.entities.immobile.MainBase;
import de.unbound.game.model.entities.immobile.Spawner;
import de.unbound.game.model.entities.immobile.Tower;
import de.unbound.game.model.entities.mobile.Boss;
import de.unbound.game.model.entities.mobile.Collector;
import de.unbound.game.model.entities.mobile.Commander;
import de.unbound.game.model.entities.mobile.MobileEntity;
import de.unbound.game.model.entities.mobile.Pawn;
import de.unbound.game.model.entities.mobile.Player;
import de.unbound.game.model.entities.mobile.Projectile;
import de.unbound.game.model.entities.mobile.Scavenger;
import de.unbound.game.wave.WaveOrder;
import de.unbound.utility.UnboundConstants;

public abstract class AbstractRaceFactory {

	protected FlyweightFactory flyweightFactory;
	private ArrayList<MobileEntity> wave;
	protected BattleField battlefield;
	
	public AbstractRaceFactory() {
		flyweightFactory = FlyweightFactory.getInstance();
		wave = new ArrayList<MobileEntity>();
		battlefield = BattleField.getBattleField();
	}
	
	/**
	 * 
	 * @param seed
	 */
	public void createImmobileEntities(double seed) {
		
		createMainBase();
		
		Tower tempTower = createTower();
		tempTower.setPosition(new Vector2(UnboundConstants.WORLDWIDTH/2,UnboundConstants.WORLDHEIGHT/3));
		
		tempTower = createTower();
		tempTower.setPosition(new Vector2(UnboundConstants.WORLDWIDTH/2,UnboundConstants.WORLDHEIGHT*2/3));
		
		Random random = new Random((long)seed);
		
		for(int i = 0; i < 6; i++){
			Deposit tempDeposit = createDeposit();
			float x = (float)((int)(random.nextFloat()*UnboundConstants.SINGLEGRIDWIDTH*UnboundConstants.GRIDWIDTH)+UnboundConstants.SINGLEGRIDWIDTH);
			float y = (float)((int)(random.nextFloat()*UnboundConstants.SINGLEGRIDHEIGHT*2) + (i/2)*UnboundConstants.WORLDHEIGHT/3);
			tempDeposit.setPosition(new Vector2(x, y));
		}
		
	}

	/**
	 * 
	 * @param order
	 */
	public void createWave(WaveOrder order) {
		wave.clear();

		for (int i = 0; i < order.getBossNumber(); i++)
			wave.add(createBoss());
		for (int i = 0; i < order.getCommanderNumber(); i++)
			wave.add(createCommander());
		for (int i = 0; i < order.getScavengerNumber(); i++)
			wave.add(createScavenger());
		for (int i = 0; i < order.getPawnNumber(); i++)
			wave.add(createPawn());
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

	public abstract Projectile createProjectile();

	public abstract Player createPlayer();

	public abstract Collector createCollector();

	protected abstract MainBase createMainBase();

	public abstract Tower createTower();

	protected abstract Deposit createDeposit();

	public abstract Spawner createSpawner();

}
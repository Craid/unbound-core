package de.unbound.game.wave;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.BattleField;
import de.unbound.game.factories.EntityFactory;
import de.unbound.game.model.entities.Entity;

public abstract class WaveHandler {

	private ArrayList<WaveOrder> orders;
	private WaveOrder currentOrder;
	private EntityFactory ownFactory;
	private EntityFactory enemyFactory;
	private boolean newOrder;
	protected int level;
	private float seed;
	protected static final int WAVETIMEOUTS = 5;
	protected double cummulativeTime;

	public WaveHandler(EntityFactory ownFactory, EntityFactory enemyFactory) {
		setOwnFactory(ownFactory);
		setEnemyFactory(enemyFactory);
		orders = new ArrayList<WaveOrder>();
		newOrder = false;
		level = -1;
		seed = (float) Math.random();
		cummulativeTime = 0;
	}
	
	public void setBattleFieldForFactories(BattleField battleField){
		ownFactory.setBattlefield(battleField);
		enemyFactory.setBattlefield(battleField);
		
		Entity spawner = enemyFactory.createEntity("Spawner");
		spawner.setDirection(new Vector2(0,-1));
		ownFactory.createMap(this.getSeed());
		
	}

	public EntityFactory getOwnFactory() {
		return ownFactory;
	}

	protected void setOwnFactory(EntityFactory ownFactory) {
		this.ownFactory = ownFactory;
	}

	public EntityFactory getEnemyFactory() {
		return enemyFactory;
	}

	protected void setEnemyFactory(EntityFactory enemyFactory) {
		this.enemyFactory = enemyFactory;
	}

	/**
	 * 
	 * @param deltaTime
	 */
	public abstract void update(double deltaTime);

	/**
	 * 
	 * @param n
	 */
	public WaveOrder getCurrentOrder() {
		if (newOrder) {
			orders.add(currentOrder);
			newOrder = false;
			return currentOrder;
		} else {
			return WaveOrder.NullOrder();
		}
	}

	protected void setCurrentOrder(WaveOrder wo) {
		newOrder = true;
		currentOrder = wo;
	}

	public boolean hasNewOrder() {
		return newOrder;
	}

	public int getLevel() {
		return level;
	}

	public float getSeed() {
		return seed;
	}

	protected void setSeed(float newSeed) {
		seed = newSeed;
	}

}
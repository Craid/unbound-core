package de.unbound.game.wave;

import java.util.ArrayList;

import de.unbound.game.factories.AbstractRaceFactory;

public abstract class WaveHandler {

	private ArrayList<WaveOrder> orders;
	private WaveOrder currentOrder;
	private WaveReport ownWaveReport;
	private AbstractRaceFactory ownFactory;
	private AbstractRaceFactory enemyFactory;
	private boolean newOrder;
	protected int level;
	private float seed;
	
	public WaveHandler(AbstractRaceFactory ownFactory, AbstractRaceFactory enemyFactory) {
		setOwnFactory(ownFactory);
		setEnemyFactory(enemyFactory);
		orders = new ArrayList<WaveOrder>();
		newOrder = false;
		level = -1;
		seed = (float) Math.random();
	}

	public AbstractRaceFactory getOwnFactory() {
		return ownFactory;
	}

	protected void setOwnFactory(AbstractRaceFactory ownFactory) {
		this.ownFactory = ownFactory;
	}

	public AbstractRaceFactory getEnemyFactory() {
		return enemyFactory;
	}

	protected void setEnemyFactory(AbstractRaceFactory enemyFactory) {
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
		if(newOrder){
			orders.add(currentOrder);
			newOrder = false;
			return currentOrder;
		}else{
			return WaveOrder.NullOrder();
		}
	}
	
	protected void setCurrentOrder(WaveOrder wo) {
		newOrder = true;
		currentOrder = wo;
	}

	public WaveReport getOwnWaveReport() {
		return this.ownWaveReport;
	}

	/**
	 * 
	 * @param newWaveOrder
	 */
	public void setWaveReport(de.unbound.game.wave.WaveReport newWaveOrder) {
		// TODO - implement WaveHandler.setWaveReport
		throw new UnsupportedOperationException();
	}
	
	public boolean hasNewOrder(){
		return newOrder;
	}
	
	public int getLevel(){
		return level;
	}
	
	public float getSeed(){
		return seed;
	}
	
	protected void setSeed(float newSeed){
		seed = newSeed;
	}
	
}
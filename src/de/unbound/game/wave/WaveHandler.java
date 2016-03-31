package de.unbound.game.wave;

import java.util.ArrayList;

public abstract class WaveHandler {

	protected ArrayList<WaveOrder> orders;
	private de.unbound.game.wave.WaveReport ownWaveReport;
	private double time;

	/**
	 * 
	 * @param deltaTime
	 */
	public abstract void update(double deltaTime);

	/**
	 * 
	 * @param n
	 */
	public WaveOrder getOrderAtPosition(int n) {
		// TODO - implement WaveHandler.getOrderAtPosition
		throw new UnsupportedOperationException();
	}

	public de.unbound.game.wave.WaveReport getOwnWaveReport() {
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

}
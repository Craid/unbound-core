package de.unbound.game.wave;

public class WaveOrder {

	private int bossNumber;
	private int pawnNumber;
	private int scavengerNumber;
	private int commanderNumber;
	private int bossUpgrades;
	private int pawnUpgrades;
	private int scavengerUpgrades;
	private int commanderUpgrades;

	public int getHeroNumber() {
		// TODO - implement WaveOrder.getHeroNumber
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param heroNumber
	 */
	public void setHeroNumber(int heroNumber) {
		// TODO - implement WaveOrder.setHeroNumber
		throw new UnsupportedOperationException();
	}

	public int getPawnNumber() {
		return this.pawnNumber;
	}

	/**
	 * 
	 * @param pawnNumber
	 */
	public void setPawnNumber(int pawnNumber) {
		this.pawnNumber = pawnNumber;
	}

	public int getScavengerNumber() {
		return this.scavengerNumber;
	}

	/**
	 * 
	 * @param scavengerNumber
	 */
	public void setScavengerNumber(int scavengerNumber) {
		this.scavengerNumber = scavengerNumber;
	}

	public int getCommanderNumber() {
		return this.commanderNumber;
	}

	/**
	 * 
	 * @param commanderNumber
	 */
	public void setCommanderNumber(int commanderNumber) {
		this.commanderNumber = commanderNumber;
	}

	public int getBossUpgrades() {
		return this.bossUpgrades;
	}

	/**
	 * 
	 * @param bossUpgrades
	 */
	public void setBossUpgrades(int bossUpgrades) {
		this.bossUpgrades = bossUpgrades;
	}

	public int getPawnUpgrades() {
		return this.pawnUpgrades;
	}

	/**
	 * 
	 * @param pawnUpgrades
	 */
	public void setPawnUpgrades(int pawnUpgrades) {
		this.pawnUpgrades = pawnUpgrades;
	}

	public int getScavengerUpgrades() {
		return this.scavengerUpgrades;
	}

	/**
	 * 
	 * @param scavengerUpgrades
	 */
	public void setScavengerUpgrades(int scavengerUpgrades) {
		this.scavengerUpgrades = scavengerUpgrades;
	}

	public int getCommanderUpgrades() {
		return this.commanderUpgrades;
	}

	/**
	 * 
	 * @param commanderUpgrades
	 */
	public void setCommanderUpgrades(int commanderUpgrades) {
		this.commanderUpgrades = commanderUpgrades;
	}

}
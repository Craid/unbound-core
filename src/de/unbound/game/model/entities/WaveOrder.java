package de.unbound.game.model.entities;

public class WaveOrder {

	private int bossNumber;
	private int pawnNumber;
	private int scavengerNumber;
	private int commanderNumber;
	
	private static WaveOrder nullorder = new WaveOrder();
	
	public WaveOrder(){
		this(0,0,0,0);
	}
	
	public static WaveOrder getNullOrder(){
		return nullorder;
	}

	public WaveOrder(int bosses, int pawns, int scavengers, int commanders) {
		bossNumber = bosses;
		pawnNumber = pawns;
		scavengerNumber = scavengers;
		commanderNumber = commanders;
	}

	public int getBossNumber() {
		return bossNumber;
	}

	public void setBossNumber(int bossNumber) {
		this.bossNumber = bossNumber;
	}

	public int getPawnNumber() {
		return this.pawnNumber;
	}

	public void setPawnNumber(int pawnNumber) {
		this.pawnNumber = pawnNumber;
	}

	public int getScavengerNumber() {
		return this.scavengerNumber;
	}

	public void setScavengerNumber(int scavengerNumber) {
		this.scavengerNumber = scavengerNumber;
	}

	public int getCommanderNumber() {
		return this.commanderNumber;
	}

	public void setCommanderNumber(int commanderNumber) {
		this.commanderNumber = commanderNumber;
	}

	public String toString(){
		return "Entity in Wave: " + (bossNumber+commanderNumber+pawnNumber+scavengerNumber);
	}
	
	public boolean equals(WaveOrder obj) {
		return bossNumber == obj.bossNumber 
				&& commanderNumber == obj.commanderNumber 
				&& scavengerNumber == obj.scavengerNumber
				&& pawnNumber == obj.pawnNumber;
	}

}
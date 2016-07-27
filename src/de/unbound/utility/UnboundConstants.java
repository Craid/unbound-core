package de.unbound.utility;


public class UnboundConstants {

	public static final int GRIDWIDTH = 7;
	public static final int GRIDHEIGHT = 20;

	public static final int SINGLEBIGUNITWIDTH = 300;
	public static final int SINGLEGRIDWIDTH = 180;
	public static final int SINGLEGRIDHEIGHT = SINGLEGRIDWIDTH;
	public static final int WORLDWIDTH = SINGLEGRIDWIDTH * GRIDWIDTH;
	public static final int WORLDHEIGHT = SINGLEGRIDHEIGHT * GRIDHEIGHT;

	public static final double SHOTSPEED = 1;


	public enum Race{
		Duck,Prelate;
	}
	
	public enum MobileEntity{
		Boss,Commander,Scavenger,Collector,Pawn,Player,Projectile;
	}
	
	public enum ImmobileEntity{
		Spawner,Deposit,Tower,MainBase;
	}
}

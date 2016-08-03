package de.unbound.utility;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class UnboundConstants {

	public static String IPADDRESS = "localhost";
	//public static String IPADDRESS = "176.198.201.21";
	//176.198.201.21
	public static int tcpPort = 11300;	
	public static int udpPort = 11301;
	
	public static final int GRIDWIDTH = 7;
	public static final int GRIDHEIGHT = 20;

	public static final int SINGLEBIGUNITWIDTH = 300;
	public static final int SINGLEGRIDWIDTH = 180;
	public static final int SINGLEGRIDHEIGHT = SINGLEGRIDWIDTH;
	public static final int WORLDWIDTH = SINGLEGRIDWIDTH * GRIDWIDTH;
	public static final int WORLDHEIGHT = SINGLEGRIDHEIGHT * GRIDHEIGHT;

	public static final double SHOTSPEED = 1;

	public static Vector2 ENEMY_SPAWNPOINT = new Vector2(UnboundConstants.WORLDWIDTH / 2,
			UnboundConstants.WORLDHEIGHT - UnboundConstants.SINGLEGRIDHEIGHT);
	
	public static Vector2 SPAWNPOINT = new Vector2(UnboundConstants.WORLDWIDTH / 2,
			UnboundConstants.SINGLEGRIDHEIGHT * 2);
	
	public static Rectangle WORLD = new Rectangle(0, 0, WORLDWIDTH, WORLDHEIGHT);
	public static Circle SPAWNER = new Circle(ENEMY_SPAWNPOINT,SINGLEBIGUNITWIDTH );
	
	
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

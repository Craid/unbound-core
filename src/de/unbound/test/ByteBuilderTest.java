package de.unbound.test;

import de.unbound.game.network.serialization.ByteBuilderHelper;

public class ByteBuilderTest {
	
	public void main(String[] args){
		System.out.println("lol");
	}
	
	
	public void main2(String[] args){
		
		ByteBuilderHelper b = new ByteBuilderHelper();
		
		// (int)	id		4 byte
		byte[] byteID = b.intToByteArray(343);
		// (byte)	type	1 byte
		byte[] byteType = b.byteToByteArray((byte)1); //= intToByteArray(player.getModel().get); ??
		// (float)	positionX	4 byte
		byte[] bytePosX = b.floatToByteArray(1.41f);
		// (float)	positionY	4 byte
		byte[] bytePosY = b.floatToByteArray(2.564f);
		// (float)	direction	4 byte
		byte[] byteDirX = b.floatToByteArray(0.240f);
		// (float)	direction	4 byte
		byte[] byteDirY = b.floatToByteArray(0.444f);
		// (float)	velocityX	4 byte
		byte[] byteVelX = b.floatToByteArray(1242.23f); // eig sollte velocity auch ein vektor sein
		// (float)	velocityY	4 byte
		byte[] byteVelY = b.floatToByteArray(1992.23f); // eig sollte velocity auch ein vektor sein
		//         <<<<	fehlt >>>>
		
		// Zusammenschweiﬂen
		byte[] sum = new byte[29];

		sum[0] = byteID[0];
		sum[1] = byteID[1];
		sum[2] = byteID[2];
		sum[3] = byteID[3];
		sum[4] = byteType[0];
		sum[5] = bytePosX[0];
		sum[6] = bytePosX[1];
		sum[7] = bytePosX[2];
		sum[8] = bytePosX[3];
		sum[9] = bytePosY[0];
		sum[10] = bytePosY[1];
		sum[11] = bytePosY[2];
		sum[12] = bytePosY[3];
		sum[13] = byteDirX[0];
		sum[14] = byteDirX[1];
		sum[15] = byteDirX[2];
		sum[16] = byteDirX[3];
		sum[17] = byteDirY[0];
		sum[18] = byteDirY[1];
		sum[19] = byteDirY[2];
		sum[20] = byteDirY[3];
		sum[21] = byteVelX[0];
		sum[22] = byteVelX[1];
		sum[23] = byteVelX[2];
		sum[24] = byteVelX[3];
		sum[25] = byteVelY[0];
		sum[26] = byteVelY[1];
		sum[27] = byteVelY[2];
		sum[28] = byteVelY[3];
		

		
		System.out.println(b.intFromByteArray(sum,0)+" = Entity ID");
		System.out.println(b.byteFromByteArray(sum,4)+" = Entity Class");
		System.out.println(b.floatFromByteArray(sum,5)+" = Position X");
		System.out.println(b.floatFromByteArray(sum,9)+" = Position Y");
		System.out.println(b.floatFromByteArray(sum,13)+" = Direction X");
		System.out.println(b.floatFromByteArray(sum,17)+" = Direction Y");
		System.out.println(b.floatFromByteArray(sum,21)+" = Velocity X");
		System.out.println(b.floatFromByteArray(sum,25)+" = Velocity Y");
		
	}
	


}

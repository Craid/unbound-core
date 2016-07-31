package de.unbound.game.network.serialization;

import java.nio.ByteBuffer;

public class ByteBuilderHelper {
	
	public ByteBuilderHelper(){
	}
	
	public int intToByteArray(byte[] bytes) {
	     return ByteBuffer.wrap(bytes).getInt();
	}
	public int intToByteArray(byte[] bytes, int startingIndex) {
		
		byte[] array = {bytes[startingIndex],bytes[startingIndex+1],bytes[startingIndex+2],bytes[startingIndex+3]};
		return ByteBuffer.wrap(array).getInt();
	}
	
	public float floatToByteArray(byte[] bytes) {
	     return ByteBuffer.wrap(bytes).getFloat();
	}
	public float floatToByteArray(byte[] bytes, int startingIndex) {
		byte[] array = {bytes[startingIndex],bytes[startingIndex+1],bytes[startingIndex+2],bytes[startingIndex+3]};
	     return ByteBuffer.wrap(array).getFloat();
	}
	
	public byte byteToByteArray(byte[] bytes) {
	     return ByteBuffer.wrap(bytes).get();
	}
	public byte byteToByteArray(byte[] bytes, int startingIndex) {
		byte[] array = {bytes[startingIndex]};
	     return ByteBuffer.wrap(array).get();
	}
	
	public double doubleToByteArray(byte[] bytes) {
	     return ByteBuffer.wrap(bytes).getDouble();
	}
	public double doubleToByteArray(byte[] bytes, int startingIndex) {
		byte[] array = {bytes[startingIndex],bytes[startingIndex+1],bytes[startingIndex+2],
				bytes[startingIndex+3],bytes[startingIndex+4],bytes[startingIndex+5],bytes[startingIndex+6],bytes[startingIndex+7]};
	     return ByteBuffer.wrap(array).getDouble();
	}
	
	public long longFromToArray(byte[] bytes) {
	     return ByteBuffer.wrap(bytes).getLong();
	}
	public long longFromToArray(byte[] bytes, int startingIndex) {
		byte[] array = {bytes[startingIndex],bytes[startingIndex+1],bytes[startingIndex+2],
				bytes[startingIndex+3],bytes[startingIndex+4],bytes[startingIndex+5],bytes[startingIndex+6],bytes[startingIndex+7]};
	     return ByteBuffer.wrap(array).getLong();
	}

	
	
	public byte [] longToByteArray (long value)
	{
	    return ByteBuffer.allocate(8).putLong(value).array();
	}
	public byte [] floatToByteArray (float value)
	{  
	     return ByteBuffer.allocate(4).putFloat(value).array();
	}
	public byte [] intToByteArray (int value)
	{  
	     return ByteBuffer.allocate(4).putInt(value).array();
	}
	public byte [] byteToByteArray (byte value)
	{  
	     return ByteBuffer.allocate(1).put(value).array();
	}
	
	public byte [] getTimeStampAsByteArray ()
	{
	    return ByteBuffer.allocate(8).putLong(System.currentTimeMillis()).array();
	}
	
	public long getTimeStampFromByteArray(byte[] data)
	{
		return ByteBuffer.allocate(8).getLong();
	}
	
	
	
	
	public void main(String[] args){
		System.out.println("lol");
	}
	
	
	public void main2(String[] args){

		// (int)	id		4 byte
		byte[] byteID = intToByteArray(343);
		// (byte)	type	1 byte
		byte[] byteType = byteToByteArray((byte)1); //= intToByteArray(player.getModel().get); ??
		// (float)	positionX	4 byte
		byte[] bytePosX = floatToByteArray(1.41f);
		// (float)	positionY	4 byte
		byte[] bytePosY = floatToByteArray(2.564f);
		// (float)	direction	4 byte
		byte[] byteDirX = floatToByteArray(0.240f);
		// (float)	direction	4 byte
		byte[] byteDirY = floatToByteArray(0.444f);
		// (float)	velocityX	4 byte
		byte[] byteVelX = floatToByteArray(1242.23f); // eig sollte velocity auch ein vektor sein
		// (float)	velocityY	4 byte
		byte[] byteVelY = floatToByteArray(1992.23f); // eig sollte velocity auch ein vektor sein
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
		

		
		System.out.println(intToByteArray(sum,0)+" = Entity ID");
		System.out.println(byteToByteArray(sum,4)+" = Entity Class");
		System.out.println(floatToByteArray(sum,5)+" = Position X");
		System.out.println(floatToByteArray(sum,9)+" = Position Y");
		System.out.println(floatToByteArray(sum,13)+" = Direction X");
		System.out.println(floatToByteArray(sum,17)+" = Direction Y");
		System.out.println(floatToByteArray(sum,21)+" = Velocity X");
		System.out.println(floatToByteArray(sum,25)+" = Velocity Y");
		
	}
	

}

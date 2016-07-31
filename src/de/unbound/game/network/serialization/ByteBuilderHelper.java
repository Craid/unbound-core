package de.unbound.game.network.serialization;

import java.nio.ByteBuffer;

public class ByteBuilderHelper {
	
	public ByteBuilderHelper(){
	}
	
	public int intFromByteArray(byte[] bytes) {
	     return ByteBuffer.wrap(bytes).getInt();
	}
	
	public int intFromByteArray(byte[] bytes, int startingIndex) {
		byte[] array = {bytes[startingIndex],bytes[startingIndex+1],bytes[startingIndex+2],bytes[startingIndex+3]};
		return ByteBuffer.wrap(array).getInt();
	}
	
	public float floatFromByteArray(byte[] bytes) {
	     return ByteBuffer.wrap(bytes).getFloat();
	}
	public float floatFromByteArray(byte[] bytes, int startingIndex) {
		byte[] array = {bytes[startingIndex],bytes[startingIndex+1],bytes[startingIndex+2],bytes[startingIndex+3]};
	     return ByteBuffer.wrap(array).getFloat();
	}
	
	public byte byteFromByteArray(byte[] bytes) {
	     return ByteBuffer.wrap(bytes).get();
	}
	public byte byteFromByteArray(byte[] bytes, int startingIndex) {
		byte[] array = {bytes[startingIndex]};
	     return ByteBuffer.wrap(array).get();
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
	
}

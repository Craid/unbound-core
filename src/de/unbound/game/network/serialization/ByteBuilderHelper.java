package de.unbound.game.network.serialization;

import java.nio.ByteBuffer;

public class ByteBuilderHelper {
	
	public ByteBuilderHelper(){
	}
	
	public int intFromByteArray(byte[] bytes, int startingIndex) {
		return ByteBuffer.wrap(bytes,startingIndex,4).getInt();
	}
	
	public float floatFromByteArray(byte[] bytes, int startingIndex) {
	     return ByteBuffer.wrap(bytes,startingIndex,4).getFloat();
	}
	
	public long longFromToArray(byte[] bytes, int startingIndex) {
	     return ByteBuffer.wrap(bytes, startingIndex, 8).getLong();
	}
	
	public byte [] longToByteArray (long value){
	    return ByteBuffer.allocate(8).putLong(value).array();
	}
	
	public byte [] floatToByteArray (float value){  
	     return ByteBuffer.allocate(4).putFloat(value).array();
	}
	
	public byte [] intToByteArray (int value){  
	     return ByteBuffer.allocate(4).putInt(value).array();
	}
	
	public byte [] getTimeStampAsByteArray (){
	    return ByteBuffer.allocate(8).putLong(System.currentTimeMillis()).array();
	}
	
}

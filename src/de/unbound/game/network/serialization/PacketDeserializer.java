package de.unbound.game.network.serialization;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public class PacketDeserializer {
	
	private int index;
	private ByteBuilderHelper helper;
	
	public PacketDeserializer(){
		index = 8;
		helper = new ByteBuilderHelper();
	}
	
	public ArrayList<DeserializedEntity> getDeserializedEntityFromByteArray(byte[] data){
		index = 8; //0-7 sind timestamp
		ArrayList<DeserializedEntity> entities = new ArrayList<PacketDeserializer.DeserializedEntity>();
		DeserializedEntity tempEntity = null;
		do{
			tempEntity = getNextEntity(data);
			if(tempEntity.id != 0)
				entities.add(tempEntity);
		}while(tempEntity.id != 0);
		return entities;
	}
	
	private DeserializedEntity getNextEntity(byte[] data) {
		DeserializedEntity e = new DeserializedEntity();
		e.id = helper.intFromByteArray(data, index);
		index += 4;
		e.type = helper.byteFromByteArray(data, index);
		index += 1;
		e.posX = helper.floatFromByteArray(data, index);
		index += 4;
		e.posY = helper.floatFromByteArray(data, index);
		index += 4;
		e.dirX = helper.floatFromByteArray(data, index);
		index += 4;
		e.dirY = helper.floatFromByteArray(data, index);
		index += 4;
		e.velX = helper.floatFromByteArray(data, index);
		index += 4;
		e.velY = helper.floatFromByteArray(data, index);
		index += 4;
		return e;
	}
	
	public long getTimeStampFromByteArray(byte[] data)
	{
		return ByteBuffer.wrap(data, 0, 8).getLong();
	}

	public class DeserializedEntity{
		
		public int id;
		public byte type;
		public float posX, posY, dirX,dirY, velX, velY;
		
	}

}

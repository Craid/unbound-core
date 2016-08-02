package de.unbound.game.network.serialization;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public class PacketDeserializer {
	
	private int index;
	private ByteBuilderHelper helper;
	
	public PacketDeserializer(){
		index = 0;
		helper = new ByteBuilderHelper();
	}
	
	public ArrayList<DeserializedEntity> getDeserializedEntityFromByteArray(byte[] data, int offset){
		index = offset; 
		ArrayList<DeserializedEntity> entities = new ArrayList<PacketDeserializer.DeserializedEntity>();
		DeserializedEntity tempEntity = null;
		while(index + 29 <= data.length){
			tempEntity = getNextEntity(data);
			if(tempEntity.type != 0){
				entities.add(tempEntity);
				
			}else break;
		}
		System.out.println(entities.size()+ " = Anzahl Entitaeten aus UDP");
		System.out.println(getTimeStampFromByteArray(data));
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
		
		public int id = -1;
		public byte type;
		public float posX, posY, dirX,dirY, velX, velY;
		
	}

}

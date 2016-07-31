package de.unbound.game.network.serialization;

import java.util.ArrayList;

public class EntityDeserializer {
	
	private int index;
	private ByteBuilderHelper helper;
	
	public EntityDeserializer(){
		index = 8;
		helper = new ByteBuilderHelper();
	}
	
	public ArrayList<DeserializedEntity> getDeserializedEntityFromByteArray(byte[] data){
		index = 8; //0-7 sind timestamp
		ArrayList<DeserializedEntity> entities = new ArrayList<EntityDeserializer.DeserializedEntity>();
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
		
		return e;
	}

	public class DeserializedEntity{
		
		public int id;
		public byte type;
		public float posX, posY, dirX,dirY, velX, velY;
		
	}

}

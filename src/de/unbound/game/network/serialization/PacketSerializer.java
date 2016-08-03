package de.unbound.game.network.serialization;

import java.util.ArrayList;

import de.unbound.game.World;
import de.unbound.game.model.entities.Entity;

public class PacketSerializer {
	
	private ByteBuilderHelper helper;
	
	public PacketSerializer() {
		helper = new ByteBuilderHelper();
	}
	
	public byte[] constructUDPPackage(ArrayList<Entity> entities){
		byte[] data = new byte[8+entities.size()*32];
		int index = 0;
		for(byte b : helper.getTimeStampAsByteArray())
			data[index++] = b;
		for(Entity e : entities)
			for(byte b : constructEntityByteStream(e))
				data[index++] = b;
		return data;
	}
	
	public byte[] constructEntityByteStream(Entity entity){
		byte[] bytes = new byte[32];
		int i = 0;
		for(byte b : helper.intToByteArray(entity.getId()))
			bytes[i++] = b;
		
		for(byte b : helper.intToByteArray(entity.getModel().getId()))
			bytes[i++] = b;
		
		for(byte b : helper.floatToByteArray(entity.getPosition().x))
			bytes[i++] = b;
		for(byte b : helper.floatToByteArray(entity.getPosition().y))
			bytes[i++] = b;
		for(byte b : helper.floatToByteArray(entity.getDirection().x))
			bytes[i++] = b;
		for(byte b : helper.floatToByteArray(entity.getDirection().y))
			bytes[i++] = b;
		for(byte b : helper.floatToByteArray(entity.getUpdateState().getMove().getVelocity().x))
			bytes[i++] = b;
		for(byte b : helper.floatToByteArray(entity.getUpdateState().getMove().getVelocity().y))
			bytes[i++] = b;
		
		return bytes;
	}
	
	public byte[] getPlayerAsByteArray(){
		return constructEntityByteStream(World.getInstance().getBattleField().getPlayers().get(0));
	}
	
	public byte[] getTimeStampAsByteArray(){
		return helper.getTimeStampAsByteArray();
	}

}

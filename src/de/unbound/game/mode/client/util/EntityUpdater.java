package de.unbound.game.mode.client.util;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.World;
import de.unbound.game.factories.EntityFactory;
import de.unbound.game.factories.FlyweightFactory;
import de.unbound.game.mode.client.ClientSurvivalGameUpdate;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.EntityFlyweight;
import de.unbound.game.network.serialization.PacketDeserializer.DeserializedEntity;
import de.unbound.utility.UnboundConstants;

public class EntityUpdater {

	private ClientSurvivalGameUpdate gameUpdate;
	
	public EntityUpdater(ClientSurvivalGameUpdate gameUpdate) {
		this.gameUpdate = gameUpdate;
	}
	
	public void updateEntities(byte[] data) {
		for(DeserializedEntity e : gameUpdate.packetDeserializer.getDeserializedEntityFromByteArray(data,8)){
			Entity entity = gameUpdate.getBattleField().getEntitybyId(e.id);
			updateOrCreateEntity(e, entity);
		}
	}

	private void updateOrCreateEntity(DeserializedEntity e, Entity entity) {
		if(entity != null){
			updateEntity(e, entity);
		}else{
			createEntity(e);
		}
	}

	private void createEntity(DeserializedEntity e) {
		EntityFlyweight f  = FlyweightFactory.getInstance().getFlyweight(e.type);
		if(f != null){
			EntityFactory factory = World.getInstance().getMatchingFactory(f.getTextureName());
			String type = removeRace(f.getTextureName());
			Entity entity = factory.createEntity(type);
			entity.setId(e.id);
		}
	}

	private String removeRace(String raceAndType) {
		for(UnboundConstants.Race r : UnboundConstants.Race.values())
			raceAndType = raceAndType.replace(r.name(), "");
		return raceAndType;
	}

	private void updateEntity(DeserializedEntity e, Entity entity) {
		
		if(gameUpdate.getBattleField().getPlayers().get(0).getId() != entity.getId()){
			
			entity.setPosition(new Vector2(e.posX,e.posY));
			entity.setDirection(new Vector2(e.dirX, e.dirY));
			entity.getUpdateState().getMove().setVelocity(new Vector2(e.velX,e.velY));
		}
	}
	
	
	
}

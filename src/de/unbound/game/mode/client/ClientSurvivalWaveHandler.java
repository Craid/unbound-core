package de.unbound.game.mode.client;

import de.unbound.game.BattleField;
import de.unbound.game.factories.EntityFactory;
import de.unbound.game.mode.WaveHandler;
import de.unbound.game.mode.client.util.ClientSurvivalConfig;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.network.serialization.PacketDeserializer.DeserializedEntity;

public class ClientSurvivalWaveHandler extends WaveHandler {
	
	private DeserializedEntity player;
	private DeserializedEntity mainBase;
	
	public ClientSurvivalWaveHandler(EntityFactory ownFactory, EntityFactory enemyFactory, ClientSurvivalConfig config) {
		super(ownFactory, enemyFactory);
		cummulativeTime = -999999999;
		level = -1;
		player = config.desList.get(0);
		mainBase = config.desList.get(1);
	}
	
	public static ClientSurvivalWaveHandler createClientSurvivalWaveHandlerPreset(ClientSurvivalConfig config) {
		EntityFactory ownFactory = new ClientSurvivalEntityFactory("Prelate", false);
		EntityFactory enemyFactory = new ClientSurvivalEntityFactory("Duck", true);
		return new ClientSurvivalWaveHandler(ownFactory,enemyFactory, config);
	}
	
	@Override
	public void update(double deltaTime) {
		//do nothing!
	}
	
	@Override
	public void createMap(BattleField battleField) {
		Entity temp = getOwnFactory().createPlayer();
		temp.setId(player.id);
		
		temp =  getOwnFactory().createMainBase();
		temp.setId(mainBase.id);
	}
	
}
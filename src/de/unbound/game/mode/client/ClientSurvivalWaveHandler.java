package de.unbound.game.mode.client;

import de.unbound.game.BattleField;
import de.unbound.game.factories.EntityFactory;
import de.unbound.game.mode.WaveHandler;
import de.unbound.game.model.entities.Entity;
import de.unbound.game.network.ConnectionHandler;

public class ClientSurvivalWaveHandler extends WaveHandler {
	
	public ClientSurvivalWaveHandler(EntityFactory ownFactory, EntityFactory enemyFactory) {
		super(ownFactory, enemyFactory);
		cummulativeTime = 2; //First Wave in 3 Seconds, next in steps of WAVETIMEOUTS
		level = -1;
	}
	
	public static ClientSurvivalWaveHandler createLocalEndlessWaveHandlerPreset() {
		EntityFactory ownFactory = new ClientSurvivalEntityFactory("Prelate", false);
		EntityFactory enemyFactory = new ClientSurvivalEntityFactory("Duck", true);
		return new ClientSurvivalWaveHandler(ownFactory,enemyFactory);
	}
	
	@Override
	public void update(double deltaTime) {
		//do nothing!
	}
	
	@Override
	public void initializeMap(BattleField battleField) {
		Entity temp = getOwnFactory().createPlayer();
		temp.setId(ConnectionHandler.getInstance().player.id);
		
		temp =  getOwnFactory().createMainBase();
		temp.setId(ConnectionHandler.getInstance().mainBase.id);

		battleField.update(0); //initial update to write Entities to list
	}
	
}
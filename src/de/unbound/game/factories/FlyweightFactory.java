package de.unbound.game.factories;

import java.util.HashMap;

import de.unbound.game.model.FlyweightModel;

public class FlyweightFactory {

	public FlyweightFactory instance;
	private HashMap<String, FlyweightModel> flyweights;

	private FlyweightFactory() {
		// TODO - implement FlyweightFactory.FlyweightFactory
	}

	/**
	 * 
	 * @param name
	 */
	public FlyweightModel getFlyweight(String name) {
		// TODO - implement FlyweightFactory.getFlyweight
		throw new UnsupportedOperationException();
	}

}
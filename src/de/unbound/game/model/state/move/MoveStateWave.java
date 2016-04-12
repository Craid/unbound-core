package de.unbound.game.model.state.move;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.entities.mobile.MobileEntity;

public class MoveStateWave extends AbstractMoveState{

	Vector2 sinusRotation;
	float rotationCounter;
	boolean upwards;
	
	public MoveStateWave(MobileEntity e) {
		super(e);
		//ist noch vorerst drin, weil die Direction immer nach unten geht und zum Testen ungeeignet ist
		e.setDirection(new Vector2((float)(Math.random()-0.5D),(float) (Math.random()-0.5D)));
		sinusRotation = e.getDirection().cpy();
		rotationCounter = 0;
	}

	@Override
	public void update(double deltaTime) {

		//Wave-Sinus Berechnung
	    rotationCounter+=0.05f;
		sinusRotation.rotate((float)Math.sin(rotationCounter));
		
		//Nun nimmt die Direction die Sinus-Ausrichtung an
		e.setDirection(sinusRotation.cpy());
		
		//Bewegungsberechnung
		float acceleration = (float)(e.getModel().getAcceleration()*deltaTime);
		e.setVelocity(e.getVelocity().cpy().add(sinusRotation.cpy().scl((float)(e.getModel().getAcceleration()*deltaTime))));
		e.getVelocity().limit(e.getModel().getMaxVelocity()).scl((float)(deltaTime*60));
		e.setPosition(e.getPosition().cpy().add(e.getVelocity()));

	}
}

package de.unbound.game.model.state.move;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.entities.Entity;

public class MoveStateWave extends AbstractMoveState{

	Vector2 sinusRotation;
	float rotationCounter;
	boolean upwards;
	
	public MoveStateWave(Entity e) {
		super(e);
		//ist noch vorerst drin, weil die Direction immer nach unten geht und zum Testen ungeeignet ist
		e.setDirection(new Vector2((float)(Math.random()-0.5D),(float) (Math.random()-0.5D)));
		sinusRotation = e.getDirection().cpy();
		rotationCounter = 0;
	}

	@Override
	public void update(double deltaTime) {

		//Wave-Sinus Berechnung
	    rotationCounter+=deltaTime*2.8;
		sinusRotation.rotate((float)Math.sin(rotationCounter));
		
		//Nun nimmt die Direction die Sinus-Ausrichtung an
		e.setDirection(sinusRotation.cpy());
		
		//Bewegungsberechnung
		float acceleration = (float)(e.getModel().getAcceleration()*deltaTime);
		float timeFractionOfASecond = (float)(deltaTime*60);
		
		velocity = velocity.cpy().add(sinusRotation.cpy().scl(acceleration));
		velocity = velocity.limit(e.getModel().getMaxVelocity()).scl(timeFractionOfASecond);
		e.setPosition(e.getPosition().cpy().add(velocity));

	}
}

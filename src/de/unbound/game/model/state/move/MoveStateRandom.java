package de.unbound.game.model.state.move;

import com.badlogic.gdx.math.Vector2;

import de.unbound.game.model.entities.mobile.MobileEntity;

public class MoveStateRandom extends AbstractMoveState {
	
	public MoveStateRandom(MobileEntity e) {
		super(e);
	}

	@Override
	public void update(double deltaTime) {
		//TODO Marwin mach mal
		//e.setVelocity(new Vector2(0.11f,0));
		//e.setDirection(e.getDirection().rotate((float)(-36*deltaTime)));
		//		e.setVelocity(e.getVelocity().scl((float)(1+deltaTime)));
		//e.setPosition(e.getPosition().add(e.getVelocity()));
		//e.getVelocity().setZero();
				
		if (Math.random()>0.985) e.setDirection(new Vector2((float)(Math.random()-0.5D),(float) (Math.random()-0.5D)));
		
		
		e.setVelocity(e.getVelocity().cpy().add(e.getDirection().cpy().scl(0.17f)));

		e.getVelocity().limit(1.4f);
				
		e.setPosition(e.getPosition().cpy().add(e.getVelocity()));
		// 
		
		//System.out.println(e.getVelocity().x + " = X");
		//System.out.println(e.getVelocity().y + " = Y");
		
		//System.out.println(e.getVelocity().x);
//		System.out.println(e.getPosition());
	}
}
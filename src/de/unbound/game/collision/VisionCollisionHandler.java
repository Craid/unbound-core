package de.unbound.game.collision;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.entities.immobile.Deposit;
import de.unbound.game.model.entities.immobile.ImmobileEntity;
import de.unbound.game.model.entities.mobile.MobileEntity;
import de.unbound.game.model.entities.mobile.Player;
import de.unbound.game.model.state.attack.AttackStateTarget;
import de.unbound.game.model.state.move.MoveStateTarget;

public class VisionCollisionHandler extends CollisionHandler<MobileEntity, Entity> {

	@Override
	public void handle(MobileEntity subject, Entity object) {
		if (object instanceof Player)
			handle(subject, (Player)object);
		else if (object instanceof Deposit)
			handle(subject, (Deposit) object);
		else if (object instanceof ImmobileEntity)
			handle(subject, (ImmobileEntity) object);
		else if (object instanceof MobileEntity)
			handle(subject, (MobileEntity) object);
		else {
			debugPrint(subject, object);
			System.out.print("Unbekannte Collision!");
		}
	}
	
	private void setTargetAttackState(Entity subject, Entity object){
		if(!(subject.getAttack() instanceof AttackStateTarget)){
			subject.setAttack(new AttackStateTarget(subject, object));
		}
	}
	
	private void handle(MobileEntity subject, Player object){
		subject.setMove(new MoveStateTarget(subject	, object));
		setTargetAttackState(subject, object);
	}
	
	private void handle(MobileEntity subject, Deposit object){
		subject.setMove(new MoveStateTarget(subject	, object));
		setTargetAttackState(subject, object);
	}
	
	private void handle(MobileEntity subject, ImmobileEntity object){
		subject.setMove(new MoveStateTarget(subject	, object));
		setTargetAttackState(subject, object);
		setTargetAttackState(object, subject);
	}
	
	private void handle(MobileEntity subject, MobileEntity object){
		//intentionally left blank for now
	}
	
	

}

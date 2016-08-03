package de.unbound.game.collisionhandler;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.attack.AbstractAttackState;
import de.unbound.game.model.state.attack.AttackStateTarget;
import de.unbound.game.model.state.move.MoveStateTarget;

public class VisionCollisionHandler extends CollisionHandler {

	@Override
	public void handle(Entity subject, Entity object) {
		if (object.getTextureName().contains("Player"))
			handleMobilePlayer(subject, object);
		else if (object.getTextureName().contains("Deposit"))
			handleMobileDeposit(subject, object);
		else if (object.isImmobile())
			handleMobileImmobile(subject, object);
		else if (!object.isImmobile())
			handleMobileMobile(subject, object);
		else {
			debugPrint(subject, object);
			System.out.print("Unbekannte Collision!");
		}
	}
	
	private void handleMobilePlayer(Entity subject, Entity object){
		subject.getUpdateState().setMove(new MoveStateTarget(subject , object));
		setTargetAttackState(subject, object);
	}
	
	private void handleMobileDeposit(Entity subject, Entity object){
		subject.getUpdateState().setMove(new MoveStateTarget(subject, object));
		setTargetAttackState(subject, object);
	}
	
	private void handleMobileImmobile(Entity subject, Entity object){
		subject.getUpdateState().setMove(new MoveStateTarget(subject, object));
		setTargetAttackState(subject, object);
		setTargetAttackState(object, subject);
	}
	
	private void handleMobileMobile(Entity subject, Entity object){
		//intentionally left blank for now
	}
	
	private void setTargetAttackState(Entity subject, Entity object){
		AbstractAttackState attack = subject.getUpdateState().getAttack();
		if(!(attack instanceof AttackStateTarget)){
			subject.getUpdateState().setAttack(new AttackStateTarget(subject, object));
		}else if(!((AttackStateTarget)attack).isTargetActive()){
			((AttackStateTarget)attack).setTarget(object);
		}
		
		
		
	}

}

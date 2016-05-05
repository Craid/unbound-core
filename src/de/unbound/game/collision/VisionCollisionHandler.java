package de.unbound.game.collision;

import de.unbound.game.model.entities.Entity;
import de.unbound.game.model.state.attack.AttackStateTarget;
import de.unbound.game.model.state.move.MoveStateTarget;

public class VisionCollisionHandler extends CollisionHandler {

	@Override
	public void handle(Entity subject, Entity object) {
		if (object.getModel().getTextureName().contains("Player"))
			handleMobilePlayer(subject, object);
		else if (object.getModel().getTextureName().contains("Deposit"))
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
		if(!(subject.getUpdateState().getAttack() instanceof AttackStateTarget)){
			subject.getUpdateState().setAttack(new AttackStateTarget(subject, object));
		}
	}
	
	

}

package de.unbound.game.model.state.attack;

import de.unbound.game.model.entities.Entity;
import de.unbound.utility.UnboundConstants;

public class AttackStateTarget extends AbstractAttackState {

	private Entity target;

	public AttackStateTarget(Entity entity, Entity target) {
		super(entity);
		this.target = target;
	}

	@Override
	public void update(double deltaTime) {
		if (target != null && target.isActive()) {
			e.setDirection(target.getPosition().cpy().add(e.getPosition().cpy().scl(-1)));
			lastTimeSinceEntityShot += deltaTime;
			if (lastTimeSinceEntityShot > UnboundConstants.SHOTSPEED) {
				Entity p = createBullet();
				p.setHostile(e.isHostile());
				p.setDirection(target.getPosition().cpy().add(e.getPosition().cpy().scl(-1)));
				p.getUpdateState().getMove().setVelocity(p.getDirection().cpy().limit(p.getModel().getMeta().getMaxVelocity()));
				lastTimeSinceEntityShot = 0;
			}
		}else {
			e.getUpdateState().setAttack(new AttackStateStraight(e));
		}
	}
}
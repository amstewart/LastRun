package model.skill;

import model.effect.InternalEffect;

public class InternalSkill extends Skill{
	InternalEffect effect;
	public InternalSkill(String name, int level,InternalEffect effect) {
		super(name, level);
		this.effect = effect;
	}
	@Override
	public void applyMultiplier() {
		effect.applyMultiplier(getLevel());
		
	}

}

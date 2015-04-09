package model.skill;

import model.effect.ExternalEffect;

public class ExternalSkill extends Skill{
	ExternalEffect effect;
	int radius;
	public ExternalSkill(String name, int level,ExternalEffect effect, int radius) {
		super(name, level);
		this.effect = effect;
		this.radius = radius;
	}
	@Override
	public void applyMultiplier() {
		// TODO make radius bigger
		effect.applyMultiplier(getLevel());
	}


}

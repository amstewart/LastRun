package model.skill;

import model.effect.ExternalEffect;

public class ExternalSkill extends Skill{
	ExternalEffect effect;
	int baseRadius;
	int radius;
	public ExternalSkill(String name, int level,ExternalEffect effect, int radius) {
		super(name, level);
		this.effect = effect;
		this.baseRadius = radius;
	}
	@Override
	public void applyMultiplier() {
		this.radius = baseRadius * getLevel();
		effect.applyMultiplier(getLevel());
	}
	
}

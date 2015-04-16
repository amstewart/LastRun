package model.skill;

import model.effect.ExternalEffect;
import model.effect.SpellEffect;

public class SpellSkill extends Skill{
	SpellEffect effect;
	int baseRadius;
	int radius;

	//=====TEMPORARY CONSTRUCTOR FOR TESTING=====
	public SpellSkill(String name, int value) {
		super(name, value);
	}
	public SpellSkill(String name, int level,SpellEffect effect, int radius) {
		super(name, level);
		this.effect = effect;
		this.baseRadius = radius;
	}
	@Override
	public void applyMultiplier() {
		this.radius = baseRadius * getLevel();
		effect.applyMultiplier(getLevel());
	}
	public void setCanPeform(int mana) {
		effect.setCanPerform(mana);
	}

}

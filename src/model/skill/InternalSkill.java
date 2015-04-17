package model.skill;

import controller.KeyController;
import model.effect.InternalEffect;
import model.entity.Entity;
import model.map.LocalArea;

public class InternalSkill extends Skill{
	InternalEffect effect;


	public InternalSkill(String name, int level,InternalEffect effect, boolean passive) {
		super(name, level, passive);
		this.effect = effect;
	}
	@Override
	public void applyMultiplier() {
		effect.applyMultiplier(getLevel());
	}
	
	public void perfromSkill(Entity entity){
		effect.applyEffect(entity);
	}
	
}

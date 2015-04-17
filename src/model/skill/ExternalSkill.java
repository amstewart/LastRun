package model.skill;

import controller.KeyController;
import model.effect.ExternalEffect;
import model.entity.Entity;
import model.map.GameMap;
import model.map.LocalArea;

public class ExternalSkill extends Skill{
	private ExternalEffect effect;
	private int baseRadius;
	private int radius;

	//====== TEMPORARY CONSTRUCTOR ======
	public ExternalSkill(String name, int level,ExternalEffect effect, int radius, boolean passive) {
		super(name, level, passive);
		this.effect = effect;
		this.baseRadius = radius;
	}
	@Override
	public void applyMultiplier() {
		this.radius = baseRadius * getLevel();
		effect.applyMultiplier(getLevel());
	}
	
	public void perfromSkill(LocalArea map, Entity entity){
		effect.applyEffect(map, entity);
	}
	
	public int getRadius(){
		return radius;
	}

	
	
	
}

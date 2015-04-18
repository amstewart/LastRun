package model.skill;

import java.util.Random;

import controller.KeyController;
import model.effect.ExternalEffect;
import model.effect.SpellEffect;
import model.entity.Entity;
import model.map.GameMap;

public class SpellSkill extends Skill{
	SpellEffect effect1;
	SpellEffect effect2;
	SpellEffect effect3;
	int baseRadius;
	int radius;

	public SpellSkill(String name, int level,SpellEffect effect1,SpellEffect effect2,SpellEffect effect3, int radius) {
		super(name, level, false);
		this.effect1 = effect1;
		this.effect2 = effect2;
		this.effect3 = effect3; 
		this.baseRadius = radius;
	}

	@Override
	public void applyMultiplier() {
		this.radius = baseRadius * getLevel();
		int m;
		effect1.applyMultiplier(getLevel());
		effect2.applyMultiplier(getLevel());
		effect3.applyMultiplier(getLevel());
	}
	public void setCanPeform(int mana) {
		effect1.setCanPerform(mana);
		effect2.setCanPerform(mana);
		effect3.setCanPerform(mana);
	}
	
	public void performSkill(GameMap map, Entity entity){
		Random random = new Random();
		int m = random.nextInt(3 - 1 + 1) + 1;
		if(m == 1){
			effect1.applyEffect(map, entity, radius);
		}else if (m == 2){
			effect2.applyEffect(map, entity, radius);
		}else{
			effect3.applyEffect(map, entity, radius);
		}
		
	}

	public int getRadius() {
		return radius;
	}

}

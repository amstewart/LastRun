package model.skill;

import java.util.HashMap;

import controller.keyControllers.GameController;
import model.effect.InternalEffect;
import model.entity.Entity;
import model.item.EquippableItem;
import model.map.LocalArea;
import model.observer.EquipmentHandlerObserver;

public class InternalSkill extends Skill implements EquipmentHandlerObserver{
	InternalEffect effect;


	public InternalSkill(String name, int level,InternalEffect effect, boolean passive) {
		super(name, level, passive);
		this.effect = effect;
		effect.applyMultiplier(getLevel());
	}
	@Override
	public void applyMultiplier() {
		effect.applyMultiplier(getLevel());
	}
	
	public void performSkill(Entity entity){
		applyMultiplier();
		effect.applyEffect(entity);
	}
	@Override
	public void receiveEquipment(HashMap<String, EquippableItem> equipment) {
		effect.applyEffect(equipment);
	}
	
	
	
	
	
	
}

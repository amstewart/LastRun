package model.effect;

import java.util.HashMap;

import model.entity.Entity;
import model.item.EquippableItem;


public class WeaponBasedStatModifier implements InternalEffect{
	private int baseAgilityIncrease = 5;
	private int agilityIncrease;
	private String equipmentType;
	private boolean canPerform = false;
	private boolean performedBefore = false;
	
	
	public WeaponBasedStatModifier(String equipmentType, int level) {
		super();
		this.equipmentType = equipmentType;
	}

	@Override
	public void applyMultiplier(int m) {
		this.agilityIncrease = baseAgilityIncrease * m;
	}

	@Override
	public void applyEffect(Entity entity) {
		if(canPerform && !performedBefore){
			entity.setAgility(agilityIncrease);
			performedBefore = true;
		}else if(performedBefore && !canPerform){
			entity.setAgility(-agilityIncrease);
			performedBefore = false;	
		}
	}
	
	
	
	public void setCanPerform(String equipmentType){
		
	}

	@Override
	public void applyEffect(HashMap<String, EquippableItem> equipment) {
		if(equipment.get(equipmentType) == null){
			canPerform = false;
		}else{
			canPerform = true;
		}	
	}

}
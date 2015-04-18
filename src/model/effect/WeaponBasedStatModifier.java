package model.effect;

import model.entity.Entity;


public class WeaponBasedStatModifier implements InternalEffect{
	private int baseAgilityIncrease = 5;
	private int agilityIncrease;
	private String equipmentType;
	private boolean canPerfrom = false;
	
	
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
		//if(entity.holds(equipmentType)){//TDA
			//entity.setAgility(agilityIncrease);
		//}
		
	}
	
	public void setCanPerform(String equipmentType){
		
	}

}
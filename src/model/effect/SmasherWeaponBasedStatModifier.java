package model.effect;

import model.entity.Entity;
import model.item.SmasherEquipmentManager;
import model.item.equipment.Equipment;
import model.item.equipment.SmasherEquipment;

public class SmasherWeaponBasedStatModifier implements InternalEffect{
	private int baseAgilityIncrease = 5;
	private int agilityIncrease;
	SmasherEquipment equipmentType;
	SmasherEquipmentManager manager;
	
	
	public SmasherWeaponBasedStatModifier(SmasherEquipment equipmentType,
			SmasherEquipmentManager manager) {
		super();
		this.equipmentType = equipmentType;
		this.manager = manager;
	}

	@Override
	public void applyMultiplier(int m) {
		this.agilityIncrease = baseAgilityIncrease * m;
		
	}

	@Override
	public void applyEffect(Entity entity) {
		//TODO
		//if(manager.checkIfEquipped(equipmentType)){
			
		//}
		
	}

}

package model.effect;

import model.entity.Entity;
import model.item.SneakEquipmentManager;
import model.item.equipment.Equipment;
import model.item.equipment.SneakEquipment;

public class SneakWeaponBasedStatModifier implements InternalEffect{
	private int baseAgilityIncrease = 5;
	private int agilityIncrease;
	SneakEquipment equipmentType;
	SneakEquipmentManager manager;
	
	
	public SneakWeaponBasedStatModifier(SneakEquipment equipmentType,
			SneakEquipmentManager manager) {
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

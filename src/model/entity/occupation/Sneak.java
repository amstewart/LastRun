package model.entity.occupation;

import model.item.Inventory;
import model.item.SneakEquipmentManager;
import model.item.equipment.*;
import model.skillset.SneakSkills;

public class Sneak extends Occupation {

    private SneakEquipmentManager equipmentManager;
    private SneakSkills skills;
    

    public Sneak(Inventory inventory) {
        super(inventory);
        equipmentManager = new SneakEquipmentManager(inventory);
        skills = new SneakSkills();
    }

    @Override
    public boolean addToEquipment(BasicEquipment equipment) {
        return equipment.doEquip(equipmentManager);
    }

    @Override
    public boolean addToEquipment(SmasherEquipment equipment) {
        return false;
    }

    @Override
    public boolean addToEquipment(SneakEquipment equipment) {
        return equipment.doEquip(equipmentManager);
    }

    @Override
    public boolean addToEquipment(SummonerEquipment equipment) {
        return false;
    }

    //================================Unequipping===================================
    @Override
    public boolean removeFromEquipment(BasicEquipment equipment) { return equipment.doUnequip(equipmentManager); }

    @Override
    public boolean removeFromEquipment(SmasherEquipment equipment) { return false; }

    @Override
    public boolean removeFromEquipment(SneakEquipment equipment) { return equipment.doUnEquip(equipmentManager); }

    @Override
    public boolean removeFromEquipment(SummonerEquipment equipment) { return false; }

    @Override
    public Equipment[] getEquipment() {
        return equipmentManager.getEquippedItems();
    }

    public SneakEquipmentManager getEquipmentManager() {
        return equipmentManager;
    }

	@Override
	public void notifySkills(int mana) {
		// TODO Auto-generated method stub
	}

}

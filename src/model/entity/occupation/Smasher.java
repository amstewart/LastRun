package model.entity.occupation;

import model.item.Inventory;
import model.item.SmasherEquipmentManager;
import model.item.equipment.*;

public class Smasher extends Occupation {

    private SmasherEquipmentManager equipmentManager;

    public Smasher(Inventory inventory) {
        super(inventory);
        equipmentManager = new SmasherEquipmentManager(inventory);
    }

    @Override
    public boolean addToEquipment(BasicEquipment equipment) {
        return equipment.doEquip(equipmentManager);
    }

    @Override
    public boolean addToEquipment(SmasherEquipment equipment) {
        return equipment.doEquip(equipmentManager);
    }

    @Override
    public boolean addToEquipment(SneakEquipment equipment) {
        return false;
    }

    @Override
    public boolean addToEquipment(SummonerEquipment equipment) {
        return false;
    }

    //================================Unequipping===================================
    @Override
    public boolean removeFromEquipment(BasicEquipment equipment) { return equipment.doUnequip(equipmentManager); }

    @Override
    public boolean removeFromEquipment(SmasherEquipment equipment) { return equipment.doUnEquip(equipmentManager); }

    @Override
    public boolean removeFromEquipment(SneakEquipment equipment) { return false; }

    @Override
    public boolean removeFromEquipment(SummonerEquipment equipment) { return false; }

    @Override
    public Equipment[] getEquipment() {
        return equipmentManager.getEquippedItems();
    }
}

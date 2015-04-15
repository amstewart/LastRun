package model.entity.occupation;

import model.item.Inventory;
import model.item.SummonerEquipmentManager;
import model.item.equipment.*;

public class Summoner extends Occupation {

    private SummonerEquipmentManager equipmentManager;

    public Summoner(Inventory inventory) {
        super(inventory);
        equipmentManager = new SummonerEquipmentManager(inventory);
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
        return false;
    }

    @Override
    public boolean addToEquipment(SummonerEquipment equipment) {
        return equipment.doEquip(equipmentManager);
    }
    //================================Unequipping===================================
    @Override
    public boolean removeFromEquipment(BasicEquipment equipment) { return equipment.doUnequip(equipmentManager); }

    @Override
    public boolean removeFromEquipment(SmasherEquipment equipment) { return false; }

    @Override
    public boolean removeFromEquipment(SneakEquipment equipment) { return false; }

    @Override
    public boolean removeFromEquipment(SummonerEquipment equipment) { return equipment.doUnEquip(equipmentManager); }

    @Override
    public Equipment[] getEquipment() {
        return equipmentManager.getEquippedItems();
    }

    public SummonerEquipmentManager getEquipmentManager() {
        return equipmentManager;
    }
}

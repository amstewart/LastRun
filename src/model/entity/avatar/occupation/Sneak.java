package model.entity.avatar.occupation;

import model.item.Inventory;
import model.item.SneakEquipmentManager;
import model.item.equipment.*;

public class Sneak extends Occupation {

    private SneakEquipmentManager equipmentManager;

    public Sneak(Inventory inventory) {
        super(inventory);
        equipmentManager = new SneakEquipmentManager(inventory);
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

    @Override
    public Equipment[] getEquipment() {
        return equipmentManager.getEquippedItems();
    }
}

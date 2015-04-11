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

    @Override
    public Equipment[] getEquipment() {
        return equipmentManager.getEquippedItems();
    }
}

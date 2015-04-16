package model.entity.occupation;

import model.item.EquipmentManager;
import model.item.Inventory;
import model.item.equipment.*;

public class NPCOccupation extends Occupation {

    public NPCOccupation(Inventory inventory) {
        super(inventory);
    }
    // ====TEMP TEST=====
    @Override
    public String getName() {
        return "NPC";
    }

    @Override
    public boolean addToEquipment(BasicEquipment equipment) {
        return false;
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
        return false;
    }

    @Override
    public boolean removeFromEquipment(BasicEquipment equipment) { return false; }

    @Override
    public boolean removeFromEquipment(SmasherEquipment equipment) { return false; }

    @Override
    public boolean removeFromEquipment(SneakEquipment equipment) { return false; }

    @Override
    public boolean removeFromEquipment(SummonerEquipment equipment) { return false; }

    @Override
    public Equipment[] getEquipment() {
        return new Equipment[0];
    }

    @Override
    public EquipmentManager getEquipmentManager() {
        return null;
    }
}

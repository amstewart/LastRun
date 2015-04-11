package model.entity.occupation;

import model.item.Inventory;
import model.item.equipment.*;

/**
 * Created by diacopium on 15/04/11.
 */
public class NPCOccupation extends Occupation {

    public NPCOccupation(Inventory inventory) {
        super(inventory);
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
    public Equipment[] getEquipment() {
        return new Equipment[0];
    }
}

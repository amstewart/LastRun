package testing;

import model.entity.occupation.Occupation;
import model.entity.occupation.Smasher;
import model.item.EquipmentHandler;
import model.item.Inventory;

import java.util.ArrayList;

public class OccupationTest extends Test {

    @Override
    public void run() throws NoSuchMethodException {
        Inventory inventory = new Inventory();
        Occupation smasher = new Smasher(inventory);

        EquipmentHandler equipmentHandler = smasher.getEquipmentHandler();
        equipmentHandler.getSlots();

    }
}

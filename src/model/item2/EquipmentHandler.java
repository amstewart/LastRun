package model.item2;

import java.util.ArrayList;
import java.util.HashMap;
// Each specific occupation will initialize this class with slots it can use
public class EquipmentHandler {

    private HashMap<String, EquippableItem> equipment;
    private Inventory inventory;

    public EquipmentHandler(Inventory inventory) {
        equipment = new HashMap<String, EquippableItem>();
        this.inventory = inventory;
    }

    public void equip(EquippableItem equippableItem, ArrayList<String> slots) {
        // check the slots passed in and if they are available
        

    }

    public void unequip(EquippableItem equippableItem, ArrayList<String> slots) {

    }

}

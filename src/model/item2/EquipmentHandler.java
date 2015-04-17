package model.item2;

import java.util.ArrayList;
import java.util.HashMap;
// Each specific occupation will initialize this class with slots it can use
public class EquipmentHandler {

    // TODO: Need equipmentHandler observers
    private HashMap<String, EquippableItem> equipment;
    private Inventory inventory;

    public EquipmentHandler(Inventory inventory, HashMap<String, EquippableItem> slots) {
        equipment = slots;
        this.inventory = inventory;
    }

    // Rings of abstraction
    public void equip(EquippableItem equippableItem, String slot) {
        // check the slots passed in and if they are available
        if(slotExists(slot)) {
            putInEquipment(slot, equippableItem);
            removeFromInventory(equippableItem);
        }

    }

    // Rings of abstraction
    public void unequip(EquippableItem equippableItem, String slot) {
        if(slotExists(slot)) {
            removeFromEquipment(slot);
            addBackToInventory(equippableItem);
        }
    }

    private boolean slotExists(String slot) {
        return equipment.containsKey(slot);
    }

    private void putInEquipment(String slot, EquippableItem equippableItem) {
        equipment.replace(slot, equippableItem);
    }

    private void removeFromEquipment(String slot) {
        equipment.replace(slot, null);
    }

    private void removeFromInventory(EquippableItem equippableItem) {
        inventory.remove(equippableItem);
    }

    private void addBackToInventory(EquippableItem equippableItem) {
        inventory.add(equippableItem);
    }
}

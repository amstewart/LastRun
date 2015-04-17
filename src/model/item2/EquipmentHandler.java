package model.item2;

import model.observer.EquipmentHandlerObserver;

import java.util.ArrayList;
import java.util.HashMap;
// Each specific occupation will initialize this class with slots it can use
public class EquipmentHandler {

    private ArrayList<EquipmentHandlerObserver> observers;
    private HashMap<String, EquippableItem> equipment;
    private Inventory inventory;

    public EquipmentHandler(Inventory inventory, HashMap<String, EquippableItem> slots) {
        observers = new ArrayList<EquipmentHandlerObserver>();
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

    public void registerObserver(EquipmentHandlerObserver observer) {
        observers.add(observer);
        notifyObserversEquipmentchanged();
    }

    private void notifyObserversEquipmentchanged() {
        for(EquipmentHandlerObserver observer: observers) {
            observer.receiveEquipment(getEquipment());
        }
    }

    private EquippableItem[] getEquipment() {
        return ((EquippableItem[])equipment.values().toArray());
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

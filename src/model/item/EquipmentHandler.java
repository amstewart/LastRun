package model.item;

import model.observer.EquipmentHandlerObserver;

import java.util.ArrayList;
import java.util.HashMap;
// Each specific occupation will initialize this class with slots it can use
public class EquipmentHandler {
    
    private ArrayList<EquipmentHandlerObserver> observers;
    private HashMap<String, EquippableItem> equipment;
    private Inventory inventory;

    public EquipmentHandler(Inventory inventory, ArrayList<String> slots) {

        observers = new ArrayList<EquipmentHandlerObserver>();
        equipment = new HashMap<String, EquippableItem>();

        updateSlots(slots);
        this.inventory = inventory;
    }

    public void updateSlots(ArrayList<String> slots) {
        for(String s: slots) {
            equipment.put(s, null);
        }
        notifyObserversEquipmentChanged();
    }

    //TEST
    public void getSlots() {
        for(String s: equipment.keySet()) {
            System.out.println(s);
        }
    }
    // Rings of abstraction
    public void equip(EquippableItem equippableItem, String slot) {
        // if slot exist
        if(slotExists(slot)) {
            returnEquippedItemToInventory(slot);
            putInEquipment(slot, equippableItem);
            removeFromInventory(equippableItem);
        }
        notifyObserversEquipmentChanged();
    }

    // Rings of abstraction
    public void unequip(EquippableItem equippableItem, String slot) {
        if(slotExists(slot)) {
            removeFromEquipment(slot);
            addBackToInventory(equippableItem);
        }
        notifyObserversEquipmentChanged();
    }

    public void addObserver(EquipmentHandlerObserver observer) {
        observers.add(observer);
        notifyObserversEquipmentChanged();
    }

    private void notifyObserversEquipmentChanged() {
        for(EquipmentHandlerObserver observer: observers) {
            observer.receiveEquipment(equipment);
        }
    }

    private boolean slotExists(String slot) {
        return equipment.containsKey(slot);
    }

    private void returnEquippedItemToInventory(String slot) {
        EquippableItem equippedItem = equipment.get(slot);
        if(equippedItem != null) {
            addBackToInventory(equippedItem);
        }
    }

    private void putInEquipment(String slot, EquippableItem equippableItem) {
        equipment.put(slot, equippableItem);
    }

    private void removeFromEquipment(String slot) {
        equipment.put(slot, null);
    }

    private void removeFromInventory(EquippableItem equippableItem) {
        inventory.remove(equippableItem);
    }

    private void addBackToInventory(EquippableItem equippableItem) {
        inventory.add(equippableItem);
    }

    public ArrayList<EquipmentHandlerObserver> getObservers() {
        return observers;
    }
}

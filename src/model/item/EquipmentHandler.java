package model.item;

import model.entity.occupation.Occupation;
import model.observer.EquipmentHandlerObserver;
import model.stat.Stats;

import java.util.ArrayList;
import java.util.HashMap;
// Each specific occupation will initialize this class with slots it can use
public class EquipmentHandler {
    
    private ArrayList<EquipmentHandlerObserver> observers;
    private HashMap<String, EquippableItem> equipment;
    private Inventory inventory;
    private Stats playerStats;
    Occupation occupation;

    public EquipmentHandler(Inventory inventory, ArrayList<String> slots, Stats playerStats, Occupation o) {

        observers = new ArrayList<EquipmentHandlerObserver>();
        equipment = new HashMap<String, EquippableItem>();
        this.occupation = o;

        updateSlots(slots);
        this.inventory = inventory;
        this.playerStats = playerStats;
    }

    public void updateSlots(ArrayList<String> slots) {
        for(String s: slots) {
            equipment.put(s, null);
        }
        notifyObserversEquipmentChanged();
    }

    // Rings of abstraction
    public void equip(EquippableItem equippableItem, String slot) {
        if(slotExists(slot)) {
            unequipCurrentItem(slot);
            equipNewItem(slot, equippableItem);
        }
        notifyObserversEquipmentChanged();
    }

    // Rings of abstraction
    // Pre condition, item that calls it would be equipped already
    public void unequip(EquippableItem equippableItem, String slot) {
        if(slotExists(slot)) {
            unequipCurrentItem(slot);
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

    // Helper functions to simplify abstraction and encapsulate the process
    private void unequipCurrentItem(String slot) {
        EquippableItem currentEquippedItem = equipment.get(slot);
        if(currentEquippedItem != null) {
            inventory.add(currentEquippedItem);
            playerStats.unMergeStats(currentEquippedItem.getItemStats());
            equipment.put(slot, null);
        }
    }

    private void equipNewItem(String slot, EquippableItem equippableItem) {
        inventory.remove(equippableItem);
        equipment.put(slot, equippableItem);
        playerStats.mergeStats(equippableItem.getItemStats());
    }

	public boolean holds(String s) {
		if(equipment.get(s) == null){
			return false;
		}else{
			return true;
		}
	}
}

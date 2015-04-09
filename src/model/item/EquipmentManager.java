package model.item;

import model.item.equipment.Chest;
import model.item.equipment.Equipment;
import model.item.equipment.Head;
import model.item.equipment.Legs;

public abstract class EquipmentManager {

    private Head headSlot;
    private Chest chestSlot;
    private Legs legsSlot;

    private Inventory inventory;

    public EquipmentManager(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean equipHead(Head head) {
        getInventory().addItem(headSlot);
        getInventory().removeItem(head);
        headSlot = head;
        return true;
    }

    public boolean equipChest(Chest chest) {
        getInventory().addItem(chestSlot);
        getInventory().removeItem(chest);
        chestSlot = chest;
        return true;
    }

    public boolean equipLegs(Legs legs) {
        getInventory().addItem(legsSlot);
        getInventory().removeItem(legs);
        legsSlot = legs;
        return true;
    }

    public boolean unequipHead() {
        if(headSlot != null) {
            getInventory().addItem(headSlot);
            headSlot = null;
            return true;
        }
        return false;
    }

    public boolean unequipChest() {
        if(chestSlot != null) {
            getInventory().addItem(chestSlot);
            chestSlot = null;
            return true;
        }

        return false;
    }

    public boolean unequipLegs() {
        if(legsSlot != null) {
            getInventory().addItem(legsSlot);
            legsSlot = null;
            return true;
        }
        return false;
    }

    protected Head getHead() {
        return headSlot;
    }

    protected Chest getChest() {
        return chestSlot;
    }

    protected Legs getLegs() {
        return legsSlot;
    }

    protected Inventory getInventory() {
        return inventory;
    }

    public abstract Equipment[] getEquippedItems();
}

package model.item;

import model.item.equipment.Chest;
import model.item.equipment.Equipment;
import model.item.equipment.Head;
import model.item.equipment.Legs;
import view.viewport.EquipmentViewport;

import java.util.ArrayList;

public abstract class EquipmentManager {

    private ArrayList<EquipmentViewport> registeredViews;

    private Head headSlot;
    private Chest chestSlot;
    private Legs legsSlot;

    private Inventory inventory;


    public EquipmentManager(Inventory inventory) {
        this.inventory = inventory;
        registeredViews = new ArrayList<EquipmentViewport>();
    }

    public boolean equipHead(Head head) {
        getInventory().addItem(headSlot);
        getInventory().removeItem(head);
        headSlot = head;
        notifyViews();
        return true;
    }

    public boolean equipChest(Chest chest) {
        getInventory().addItem(chestSlot);
        getInventory().removeItem(chest);
        chestSlot = chest;
        notifyViews();
        return true;
    }

    public boolean equipLegs(Legs legs) {
        getInventory().addItem(legsSlot);
        getInventory().removeItem(legs);
        legsSlot = legs;
        notifyViews();
        return true;
    }

    public boolean unequipHead() {
        if(headSlot != null) {
            getInventory().addItem(headSlot);
            headSlot = null;
            notifyViews();
            return true;
        }
        return false;
    }

    public boolean unequipChest() {
        if(chestSlot != null) {
            getInventory().addItem(chestSlot);
            chestSlot = null;
            notifyViews();
            return true;
        }

        return false;
    }

    public boolean unequipLegs() {
        if(legsSlot != null) {
            getInventory().addItem(legsSlot);
            legsSlot = null;
            notifyViews();
            return true;
        }
        return false;
    }

    public void registerView(EquipmentViewport view) {
        registeredViews.add(view);
    }

    protected void notifyViews() {
        for(EquipmentViewport view: registeredViews) {
            view.receiveEquipment(getEquippedItems());
        }
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

package model.item2;

import model.observer.InventoryObserver;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Inventory {

    private ArrayList<Observer> observers;
    private ArrayList<NonEquippableItem> nonEquippableItems;
    private ArrayList<EquippableItem> equippableItems;

    public Inventory() {
        nonEquippableItems = new ArrayList<>();
        equippableItems = new ArrayList<>();
    }

    public void add(EquippableItem equippableItem) {
        equippableItems.add(equippableItem);
    }

    public void add(NonEquippableItem nonEquippableItem) {
        nonEquippableItems.add(nonEquippableItem);
    }

    public void remove(EquippableItem equippableItem) {
        if(equippableItems.contains(equippableItem)) {
            equippableItems.remove(equippableItem);
        }
    }

    public void remove(NonEquippableItem nonEquippableItem) {
        if(nonEquippableItems.contains(nonEquippableItem)) {
            nonEquippableItems.remove(nonEquippableItem);
        }
    }

    public void registerObserver(InventoryObserver o){

    }
}



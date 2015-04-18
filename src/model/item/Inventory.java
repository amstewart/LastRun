package model.item;

import model.observer.InventoryObserver;

import java.util.*;

public class Inventory {

    private ArrayList<InventoryObserver> observers;
    private ArrayList<NonEquippableItem> nonEquippableItems;
    private ArrayList<EquippableItem> equippableItems;

    public Inventory() {
        observers = new ArrayList<InventoryObserver>();
        nonEquippableItems = new ArrayList<>();
        equippableItems = new ArrayList<>();

        
        this.add(ItemFactory.getRandomSmasherWeapon());
        this.add(ItemFactory.getRandomSneakWeapon());
        this.add(ItemFactory.newShield());
        this.add(ItemFactory.getRandomHeadEquipment());
        this.add(ItemFactory.newShirt());
        this.add(ItemFactory.getRandomSummonerWeapon());
        this.add(ItemFactory.getRandomNonEquippableItem());
        this.add(ItemFactory.getRandomNonEquippableItem());
    }

    public void add(EquippableItem equippableItem) {
        equippableItems.add(equippableItem);
        notifyObserversEquippableItemsHaveChanged();
    }

    public void add(NonEquippableItem nonEquippableItem) {
        nonEquippableItems.add(nonEquippableItem);
        notifyObserversNonEquippableItemsHaveChanged();
    }

    public void remove(EquippableItem equippableItem) {
        if(equippableItems.contains(equippableItem)) {
            equippableItems.remove(equippableItem);
            notifyObserversEquippableItemsHaveChanged();
        }
    }

    public void remove(NonEquippableItem nonEquippableItem) {
        if(nonEquippableItems.contains(nonEquippableItem)) {
            nonEquippableItems.remove(nonEquippableItem);
            notifyObserversNonEquippableItemsHaveChanged();
        }
    }

    public void addObserver(InventoryObserver inventoryObserver){
        observers.add(inventoryObserver);
        notifyObserversNonEquippableItemsHaveChanged();
        notifyObserversEquippableItemsHaveChanged();
    }

    private void notifyObserversNonEquippableItemsHaveChanged() {
        for(InventoryObserver observer : observers){
            observer.receiveNonEquippableItems(getNonEquippableItems());
        }
    }

    private void notifyObserversEquippableItemsHaveChanged() {
        for(InventoryObserver observer : observers){
            observer.receiveEquippableItems(getEquippableItems());
        }
    }
    

    //TODO: Give observers the items it needs
    private EquippableItem[] getEquippableItems() {
        Collections.sort(equippableItems, new Comparator<EquippableItem>() {
            public int compare(EquippableItem item1, EquippableItem item2) {
                return item1.getName().compareTo(item2.getName());
            }
        });
        return equippableItems.toArray(new EquippableItem[equippableItems.size()]);
    }

    private NonEquippableItem[] getNonEquippableItems() {
        Collections.sort(nonEquippableItems, new Comparator<NonEquippableItem>() {
            public int compare(NonEquippableItem item1, NonEquippableItem item2) {
                return item1.getName().compareTo(item2.getName());
            }
        });
        return nonEquippableItems.toArray(new NonEquippableItem[nonEquippableItems.size()]);
    }
}



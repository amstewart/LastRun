package model.item;

import model.observer.InventoryObserver;

import java.util.*;

public class Inventory {

    private ArrayList<InventoryObserver> observers;

    private ArrayList<NonEquippableItem> nonEquippableItems;
    private ArrayList<EquippableItem> equippableItems;
    private ArrayList<ActivationItem> activationItems;

    public Inventory() {
        observers = new ArrayList<>();

        nonEquippableItems = new ArrayList<>();
        equippableItems = new ArrayList<>();
        activationItems = new ArrayList<>();

        this.add(ItemFactory.newKey1());
        this.add(ItemFactory.newBFSword());
        this.add(ItemFactory.newHealthPotion());
        this.add(ItemFactory.getRandomSmasherWeapon());
        this.add(ItemFactory.getRandomSmasherWeapon());
        this.add(ItemFactory.getRandomSmasherWeapon());
        this.add(ItemFactory.getRandomSneakWeapon());
        this.add(ItemFactory.newShield());
        this.add(ItemFactory.getRandomHeadEquipment());
        this.add(ItemFactory.newChest1());
        this.add(ItemFactory.getRandomSummonerWeapon());
        this.add(ItemFactory.getRandomNonEquippableItem());
        this.add(ItemFactory.getRandomNonEquippableItem());
        this.add(ItemFactory.getRandomNonEquippableItem());
    }

    public void add(EquippableItem equippableItem) {
        equippableItems.add(equippableItem);
        notifyObservers();
    }

    public void add(NonEquippableItem nonEquippableItem) {
        nonEquippableItems.add(nonEquippableItem);
        notifyObservers();
    }

    public void add(ActivationItem activationItem) {
        activationItems.add(activationItem);
        notifyObservers();
    }

    public void remove(EquippableItem equippableItem) {
        if(equippableItems.contains(equippableItem)) {
            equippableItems.remove(equippableItem);
            notifyObservers();
        }
    }

    public void remove(NonEquippableItem nonEquippableItem) {
        if(nonEquippableItems.contains(nonEquippableItem)) {
            nonEquippableItems.remove(nonEquippableItem);
            notifyObservers();
        }
    }

    public void remove(ActivationItem activationItem) {
        if(activationItems.contains(activationItem)) {
            activationItems.remove(activationItem);
            notifyObservers();
        }
    }

    public void addObserver(InventoryObserver inventoryObserver){
        observers.add(inventoryObserver);
        notifyObservers();
    }

    private void notifyObservers() {
        for(InventoryObserver observer: observers) {
            observer.receiveTakeableItems(getEquippableItems(), getNonEquippableItems(), getActivationItems());
        }
    }

    public ArrayList<ActivationItem> getActivationItems() {
        return activationItems;
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



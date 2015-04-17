package model.observer;

import model.item2.EquippableItem;
import model.item2.NonEquippableItem;

public interface InventoryObserver {

    void receiveEquippableItems(EquippableItem[] equippableItems);
    void receiveNonEquippableItems(NonEquippableItem[] nonEquippableItems);
    
}

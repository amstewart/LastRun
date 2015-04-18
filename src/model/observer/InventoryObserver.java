package model.observer;

import model.item.EquippableItem;
import model.item.NonEquippableItem;

public interface InventoryObserver {

    void receiveEquippableItems(EquippableItem[] equippableItems);
    void receiveNonEquippableItems(NonEquippableItem[] nonEquippableItems);
    
}

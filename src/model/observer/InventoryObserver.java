package model.observer;

import model.item2.EquippableItem;
import model.item2.NonEquippableItem;

public interface InventoryObserver {
    public void receiveEquippableItems(EquippableItem[] equippableItems);
    public void receiveNonEquippableItems(NonEquippableItem[] nonEquippableItems);
    
}

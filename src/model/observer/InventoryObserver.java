package model.observer;

import model.item.ActivationItem;
import model.item.EquippableItem;
import model.item.NonEquippableItem;

import java.util.ArrayList;

public interface InventoryObserver {

    void receiveTakeableItems(EquippableItem[] equippableItems, NonEquippableItem[] nonEquippableItems,
                                 ArrayList<ActivationItem> activationItems);
}

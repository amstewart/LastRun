package model.observer;

import model.item2.EquippableItem;

public interface EquipmentHandlerObserver {

    void receiveEquipment(EquippableItem[] equippableItems);
}

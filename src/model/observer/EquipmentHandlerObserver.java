package model.observer;

import model.item.EquippableItem;

import java.util.ArrayList;
import java.util.HashMap;

public interface EquipmentHandlerObserver {

    void receiveEquipment(HashMap<String, EquippableItem> equipment);
}

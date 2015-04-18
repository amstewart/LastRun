package controller.action.equipmentHandlerAction;

import controller.action.Action;
import model.item.EquipmentHandler;
import model.item.EquippableItem;

public class EquipAction extends Action {

    private EquippableItem equippableItem;
    private EquipmentHandler equipmentHandler;

    public EquipAction(EquipmentHandler equipmentHandler) {
        this.equipmentHandler = equipmentHandler;
    }

    public void setEquippableItem(EquippableItem equippableItem) {
        this.equippableItem = equippableItem;
    }

    @Override
    public void perform() {
        if(equippableItem != null) {
            equippableItem.equip(equipmentHandler);
        }
    }
}
package controller.action.equipmentHandlerAction;

import controller.action.Action;
import model.item.EquipmentHandler;
import model.item.EquippableItem;

public class UnequipAction extends Action {

    private EquippableItem equippableItem;
    private EquipmentHandler equipmentHandler;

    public UnequipAction(EquipmentHandler equipmentHandler) {
        this.equipmentHandler = equipmentHandler;
    }
    
    public void setEquippableItem(EquippableItem equippableItem) {
        this.equippableItem = equippableItem;
    }

    @Override
    public void perform() {
        if(equippableItem != null) {
            equippableItem.unequip(equipmentHandler);
        }
    }
}

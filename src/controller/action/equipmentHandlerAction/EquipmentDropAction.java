package controller.action.equipmentHandlerAction;

import controller.action.Action;
import model.item.EquippableItem;
import model.item.Inventory;

public class EquipmentDropAction extends Action {

    private EquippableItem equippableItem;
    private Inventory inventory;

    public EquipmentDropAction(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setCurrentItem(EquippableItem equippableItem) {
        this.equippableItem = equippableItem;
    }

    @Override
    public void perform() {
        if(equippableItem != null) {
            inventory.remove(equippableItem);
        }
    }
}

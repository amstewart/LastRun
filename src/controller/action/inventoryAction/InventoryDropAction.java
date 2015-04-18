
package controller.action.inventoryAction;

import controller.action.Action;
import model.item.Inventory;
import model.item.NonEquippableItem;


public class InventoryDropAction extends Action{

    private NonEquippableItem currentItem;
    private Inventory inventory;

    public InventoryDropAction(Inventory i){
        inventory = i;
    }

    public void setCurrentItem(NonEquippableItem currentItem) {
        this.currentItem = currentItem;
    }

    @Override
    public void perform() {
        if(currentItem != null){
            inventory.remove(currentItem);
        }
    }
}



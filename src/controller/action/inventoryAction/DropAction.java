
package controller.action.inventoryAction;

import controller.action.Action2;
import model.item.Inventory;
import model.item.TakeableItem;

public class DropAction extends Action2{

    Inventory inventory;
    TakeableItem currentItem;
    
    public DropAction(Inventory i){
        inventory = i;
    }

    public void setCurrentItem(TakeableItem currentItem) {
        this.currentItem = currentItem;
    }

    @Override
    public void perform() {
        if(currentItem != null){
            inventory.removeItem(currentItem);
        }
    }

    
    
}

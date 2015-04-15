
package controller2.inventoryAction;

import controller2.action.Action2;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
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

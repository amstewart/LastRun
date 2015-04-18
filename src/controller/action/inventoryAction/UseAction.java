
package controller.action.inventoryAction;

import controller.action.Action;
import model.item.Inventory;
import model.item.NonEquippableItem;

/**
 *
 * @author ChrisMoscoso
 */
public class UseAction extends Action {

    private NonEquippableItem item;
    private Inventory inventory;
    
    public UseAction(Inventory i){
        inventory = i;
    }
    
    @Override
    public void perform() {
        item.use();
    }

    public void setCurrentItem(NonEquippableItem item) {
        this.item = item;
    }
    
}

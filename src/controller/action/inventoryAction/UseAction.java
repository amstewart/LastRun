
package controller.action.inventoryAction;

import controller.action.Action;
import model.item.Inventory;
import model.item.NonEquippableItem;
import model.stat.Stats;

public class UseAction extends Action {

    private NonEquippableItem item;
    private Inventory inventory;
    private Stats playerStats;

    public UseAction(Inventory i, Stats playerStats){
        inventory = i;
        this.playerStats = playerStats;
    }
    
    @Override
    public void perform() {
        if(item != null) {
            item.use(playerStats);
            inventory.remove(item);
        }
    }

    public void setCurrentItem(NonEquippableItem item) {
        this.item = item;
    }
    
}

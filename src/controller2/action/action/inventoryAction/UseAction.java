package controller2.action.action.inventoryAction;

import controller2.action.Action2;
import model.entity.occupation.Occupation;
import model.item.TakeableItem;

public class UseAction extends Action2 {

    private TakeableItem item;
    private Occupation occupation;
  //  private Inventory inventory;

    public UseAction(Occupation occupation) {
      //  this.inventory = inventory;
        this.occupation = occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public void setCurrentItem(TakeableItem item) {
        this.item = item;
    }

    @Override
    public void perform() {
        if(item != null) {
            item.use(occupation);
        }
    }
}

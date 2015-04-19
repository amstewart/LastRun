package controller.action.equipmentHandlerAction;

import controller.action.Action;
import model.entity.Avatar;
import model.item.EquipmentHandler;
import model.item.EquippableItem;
import model.stat.Stats;

public class UnequipAction extends Action {

    private EquippableItem equippableItem;
     public Avatar avatar;
    private Stats stats;

    public UnequipAction(Avatar avatar, Stats stats) {
        this.avatar = avatar;
        this.stats = stats;
    }
    
    public void setEquippableItem(EquippableItem equippableItem) {
        this.equippableItem = equippableItem;
    }

    @Override
    public void perform() {
        if(equippableItem != null) {
            equippableItem.unequip(avatar);
        }
    }
}

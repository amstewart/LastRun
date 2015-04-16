package controller.action.equipmentAction;

import controller.action.Action;
import model.entity.occupation.Occupation;
import model.item.equipment.Equipment;

public class UnequipAction extends Action {

    private Equipment equipment;
    private Occupation occupation;

    public UnequipAction(Occupation occupation) {
        this.occupation = occupation;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public void perform() {
        if(equipment != null) {
            equipment.unUse(occupation);
        }
    }
}

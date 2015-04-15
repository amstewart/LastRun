package controller2.equipmentAction;

import controller2.action.Action2;
import model.entity.occupation.Occupation;
import model.item.equipment.Equipment;

public class UnequipAction extends Action2 {

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

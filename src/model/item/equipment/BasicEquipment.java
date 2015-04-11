package model.item.equipment;

import model.entity.occupation.Occupation;
import model.item.EquipmentManager;
//TODO: Add level checking of occupation
public abstract class BasicEquipment extends Equipment  {
    public BasicEquipment(String name, int value) {
        super(name, value);
    }

    public abstract boolean doEquip(EquipmentManager em);

    public abstract boolean doUnequip(EquipmentManager em);

    @Override
    public boolean use(Occupation occupation) {
        return occupation.addToEquipment(this);
    }
}

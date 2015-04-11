package model.item.equipment;

import model.entity.avatar.occupation.Occupation;
import model.item.SummonerEquipmentManager;

public class Staff extends SummonerEquipment {

    public Staff(String name, int value) {
        super(name, value);
    }



    @Override
    public boolean doEquip(SummonerEquipmentManager summonerEM) {
        return summonerEM.equipStaff(this);
    }

    @Override
    public boolean doUnEquip(SummonerEquipmentManager summonerEM) {
        return summonerEM.unequipStaff();
    }
}

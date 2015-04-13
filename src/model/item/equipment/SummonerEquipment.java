package model.item.equipment;

import model.entity.occupation.Occupation;
import model.item.SummonerEquipmentManager;

public abstract class SummonerEquipment extends Equipment {

    public SummonerEquipment(String name, int value) {
        super(name, value);
    }

    public abstract boolean doEquip(SummonerEquipmentManager summonerEM);

    public abstract boolean doUnEquip(SummonerEquipmentManager summonerEM);

    @Override
    public boolean use(Occupation occupation) {
        return occupation.addToEquipment(this);
    }

    @Override
    public boolean unUse(Occupation occupation) {
        return occupation.removeFromEquipment(this);
    }
}

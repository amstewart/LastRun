package model.item.equipment;

import model.item.SummonerEquipmentManager;

public class SpellBook extends SummonerEquipment {
    // TODO: ADD spell
    public SpellBook(String name, int value) {
        super(name, value);
    }

    @Override
    public boolean doEquip(SummonerEquipmentManager summonerEM) {
        return summonerEM.equipSpellBook(this);
    }

    @Override
    public boolean doUnEquip(SummonerEquipmentManager summonerEM) {
        return summonerEM.unequipSpellBook();
    }
}

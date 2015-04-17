package model.item.equipment;

import model.effect.Spell;
import model.item.SummonerEquipmentManager;

import java.util.HashSet;

public class SpellBook extends SummonerEquipment {

    private HashSet<Spell> spells = new HashSet<>();

    public SpellBook(String name, int value) {
        super(name, value);
    }

    /**
     * Adds a provided spell object to this spellbook
     * @param new_spell The new Spell to add
     * @return True, if the new spell was added; false, if the spell was already present in the spellbook
     */
    public boolean addSpell(Spell new_spell) {
        return spells.add(new_spell);
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

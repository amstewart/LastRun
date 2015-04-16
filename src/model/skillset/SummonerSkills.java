package model.skillset;

import model.effect.Spell;
import model.skill.ExternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;

public class SummonerSkills extends BasicSkills {

    private SpellSkill boon;
    private SpellSkill bane;
    private SpellSkill enchantment;
    private ExternalSkill staff;

    public SummonerSkills() {
        //boon = new Skill("Boon", 1);
       // bane = new Skill("Bane", 1);
       // enchantment = new Skill("Enchantment", 1);
        //staff = new Skill("Staff", 1);
    }

    protected SpellSkill getBoon() {
        return boon;
    }

    protected SpellSkill getBane() {
        return bane;
    }

    protected SpellSkill getEnchantment() {
        return enchantment;
    }

    protected ExternalSkill getStaff() {
        return staff;
    }
    
    public void notifySkills(int mana){
    	boon.setCanPeform(mana);
    	bane.setCanPeform(mana);
    	enchantment.setCanPeform(mana);
    }

    @Override
    public Skill[] getSkills() {
        Skill[] list = new Skill[] {getBargain(), getBindWound(), getObservation(),
                        getBoon(), getBane(), getEnchantment(), getStaff()};
        return list;
    }
}

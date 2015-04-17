package model.skillset;

import java.util.ArrayList;

import model.effect.Spell;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;

public class SummonerSkills extends BasicSkills {

    private SpellSkill boon;
    private SpellSkill bane;
    private SpellSkill enchantment;
    private ExternalSkill staff;

    public SummonerSkills() {
      //  boon = new SpellSkill("Boon", 1);
      //  bane = new SpellSkill("Bane", 1);
      //  enchantment = new SpellSkill("Enchantment", 1);
       // staff = new ExternalSkill("Staff", 1);
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

	@Override
	public void sortSkills(ArrayList<ExternalSkill> eSkills,
			ArrayList<InternalSkill> iSkills, ArrayList<SpellSkill> sSkills) {
		eSkills.add(getObservation());
		eSkills.add(getBargain());
		iSkills.add(getBindWound());
		sSkills.add(getBoon());
		sSkills.add(getBane());
		sSkills.add(getEnchantment());
		eSkills.add(getStaff());
		
	}
}

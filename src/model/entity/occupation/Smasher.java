package model.entity.occupation;

import java.util.ArrayList;
import model.item.EquipmentHandler;

import model.item.Inventory;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;
import model.skillset.SmasherSkills;

public class Smasher extends Occupation {

    private SmasherSkills skills;

    public Smasher(Inventory inventory) {
        super(inventory);
        skills = new SmasherSkills();
        setSmasherItemSlots();
    }

    private void setSmasherItemSlots() {
        ArrayList<String> slots = getBasicSlots();
        
        slots.add(EquipmentHandler.SMASHER_WEAPON);
        slots.add(EquipmentHandler.SHIELD);        

        updateEquipmentHandler(slots);
    }

    @Override
    public Skill[] getSkills() {
        return skills.getSkills();
    }

    //=====TEST TEMP==========
    @Override
    public String getName() {
        return "Smasher";
    }

	@Override
	public void notifyManaSkills(int mana) {
		//Mixed Instance :,(
		
	}

	@Override
	public void sortSkills(ArrayList<ExternalSkill> eSkills,
			ArrayList<InternalSkill> iSkills, ArrayList<SpellSkill> sSkills) {
		skills.sortSkills(eSkills,iSkills,sSkills);
	}

	@Override
	public SmasherSkills getSkillBook() {
		return this.skills;
	}

}

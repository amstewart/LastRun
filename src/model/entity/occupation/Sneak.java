package model.entity.occupation;

import java.util.ArrayList;
import model.item.EquipmentHandler;

import model.item.Inventory;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;
import model.skillset.SneakSkills;

public class Sneak extends Occupation {

    private SneakSkills skills;

    public Sneak(Inventory inventory) {
        super(inventory);
        skills = new SneakSkills();
        setSneakItemSlots();
    }

    private void setSneakItemSlots() {
        ArrayList<String> slots = getBasicSlots();
        
        slots.add(EquipmentHandler.SNEAK_WEAPON);

        updateEquipmentHandler(slots);
    }

    @Override
    public Skill[] getSkills() {
        return skills.getSkills();
    }
    
    

    //=====TEST TEMP==========
    @Override
    public String getName() {
        return "Sneak";
    }


	@Override
	public void notifySkills(int mana) {
		// TODO Auto-generated method stub
	}

	@Override
	public void sortSkills(ArrayList<ExternalSkill> eSkills,
			ArrayList<InternalSkill> iSkills, ArrayList<SpellSkill> sSkills) {
		skills.sortSkills(eSkills, iSkills, sSkills);
		
	}
	
	@Override
	public SneakSkills getSkillBook() {
		return this.skills;
	}

}

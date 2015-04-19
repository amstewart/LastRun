package model.entity.occupation;

import java.util.ArrayList;

import Visitor.OccupationVisitor;
import Visitor.VisitorContainer;
import model.item.EquipmentHandler;
import model.item.Inventory;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;
import model.skillset.SneakSkills;
import model.stat.Stats;

public class Sneak extends Occupation {

    public static final String SNEAK_WEAPON = "SneakWeapon";

    private SneakSkills skills;

    public Sneak(Inventory inventory, Stats playerStats) {
        super(inventory, playerStats);
        skills = new SneakSkills();
        setSneakItemSlots();
    }

    private void setSneakItemSlots() {
        ArrayList<String> slots = getBasicSlots();
        
        slots.add(SNEAK_WEAPON);

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
	public void notifyManaSkills(int mana) {
		//Mixed Inst	@Overrideance :,(
		
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

	@Override
	public void accept(OccupationVisitor occupationVisitor, VisitorContainer container) {
		container.setOccupation(this);
		
	}



	
	

}

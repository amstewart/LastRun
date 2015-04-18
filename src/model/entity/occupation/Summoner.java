package model.entity.occupation;

import java.util.ArrayList;
import model.item.EquipmentHandler;

import model.item.Inventory;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;
import model.skillset.SummonerSkills;

public class Summoner extends Occupation {

    private SummonerSkills skills;

    public Summoner(Inventory inventory) {
        super(inventory);
        skills = new SummonerSkills();
        setSummonerItemSlots();
    }

    private void setSummonerItemSlots() {
        ArrayList<String> slots = getBasicSlots();
        
        slots.add(EquipmentHandler.SUMMONER_WEAPON);

        updateEquipmentHandler(slots);
    }

    @Override
    public Skill[] getSkills() {
        return skills.getSkills();
    }

    //=====TEST======
    public String getName() {
        return "Summoner";
    }


	@Override
	public void notifySkills(int mana) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortSkills(ArrayList<ExternalSkill> eSkills,
			ArrayList<InternalSkill> iSkills, ArrayList<SpellSkill> sSkills) {
		skills.sortSkills(eSkills,iSkills,sSkills);
		
	}
	@Override
	public SummonerSkills getSkillBook() {
		return this.skills;
	}

}

package model.entity.occupation;

import java.util.ArrayList;

import visitor.OccupationVisitor;
import visitor.VisitorContainer;
import model.entity.Entity;
import model.item.EquipmentHandler;
import model.item.Inventory;
import model.map.GameMap;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;
import model.skillset.SummonerSkills;
import model.stat.Stats;

public class Summoner extends Occupation {

    public static final String SUMMONER_WEAPON = "SummonerWeapon";

    private SummonerSkills skills;

    public Summoner(Inventory inventory, Stats playerStats) {
        super(inventory, playerStats);
        skills = new SummonerSkills();
        getEquipmentHandler().setEquipmentManager();
        setSummonerItemSlots();
    }

    private void setSummonerItemSlots() {
        ArrayList<String> slots = getBasicSlots();
        
        slots.add(SUMMONER_WEAPON);

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
	public void notifyManaSkills(int mana) {
		skills.notifyManaSkills(mana);
		
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

	@Override
	public void accept(OccupationVisitor occupationVisitor, VisitorContainer container) {
		container.setOccupation(this);
	}
	
	@Override
	public void performPassiveInternalSkill(String s, Entity e) {
		skills.performPassiveInternalSkill(s,e); 
		
	}

	@Override
	public void performPassiveExternalSkill(String s, Entity e, GameMap map) {
		skills.performPassiveExternalSkill(s,e,map);
		
	}
	@Override
	public void performWeaponSkills(Entity entity) {
		//mixed Instance:(
		
	}

	



	

}

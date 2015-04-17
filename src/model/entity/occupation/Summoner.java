package model.entity.occupation;

import java.util.ArrayList;

import model.item.Inventory;
import model.item.SummonerEquipmentManager;
import model.item.equipment.*;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;
import model.skillset.SummonerSkills;

public class Summoner extends Occupation {

    private SummonerEquipmentManager equipmentManager;
    private SummonerSkills skills;

    public Summoner(Inventory inventory) {
        super(inventory);
        equipmentManager = new SummonerEquipmentManager(inventory);
        skills = new SummonerSkills();
        buildSkillPtAllocator(getSkills());
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
    public boolean addToEquipment(BasicEquipment equipment) {
        return equipment.doEquip(equipmentManager);
    }

    @Override
    public boolean addToEquipment(SmasherEquipment equipment) {
        return false;
    }

    @Override
    public boolean addToEquipment(SneakEquipment equipment) {
        return false;
    }

    @Override
    public boolean addToEquipment(SummonerEquipment equipment) {
        return equipment.doEquip(equipmentManager);
    }
    //================================Unequipping===================================
    @Override
    public boolean removeFromEquipment(BasicEquipment equipment) { return equipment.doUnequip(equipmentManager); }

    @Override
    public boolean removeFromEquipment(SmasherEquipment equipment) { return false; }

    @Override
    public boolean removeFromEquipment(SneakEquipment equipment) { return false; }

    @Override
    public boolean removeFromEquipment(SummonerEquipment equipment) { return equipment.doUnEquip(equipmentManager); }

    @Override
    public Equipment[] getEquipment() {
        return equipmentManager.getEquippedItems();
    }


    public SummonerEquipmentManager getEquipmentManager() {
        return equipmentManager;
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

}

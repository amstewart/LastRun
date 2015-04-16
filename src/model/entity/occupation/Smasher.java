package model.entity.occupation;

import model.item.Inventory;
import model.item.SmasherEquipmentManager;
import model.item.equipment.*;
import model.skill.Skill;
import model.skillset.SkillPtAllocator;
import model.skillset.SmasherSkills;

public class Smasher extends Occupation {

    private SmasherEquipmentManager equipmentManager;
    private SmasherSkills skills;

    public Smasher(Inventory inventory) {
        super(inventory);
        equipmentManager = new SmasherEquipmentManager(inventory);
        skills = new SmasherSkills();
        buildSkillPtAllocator(getSkills());
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
    public boolean addToEquipment(BasicEquipment equipment) {
        return equipment.doEquip(equipmentManager);
    }

    @Override
    public boolean addToEquipment(SmasherEquipment equipment) {
        return equipment.doEquip(equipmentManager);
    }

    @Override
    public boolean addToEquipment(SneakEquipment equipment) {
        return false;
    }

    @Override
    public boolean addToEquipment(SummonerEquipment equipment) {
        return false;
    }

    //================================Unequipping===================================
    @Override
    public boolean removeFromEquipment(BasicEquipment equipment) { return equipment.doUnequip(equipmentManager); }

    @Override
    public boolean removeFromEquipment(SmasherEquipment equipment) { return equipment.doUnEquip(equipmentManager); }

    @Override
    public boolean removeFromEquipment(SneakEquipment equipment) { return false; }

    @Override
    public boolean removeFromEquipment(SummonerEquipment equipment) { return false; }

    @Override
    public Equipment[] getEquipment() {
        return equipmentManager.getEquippedItems();
    }

    public SmasherEquipmentManager getEquipmentManager() {
        return equipmentManager;
    }
    
	@Override
	public void notifySkills(int mana) {
		// TODO Auto-generated method stub
		
	}

}

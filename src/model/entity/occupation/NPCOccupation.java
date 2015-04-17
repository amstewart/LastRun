package model.entity.occupation;

import java.util.ArrayList;

import model.item.EquipmentManager;
import model.item.Inventory;
import model.item.equipment.*;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;

public class NPCOccupation extends Occupation {

    public NPCOccupation(Inventory inventory) {
        super(inventory);
    }

    @Override
    public Skill[] getSkills() {
    	//TODO will fix later
        return new Skill[0];
    }

    // ====TEMP TEST=====
    @Override
    public String getName() {
        return "NPC";
    }

    @Override
    public boolean addToEquipment(BasicEquipment equipment) {
        return false;
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
        return false;
    }

    @Override
    public boolean removeFromEquipment(BasicEquipment equipment) { return false; }

    @Override
    public boolean removeFromEquipment(SmasherEquipment equipment) { return false; }

    @Override
    public boolean removeFromEquipment(SneakEquipment equipment) { return false; }

    @Override
    public boolean removeFromEquipment(SummonerEquipment equipment) { return false; }

    @Override
    public Equipment[] getEquipment() {
        return new Equipment[0];
    }

    @Override
    public EquipmentManager getEquipmentManager() {
        return null;
    }
	@Override
	public void notifySkills(int mana) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortSkills(ArrayList<ExternalSkill> eSkills,
			ArrayList<InternalSkill> iSkills, ArrayList<SpellSkill> sSkills) {
		// TODO Auto-generated method stub
		
	}
	
}

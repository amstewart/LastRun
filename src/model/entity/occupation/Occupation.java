package model.entity.occupation;

import java.util.ArrayList;

import model.item.EquipmentHandler;
import model.item.Inventory;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;
import model.skillset.BasicSkills;


public abstract class Occupation {

    private final int initialSkillPoints;

    private EquipmentHandler equipmentHandler;

    public Occupation(Inventory inventory) {
        // points is hardcoded until we figure out where to get it
        initialSkillPoints = 5;
        equipmentHandler = new EquipmentHandler(inventory, getBasicSlots());
    }


    public EquipmentHandler getEquipmentHandler() {
        return equipmentHandler;
    }

    protected void updateEquipmentHandler(ArrayList<String> slots) {
        equipmentHandler.updateSlots(slots);
    }
    
    protected ArrayList<String> getBasicSlots(){
        ArrayList<String> list;
        list = new ArrayList<>();
        list.add(EquipmentHandler.HEAD);
        list.add(EquipmentHandler.CHEST);
        list.add(EquipmentHandler.LEGS);
        return list;
    }

    private void setBasicSlots() {
        updateEquipmentHandler(getBasicSlots());
    }

    public abstract Skill[] getSkills();

    public abstract BasicSkills getSkillBook();


    //=====TEMP TESTING======
    public abstract String getName();

	public abstract void notifyManaSkills(int mana);

	public abstract void sortSkills(ArrayList<ExternalSkill> eSkills,
			ArrayList<InternalSkill> iSkills, ArrayList<SpellSkill> sSkills);

}

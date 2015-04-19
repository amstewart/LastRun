package model.entity.occupation;

import java.util.ArrayList;

import Visitor.OccupationVisitor;
import Visitor.VisitorContainer;
import model.entity.Entity;
import model.item.EquipmentHandler;
import model.item.Inventory;
import model.map.GameMap;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;
import model.skillset.BasicSkills;
import model.stat.Stats;


public abstract class Occupation{

    public static final String HEAD = "Head";
    public static final String CHEST = "Chest";
    public static final String LEGS = "Legs";
    
    private final int initialSkillPoints;

    private EquipmentHandler equipmentHandler;

    public Occupation(Inventory inventory, Stats playerStats) {
        // points is hardcoded until we figure out where to get it
        initialSkillPoints = 5;
        equipmentHandler = new EquipmentHandler(inventory, getBasicSlots(), playerStats, this);
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
        list.add(HEAD);
        list.add(CHEST);
        list.add(LEGS);
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


	public boolean holds(String s) {
		return equipmentHandler.holds(s);
	}


	public abstract void accept(OccupationVisitor occupationVisitor,VisitorContainer container);
	
	public abstract void performPassiveInternalSkill(String s, Entity e);
	public abstract void performPassiveExternalSkill(String s, Entity e, GameMap map);



}

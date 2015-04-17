package model.entity.occupation;

import java.util.ArrayList;

import model.item.EquipmentManager;
import model.item.Inventory;
import model.item.SmasherEquipmentManager;
import model.item.equipment.*;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;
import model.skillset.BasicSkills;
import model.skillset.SkillPtAllocator;

public abstract class Occupation {

    private SkillPtAllocator skillPtAllocator;
    private final int initialSkillPoints;

    public Occupation(Inventory inventory) {
        // points is hardcoded until we figure out where to get it
        initialSkillPoints = 5;
    }

    protected void buildSkillPtAllocator(Skill[] skills) {
        skillPtAllocator = new SkillPtAllocator(initialSkillPoints, skills);
    }

    public SkillPtAllocator getSkillPtAllocator() {
        return skillPtAllocator;
    }

    public abstract Skill[] getSkills();

    // God this is horrible, but I can't think of another way right now
    // Subclasses responsible for overriding items that can equip
    public abstract boolean addToEquipment(BasicEquipment equipment);

    public abstract boolean addToEquipment(SmasherEquipment equipment);

    public abstract boolean addToEquipment(SneakEquipment equipment);

    public abstract boolean addToEquipment(SummonerEquipment equipment);

    public abstract boolean removeFromEquipment(BasicEquipment equipment);

    public abstract boolean removeFromEquipment(SmasherEquipment equipment);

    public abstract boolean removeFromEquipment(SneakEquipment equipment);

    public abstract boolean removeFromEquipment(SummonerEquipment equipment);

    public abstract EquipmentManager getEquipmentManager();

    public abstract Equipment[] getEquipment();

    //=====TEMP TESTING======
    public abstract String getName();

	public abstract void notifySkills(int mana);

	public abstract void sortSkills(ArrayList<ExternalSkill> eSkills,
			ArrayList<InternalSkill> iSkills, ArrayList<SpellSkill> sSkills);

}

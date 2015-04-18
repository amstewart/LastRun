package model.entity.occupation;

import java.util.ArrayList;

import model.item.Inventory;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;
import model.skillset.BasicSkills;

public class NPCOccupation extends Occupation {

	public NPCOccupation(Inventory inventory) {
		super(inventory);
	}

	@Override
	public BasicSkills getSkillBook() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Skill[] getSkills() {
		// TODO will fix later
		return new Skill[0];
	}

	// ====TEMP TEST=====
	@Override
	public String getName() {
		return "NPC";
	}

	@Override
	public void sortSkills(ArrayList<ExternalSkill> eSkills,
			ArrayList<InternalSkill> iSkills, ArrayList<SpellSkill> sSkills) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyManaSkills(int mana) {
		// TODO Auto-generated method stub

	}

}

package model.entity.occupation;

import java.util.ArrayList;

import java.util.HashMap;

import visitor.OccupationVisitor;
import visitor.VisitorContainer;

import model.entity.Entity;
import model.item.Inventory;
import model.map.GameMap;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;
import model.skillset.SmasherSkills;
import model.stat.Stats;

public class Smasher extends Occupation {

	public static final String SHIELD = "Shield";

	public static final String TWOHAND = "TWOHAND";
	public static final String ONEHAND = "ONEHAND";
	public static final String BRAWL = "BRAWL";

	private SmasherSkills skills;

	public Smasher(Inventory inventory, Stats playerStats) {
		super(inventory, playerStats);
		skills = new SmasherSkills();
		getEquipmentHandler().setEquipmentManager();
		setSmasherItemSlots();
	}

	private void setSmasherItemSlots() {
		ArrayList<String> slots = getBasicSlots();

		slots.add(ONEHAND);
		slots.add(TWOHAND);
		slots.add(BRAWL);
		slots.add(SHIELD);

		updateEquipmentHandler(slots);
	}

	@Override
	public Skill[] getSkills() {
		return skills.getSkills();
	}

	// =====TEST TEMP==========
	@Override
	public String getName() {
		return "Smasher";
	}

	@Override
	public void notifyManaSkills(int mana) {
		// Mixed Instance :,(

	}

	@Override
	public void sortSkills(ArrayList<ExternalSkill> eSkills,
			ArrayList<InternalSkill> iSkills, ArrayList<SpellSkill> sSkills) {
		skills.sortSkills(eSkills, iSkills, sSkills);
	}

	@Override
	public SmasherSkills getSkillBook() {
		return this.skills;
	}

	@Override
	public void accept(OccupationVisitor occupationVisitor,
			VisitorContainer container) {
		container.setOccupation(this);

	}

	@Override
	public void performPassiveInternalSkill(String s, Entity e) {
		skills.performPassiveInternalSkill(s, e);

	}

	@Override
	public void performPassiveExternalSkill(String s, Entity e, GameMap map) {
		skills.performPassiveExternalSkill(s, e, map);

	}

	@Override
	public void performWeaponSkills(Entity e) {
		skills.performWeaponSkills(e);

	}

}

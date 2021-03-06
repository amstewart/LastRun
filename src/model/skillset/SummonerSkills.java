package model.skillset;

import java.util.ArrayList;
import java.util.HashMap;

import utility.ImageUtil;
import model.effect.Bane;
import model.effect.Boon;
import model.effect.EntityStatusModifier;
import model.effect.Spell;
import model.effect.Staff;
import model.entity.Entity;
import model.entity.Status;
import model.enums.DefinedStats;
import model.enums.SkillStrings;
import model.map.GameMap;
import model.observer.EquipmentHandlerObserver;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;

public class SummonerSkills extends BasicSkills {

	private SpellSkill boon;
	private SpellSkill bane;
	private SpellSkill enchantment;
	private ExternalSkill staff;
	private HashMap<SkillStrings, ExternalSkill> passiveSkills_ex = new HashMap();

	public SummonerSkills() {
		Boon boonEffect1 = new Boon("fire",
				DefinedStats.ADDHARDINESS.getStats());
		Boon boonEffect2 = new Boon("ice", DefinedStats.ADDHEALTH.getStats());
		Boon boonEffect3 = new Boon("water",
				DefinedStats.ADDINTELLECT.getStats());
		boon = new SpellSkill("boon", 1, boonEffect1, boonEffect2, boonEffect3,
				1);
		Bane baneEffect1 = new Bane(ImageUtil.FIREBALL,
				DefinedStats.MINUSHARDINESS.getStats());
		Bane baneEffect2 = new Bane(ImageUtil.FIREBALL,
				DefinedStats.MINUSHEALTH.getStats());
		Bane baneEffect3 = new Bane(ImageUtil.FIREBALL,
				DefinedStats.MINUSINTELLECT.getStats());
		bane = new SpellSkill("Bane", 1, baneEffect1, baneEffect2, baneEffect3,
				7);
		EntityStatusModifier emod = new EntityStatusModifier(ImageUtil.AXE,
				Status.SLEEPING, ImageUtil.SINGING);
		EntityStatusModifier emod1 = new EntityStatusModifier(ImageUtil.AXE,
				Status.SLEEPING, ImageUtil.SLEEPING);
		EntityStatusModifier emod2 = new EntityStatusModifier(ImageUtil.AXE,
				Status.SLEEPING, ImageUtil.SMELLY);

		enchantment = new SpellSkill("Enchant", 1, emod, emod1, emod2, 7);

		Staff staf = new Staff();
		staff = new ExternalSkill("Staff", 1, staf, 1, false);

		passiveSkills_ex.put(SkillStrings.BARGAIN, getBargain());
	}

	protected SpellSkill getBoon() {
		return boon;
	}

	protected SpellSkill getBane() {
		return bane;
	}

	protected SpellSkill getEnchantment() {
		return enchantment;
	}

	protected ExternalSkill getStaff() {
		return staff;
	}

	public void notifyManaSkills(int mana) {
		boon.setCanPeform(mana);
		bane.setCanPeform(mana);
		enchantment.setCanPeform(mana);
	}

	@Override
	public Skill[] getSkills() {
		Skill[] list = new Skill[] { getBargain(), getBindWound(),
				getObservation(), getBoon(), getBane(), getEnchantment(),
				getStaff() };
		return list;
	}

	@Override
	public void sortSkills(ArrayList<ExternalSkill> eSkills,
			ArrayList<InternalSkill> iSkills, ArrayList<SpellSkill> sSkills) {
		eSkills.add(getObservation());
		eSkills.add(getBargain());
		iSkills.add(getBindWound());
		sSkills.add(getBoon());
		sSkills.add(getBane());
		sSkills.add(getEnchantment());
		eSkills.add(getStaff());

	}

	public void performPassiveExternalSkill(String s, Entity e, GameMap m) {
		
		ExternalSkill skill =  passiveSkills_ex.get(s);
		skill.performSkill(m, e);
	}
	public void performPassiveInternalSkill(String s, Entity e) {
		
		
	}

	@Override
	public void registerEquipmentHandlers(
			ArrayList<EquipmentHandlerObserver> observers) {
		//Mixed instance ;(
		
	}
}

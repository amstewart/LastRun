package model.skillset;

import java.util.ArrayList;
import java.util.HashMap;

import model.effect.Creep;
import model.effect.DetectTrap;
import model.effect.WeaponBasedStatModifier;
import model.entity.Entity;
import model.entity.occupation.Occupation;
import model.entity.occupation.Sneak;
import model.enums.SkillStrings;
import model.map.GameMap;
import model.observer.EquipmentHandlerObserver;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;

public class SneakSkills extends BasicSkills {

	private InternalSkill creep;
	private ExternalSkill trapDetectionRemoval;
	private InternalSkill range;
	private HashMap<SkillStrings, InternalSkill> passiveSkills_int = new HashMap();
	private HashMap<SkillStrings, ExternalSkill> passiveSkills_ex = new HashMap();

	public SneakSkills() {
		Creep creepEffect = new Creep();
		DetectTrap detectTrap = new DetectTrap();
		creep = new InternalSkill("Creep", 1, creepEffect, false);
		trapDetectionRemoval = new ExternalSkill("TrapRemoval", 1, detectTrap,
				5, true);
		WeaponBasedStatModifier wp = new WeaponBasedStatModifier(Sneak.RANGED,1);
		range = new InternalSkill("Range",1, wp,true);

		passiveSkills_int.put(SkillStrings.RANGE, range);
		passiveSkills_ex.put(SkillStrings.DETECTTRAP, trapDetectionRemoval);
		passiveSkills_ex.put(SkillStrings.BARGAIN, getBargain());

	}

	protected InternalSkill getCreep() {
		return creep;
	}

	protected ExternalSkill getTrapRemoval() {
		return trapDetectionRemoval;
	}

	protected InternalSkill getRange() {
		return range;
	}

	@Override
	public Skill[] getSkills() {
		Skill[] list = new Skill[] { getBargain(), getBindWound(),
				getObservation(), getCreep(), getTrapRemoval(), getRange() };

		return list;
	}

	@Override
	public void sortSkills(ArrayList<ExternalSkill> eSkills,
			ArrayList<InternalSkill> iSkills, ArrayList<SpellSkill> sSkills) {
		eSkills.add(getObservation());
		eSkills.add(getBargain());
		iSkills.add(getBindWound());
		iSkills.add(getRange());
		eSkills.add(getTrapRemoval());
		iSkills.add(getCreep());

	}

	public void performPassiveExternalSkill(String s, Entity e, GameMap m) {

		ExternalSkill skill = passiveSkills_ex.get(s);
		skill.performSkill(m, e);
	}

	public void performPassiveInternalSkill(String s, Entity e) {
		InternalSkill skill = passiveSkills_int.get(s);
		skill.performSkill(e);

	}

	@Override
	public void registerEquipmentHandlers(
			ArrayList<EquipmentHandlerObserver> observers) {
		observers.add(range);
		
	}

	public void performWeaponSkills(Entity e) {
		range.performSkill(e);

		
	}

}

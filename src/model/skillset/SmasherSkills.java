package model.skillset;

import java.util.ArrayList;
import java.util.HashMap;

import model.effect.WeaponBasedStatModifier;
import model.entity.Entity;
import model.entity.occupation.Smasher;
import model.enums.SkillStrings;
import model.map.GameMap;
import model.observer.EquipmentHandlerObserver;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;

public class SmasherSkills extends BasicSkills {

	private InternalSkill oneHand;
	private InternalSkill twoHand;
	private InternalSkill brawl;
	private HashMap<SkillStrings, InternalSkill> passiveSkills_int = new HashMap();
	private HashMap<SkillStrings, ExternalSkill> passiveSkills_ex = new HashMap();
	

	public SmasherSkills() {
		
		WeaponBasedStatModifier wb1 = new WeaponBasedStatModifier(Smasher.SMASHER_WEAPON, 1);
		
		oneHand = new InternalSkill("OneHand", 1, wb1, false);
		twoHand = new InternalSkill("TwoHand", 1, wb1, false);
		brawl = new InternalSkill("Brawl", 1, wb1, false);
		passiveSkills_int.put(SkillStrings.ONEHAND, oneHand);
		passiveSkills_int.put(SkillStrings.TWOHAND, twoHand);
		passiveSkills_int.put(SkillStrings.BRAWL, brawl);
		passiveSkills_ex.put(SkillStrings.BARGAIN, getBargain());
	}

	protected InternalSkill getOneHand() {
		return oneHand;
	}

	protected InternalSkill getTwoHand() {
		return twoHand;
	}

	protected InternalSkill getBrawl() {
		return brawl;
	}

	@Override
	public Skill[] getSkills() {
		Skill[] list = new Skill[] { getBargain(), getBindWound(),
				getObservation(), getOneHand(), getTwoHand(), getBrawl() };
		return list;
	}

	public void sortSkills(ArrayList<ExternalSkill> eSkills,
			ArrayList<InternalSkill> iSkills, ArrayList<SpellSkill> sSkills) {
		eSkills.add(getObservation());
		eSkills.add(getBargain());
		iSkills.add(getBindWound());
		iSkills.add(getOneHand());
		iSkills.add(getTwoHand());
		iSkills.add(getBrawl());

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
		observers.add(brawl);
		observers.add(oneHand);
		observers.add(twoHand);
	}

	public void performWeaponSkills(Entity e) {
		brawl.performSkill(e);
		oneHand.performSkill(e);
		twoHand.performSkill(e);
		
	}

}

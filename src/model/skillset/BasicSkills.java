package model.skillset;

import model.effect.BindWounds;
import model.effect.Observe;
import model.observer.EquipmentHandlerObserver;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import view.viewport.SkillsViewport;

public abstract class BasicSkills {

	private ExternalSkill bargain;
	private InternalSkill bindWound;
	private ExternalSkill observation;

	private int skillPoints = 5;
	private ArrayList<SkillsViewport> registeredViews;

	public void registerView(SkillsViewport view) {
		registeredViews.add(view);
	}

	public void notifyViews() {
            try{
		for (SkillsViewport view : registeredViews) {
			view.receiveSkillInfo(getSkills(), skillPoints);
		}
            }catch(ConcurrentModificationException ex){}
	}

	// some skill was incremented give all the skills to the view
	public void increment(Skill skill) {
		if (skillPoints > 0) {
			skill.increment();
			skillPoints--;
			notifyViews();
		}
	}

	public int getSkillPoints() {
		return skillPoints;
	}

	public BasicSkills() {
		registeredViews = new ArrayList<SkillsViewport>();
		// bargain = new ExternalSkill("Bargain", 1);
		BindWounds bw = new BindWounds();
		bindWound = new InternalSkill("BindWound", 1, bw, false);
		Observe obs = new Observe();
		observation = new ExternalSkill("Observation", 1, obs, 1, false);
	}

	protected ExternalSkill getBargain() {
		return bargain;
	}

	protected InternalSkill getBindWound() {
		return bindWound;
	}

	protected ExternalSkill getObservation() {
		return observation;
	}

	public abstract Skill[] getSkills();

	public abstract void sortSkills(ArrayList<ExternalSkill> eSkills,
			ArrayList<InternalSkill> iSkills, ArrayList<SpellSkill> sSkills);

	public abstract void registerEquipmentHandlers(
			ArrayList<EquipmentHandlerObserver> observers);

}

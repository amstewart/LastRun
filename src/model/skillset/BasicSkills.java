package model.skillset;

import model.effect.BindWounds;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;
import view.viewport.SkillPtAllocationViewport;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public abstract class BasicSkills {

	private ExternalSkill bargain;
	private InternalSkill bindWound;
	private ExternalSkill observation;

	private int skillPoints = 5;
	private ArrayList<SkillPtAllocationViewport> registeredViews;

	public void registerView(SkillPtAllocationViewport view) {
		registeredViews.add(view);
	}

	public void notifyViews() {
            try{
		for (SkillPtAllocationViewport view : registeredViews) {
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
		registeredViews = new ArrayList<SkillPtAllocationViewport>();
		// bargain = new ExternalSkill("Bargain", 1);
		BindWounds bw = new BindWounds();
		bindWound = new InternalSkill("BindWound", 1, bw, false);
		// observation = new ExternalSkill("Observation", 1);
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

}

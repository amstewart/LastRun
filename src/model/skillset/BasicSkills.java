package model.skillset;

import model.effect.BindWounds;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;
import view.viewport.SkillPtAllocationViewport;

import java.util.ArrayList;

public abstract class BasicSkills {

    private ExternalSkill bargain;
    private InternalSkill bindWound;
    private ExternalSkill observation;

    public BasicSkills() {
 
       // bargain = new ExternalSkill("Bargain", 1);
    	BindWounds bw = new BindWounds();
        bindWound = new InternalSkill("BindWound",1,bw,false);
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

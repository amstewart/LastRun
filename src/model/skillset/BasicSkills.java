package model.skillset;

import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;

// TODO: Each skill should have its own key listener set
public abstract class BasicSkills {

    private ExternalSkill bargain;
    private InternalSkill bindWound;
    private ExternalSkill observation;

    public BasicSkills() {
        //bargain = new ExternalSkill("Bargain", 1);
       // bindWound = new InternalSkill("BindWound", 1);
       // observation = new ExternalSkill("Observation", 1);
    }

    protected Skill getBargain() {
        return bargain;
    }

    protected Skill getBindWound() {
        return bindWound;
    }

    protected Skill getObservation() {
        return observation;
    }

    public abstract Skill[] getSkills();
}

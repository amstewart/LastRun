package model.skillset;

import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;

public class SneakSkills extends BasicSkills {

    private InternalSkill creep;
    private ExternalSkill trapDetectionRemoval;
    private InternalSkill range;

    public SneakSkills() {
        creep = new InternalSkill("Creep", 1);
        trapDetectionRemoval = new ExternalSkill("Trap Removal/Detection", 1);
        range = new InternalSkill("Range", 1);
    }

    protected Skill getCreep() {
        return creep;
    }

    protected Skill getTrapRemoval() {
        return trapDetectionRemoval;
    }

    protected Skill getRange() {
        return range;
    }

    @Override
    public Skill[] getSkills() {
        Skill[] list = new Skill[] {getBargain(), getBindWound(), getObservation(),
                getCreep(), getTrapRemoval(), getRange()};

        return list;
    }
}

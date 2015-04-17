package controller.action.skillAction;

import controller.action.Action;
import model.skill.Skill;
import model.skillset.SkillPtAllocator;

public class AllocateSkillPtAction extends Action {

    private Skill skill;
    private SkillPtAllocator skillPtAllocator;

    public AllocateSkillPtAction(SkillPtAllocator skillPtAllocator) {
        this.skillPtAllocator = skillPtAllocator;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public void perform() {
        if(skill != null) {
            skillPtAllocator.increment(skill);
        }
    }
}

package controller2.action.action.skillPtAction;

import controller2.action.Action2;
import model.skill.Skill;
import model.skillset.SkillPtAllocator;

public class AllocateSkillPtAction extends Action2 {

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

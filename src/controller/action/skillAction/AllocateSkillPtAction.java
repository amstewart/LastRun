package controller.action.skillAction;

import controller.action.Action;
import model.skill.Skill;
import model.skillset.BasicSkills;

public class AllocateSkillPtAction extends Action {

    private Skill skill;
    private BasicSkills basicSkills;

    public AllocateSkillPtAction(BasicSkills basicSkills) {
        this.basicSkills = basicSkills;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public void perform() {
        if(skill != null) {
        	basicSkills.increment(skill);
        }
    }
}

package model.skillset;

import model.skill.Skill;
import view.viewport.SkillPtAllocationViewport;

import java.util.ArrayList;
// Responsible for allocating points to any skill within that set.

public class SkillPtAllocator {

    private ArrayList<SkillPtAllocationViewport> registeredViews;

    private int skillPoints;
    private Skill[] skills;

    public SkillPtAllocator(int skillPoints, Skill[] skills) {
        registeredViews = new ArrayList<SkillPtAllocationViewport>();

        this.skillPoints = skillPoints;
        this.skills = skills;
    }

    public void registerView(SkillPtAllocationViewport view) {
        registeredViews.add(view);
    }

    public void notifyViews() {
        for(SkillPtAllocationViewport view: registeredViews) {
            view.receiveSkillPoints(skillPoints);
            view.receiveSkills(skills);

        }
    }
    // some skill was incremented give all the skills to the view
    public void increment(Skill skill) {
        if(skillPoints > 0) {
            skill.increment();
            skillPoints--;
            notifyViews();
        }
    }

    public Skill[] getSkills() {
        return skills;
    }
}

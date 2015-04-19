package model.skillset;

import model.skill.Skill;

import java.util.ArrayList;
import view.viewport.SkillsViewport;
// Responsible for allocating points to any skill within that set.

public class SkillPtAllocator {

    private ArrayList<SkillsViewport> registeredViews;

    private int skillPoints;
    private Skill[] skills;

    public SkillPtAllocator(int skillPoints, Skill[] skills) {
        registeredViews = new ArrayList<SkillsViewport>();

        this.skillPoints = skillPoints;
        this.skills = skills;
    }

    public void registerView(SkillsViewport view) {
        registeredViews.add(view);
    }

    // some skill was incremented give all the skills to the view
    public void increment(Skill skill) {
        if (skillPoints > 0) {
            skill.increment();
            skillPoints--;
        }
    }

    public Skill[] getSkills() {
        return skills;
    }

    public int getSkillPoints() {
        return skillPoints;

    }

    public void setSkills(Skill[] skills) {
        this.skills = skills;
    }
}

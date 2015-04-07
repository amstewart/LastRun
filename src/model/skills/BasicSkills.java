package model.skills;

// TODO: Each skill should have its own key listener set
public abstract class BasicSkills {

    private Skill bargain;
    private Skill bindWound;
    private Skill observation;

    public BasicSkills() {
        bargain = new Skill("Bargain", 1);
        bindWound = new Skill("BindWound", 1);
        observation = new Skill("Observation", 1);
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

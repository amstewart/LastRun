package model.skills;

public class SneakSkills extends BasicSkills {

    private Skill creep;
    private Skill trapDetectionRemoval;
    private Skill range;

    public SneakSkills() {
        creep = new Skill("Creep", 1);
        trapDetectionRemoval = new Skill("Trap Removal/Detection", 1);
        range = new Skill("Range", 1);
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

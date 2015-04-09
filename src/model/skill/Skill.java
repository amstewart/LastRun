package model.skill;

public abstract class Skill {
    private String name;
    private int level;

    public Skill(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
    
    public abstract void applyMultiplier();
    //add an accept Controller
}

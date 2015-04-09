package model.skill;

public class Skill {
    private String name;
    private int level;

    public Skill(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}

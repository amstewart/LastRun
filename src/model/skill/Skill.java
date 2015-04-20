package model.skill;

import controller.keyControllers.GameController;

public abstract class Skill {
    private String name;
    private int level;
    private boolean passive;

    public Skill(String name, int level, boolean passive) {
        this.name = name;
        this.level = level;
        this.passive = passive;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void increment() {
        level++;
        applyMultiplier();
    }
    
    public boolean isPassive(){
    	return passive;
    }

    public abstract void applyMultiplier();
    
  
}

package model.skillset;

import model.skill.Skill;

public class SummonerSkills extends BasicSkills {

    private Skill boon;
    private Skill bane;
    private Skill enchantment;
    private Skill staff;

    public SummonerSkills() {
        //boon = new Skill("Boon", 1);
       // bane = new Skill("Bane", 1);
       // enchantment = new Skill("Enchantment", 1);
        //staff = new Skill("Staff", 1);
    }

    protected Skill getBoon() {
        return boon;
    }

    protected Skill getBane() {
        return bane;
    }

    protected Skill getEnchantment() {
        return enchantment;
    }

    protected Skill getStaff() {
        return staff;
    }

    @Override
    public Skill[] getSkills() {
        Skill[] list = new Skill[] {getBargain(), getBindWound(), getObservation(),
                        getBoon(), getBane(), getEnchantment(), getStaff()};
        return list;
    }
}

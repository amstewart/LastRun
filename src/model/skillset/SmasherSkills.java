package model.skillset;

import model.skill.InternalSkill;
import model.skill.Skill;

public class SmasherSkills extends BasicSkills {

    private InternalSkill oneHand;
    private InternalSkill twoHand;
    private InternalSkill brawl;

    public SmasherSkills() {
       // oneHand = new InternalSkill("OneHand", 1);
       // twoHand = new InternalSkill("TwoHand", 1);
       // brawl = new InternalSkill("Brawl", 1);
    }

    protected InternalSkill getOneHand() {
        return oneHand;
    }

    protected InternalSkill getTwoHand() {
        return twoHand;
    }

    protected InternalSkill getBrawl() {
        return brawl;
    }

    @Override
    public Skill[] getSkills() {
        Skill[] list = new Skill[] {getBargain(), getBindWound(), getObservation(),
                        getOneHand(), getTwoHand(), getBrawl()};
        return list;
    }
}

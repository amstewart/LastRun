package model.skills;

public class SmasherSkills extends BasicSkills {

    private Skill oneHand;
    private Skill twoHand;
    private Skill brawl;

    public SmasherSkills() {
        oneHand = new Skill("OneHand", 1);
        twoHand = new Skill("TwoHand", 1);
        brawl = new Skill("Brawl", 1);
    }

    protected Skill getOneHand() {
        return oneHand;
    }

    protected Skill getTwoHand() {
        return twoHand;
    }

    protected Skill getBrawl() {
        return brawl;
    }

    @Override
    public Skill[] getSkills() {
        Skill[] list = new Skill[] {getBargain(), getBindWound(), getObservation(),
                        getOneHand(), getTwoHand(), getBrawl()};
        return list;
    }
}

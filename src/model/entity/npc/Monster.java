package model.entity.npc;

import model.skill.Skill;
import state.NPCBehaviour.NPCHostile;

import java.util.ArrayList;

public class Monster extends NPC {

    private static final String DESC = "FAWYRYSYR!";

    public Monster(String art_asset, String name, ArrayList<Skill> s) {
        super(art_asset);
        setName(name);
        setSkills(s);


        this.machine = new NPCHostile(s);
    }

    public String getDescription() { return getName() + ": " + DESC; }
}

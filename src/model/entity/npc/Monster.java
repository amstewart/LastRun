package model.entity.npc;

import visitor.EntityVisitor;
import visitor.VisitorContainer;
import model.skill.Skill;
import state.NPCBehaviour.NPCHostile;

import java.util.ArrayList;

import visitor.EntityVisitor;
import visitor.VisitorContainer;

public class Monster extends NPC {

    private static final String DESC = "FAWYRYSYR!";

    public Monster(String art_asset, String name, ArrayList<Skill> s) {
        super(art_asset);
        setName(name);
        setSkills(s);


        this.machine = new NPCHostile(s);
    }

    public String getDescription() { return getName() + ": " + DESC; }

	@Override
	public String talk() {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public void accept(EntityVisitor visitor, VisitorContainer container) {

    }

    
    
}

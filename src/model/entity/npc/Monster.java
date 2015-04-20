package model.entity.npc;

import model.map.GameMap;
import model.movement.NPCMovement;
import model.skill.ExternalSkill;
import visitor.EntityVisitor;
import visitor.VisitorContainer;
import model.skill.Skill;
import state.NPCBehaviour.NPCHostile;

import java.util.ArrayList;

import visitor.EntityVisitor;
import visitor.VisitorContainer;

public class Monster extends NPC {

    private static final String DESC = "FAWYRYSYR!";

    public Monster(String art_asset, String name) {
        super(art_asset);
        setName(name);
        setSkills();

    }

    private void setSkills() {
        ArrayList<ExternalSkill> monster = new ArrayList<ExternalSkill>();


       // this.skills.addAll(monster);
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


    @Override
    public void initMachine(NPCMovement em, GameMap gm) {
        this.machine = new NPCHostile(em, gm);
    }
}

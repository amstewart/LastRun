package model.entity.npc;

import model.entity.Entity;
import model.skill.Skill;
import state.NPCBehaviour.NPCHostile;
import state.stateMachine.NPCBehaviourMachine;

import java.util.ArrayList;

public abstract class NPC extends Entity {

    NPCBehaviourMachine machine;
    ArrayList<Skill> skills;

    public NPC (String art_asset) {
        super();
        setAssetID(art_asset);
    }

    public void setSkills(ArrayList<Skill> s){
        this.skills = s;
    }

}

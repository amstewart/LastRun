package model.entity.npc;

import model.entity.Entity;
import model.map.GameMap;
import model.movement.NPCMovement;
import model.skill.*;
import state.stateMachine.NPCBehaviourMachine;

import java.util.ArrayList;

public abstract class NPC extends Entity {

    NPCBehaviourMachine machine;
    protected ArrayList<ExternalSkill> skills;

    public NPC (String art_asset) {
        super();
        setAssetID(art_asset);
        giveMovement();
    }

    public void giveMovement(){
        skills = new ArrayList<ExternalSkill>();

        this.skills.add(new MoveNorthSkill(this));
        this.skills.add(new MoveNorthWestSkill(this));
        this.skills.add(new MoveNorthEastSkill(this));
        this.skills.add(new MoveSouthSkill(this));
        this.skills.add(new MoveSouthWestSkill(this));
        this.skills.add(new MoveSouthEastSkill(this));
    }

    public ArrayList<ExternalSkill> getSkills(){
        return this.skills;
    }

    public abstract void initMachine(NPCMovement em, GameMap gm);
}

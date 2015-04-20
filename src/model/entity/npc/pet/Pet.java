package model.entity.npc.pet;


import model.map.GameMap;
import model.movement.NPCMovement;
import model.terrain.Terrain;
import state.NPCBehaviour.PetBehaviour;
import state.stateMachine.NPCBehaviourMachine;
import visitor.EntityVisitor;
import visitor.VisitorContainer;
import model.entity.Entity;
import model.entity.npc.NPC;

import java.util.ArrayList;

public class Pet extends NPC {

    NPCBehaviourMachine pb;

    private static final String DESC = "This is your pet.";

    private Entity owner = null;

    public Pet(String art_asset, String name) {
        super(art_asset);
        setName(name);
    }

    public void adopt(Entity new_owner) {
        owner = new_owner;
    }

    public String getDescription() { return DESC + getName() + "."; }

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
        if(pb == null){
            this.pb = new PetBehaviour(em, gm);}
    }
}

package model.entity.npc.pet;


import model.terrain.Terrain;
import visitor.EntityVisitor;
import visitor.VisitorContainer;
import model.entity.Entity;
import model.entity.npc.NPC;

import java.util.ArrayList;

public class Pet extends NPC {

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
}

package model.entity.npc.pet;


import visitor.EntityVisitor;
import visitor.VisitorContainer;
import model.entity.Entity;
import model.entity.npc.NPC;

public class Pet extends NPC {

    private static final String DESC = "This is your pet ";

    private Entity owner = null;

    public Pet(String art_asset, String name) {
        super(art_asset);
        setName(name);
    }

    public String getDescription() { return DESC + getName() + "."; }

    public void adopt(Entity new_owner) {
        owner = new_owner;
    }

	@Override
	public String talk() {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public void accept(EntityVisitor visitor, VisitorContainer container) {

    }

}

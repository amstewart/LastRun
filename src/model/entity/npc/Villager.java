package model.entity.npc;

import Visitor.EntityVisitor;
import Visitor.VisitorContainer;

public class Villager extends NPC {

    private static final String DESC = "Hello!";

    public Villager(String art_asset, String name) {
        super(art_asset);
        setName(name);
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

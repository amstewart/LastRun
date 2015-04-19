package model.entity.vehicle;

import Visitor.EntityVisitor;
import Visitor.VisitorContainer;
import model.entity.npc.NPC;

public class Vehicle extends NPC {

    public Vehicle (String art_asset, String name) {
        super(art_asset);
        setName(name);
    }

    public String getDescription() {
        String ret = "It's a ";
        ret += getName();
        ret += ". You can ride it.";
        return ret;
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

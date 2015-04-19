package model.entity.vehicle;

import visitor.EntityVisitor;
import visitor.VisitorContainer;
import model.entity.npc.NPC;
import utility.Util;

public class Vehicle extends NPC {

    public Vehicle (String art_asset, String name, int speed) {
        super(art_asset);
        setName(name);
        this.setMovement(speed);
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

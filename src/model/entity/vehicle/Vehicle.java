package model.entity.vehicle;

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
}

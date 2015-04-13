package model.entity.npc.pet;

import model.entity.npc.NPC;

public class Pet extends NPC {
    private static final String DESC = "This is your pet ";

    public Pet(String art_asset, String name) {
        super(art_asset);
        setName(name);
    }

    public String getDescription() { return DESC + getName() + "."; }
}

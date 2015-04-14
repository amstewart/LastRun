package model.entity.npc;

public class Villager extends NPC {

    private static final String DESC = "Hello!";

    public Villager(String art_asset, String name) {
        super(art_asset);
        setName(name);
    }

    public String getDescription() { return getName() + ": " + DESC; }
}

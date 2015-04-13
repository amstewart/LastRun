package model.entity.npc;

public class Monster extends NPC {

    private static final String DESC = "FAWYRYSYR!";

    public Monster(String art_asset, String name) {
        super(art_asset);
        setName(name);
    }

    public String getDescription() { return getName() + ": " + DESC; }
}

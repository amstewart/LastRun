package model.item;

import model.entity.Entity;
import model.map.GameMap;
import model.map.MapBuilder;
import model.tile.Tile;
import utility.ImageUtil;

import java.util.ArrayList;
// Only one interactive item for this game, will be chest.
// Contains gold
public class InteractiveItem extends Item {

    private int activationId;

    public InteractiveItem(String name) {
        super(name);
    }

    @Override
    public void accept(Entity e, Tile tile) {
        e.visit(this);
    }
    // should be called when entity visits
    public boolean receiveKey(Inventory inventory, ArrayList<ActivationItem> keys) {
        for(ActivationItem key: keys) {
            if(key.activates(this)) {
                inventory.remove(key);
                inventory.add(ItemFactory.newGoldBar());
                setActivated();
                return true;
            }
        }
        return false;
    }

    public void setActivationId(int id) {
        this.activationId = id;
    }

    public int getActivationId() {
        return activationId;
    }

    private void setActivated() {
        setAssetID(ImageUtil.OPENCHEST);
    }
}

package model.item;

import model.Assetable;

public abstract class Item implements Assetable {

    private String name;
    protected String assetID;

    public Item(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String id) {
        assetID = id;

    }
}

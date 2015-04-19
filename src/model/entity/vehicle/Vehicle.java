package model.entity.vehicle;

import model.terrain.Terrain;
import visitor.EntityVisitor;
import visitor.VisitorContainer;
import model.entity.npc.NPC;
import utility.Util;

import java.util.ArrayList;

public class Vehicle extends NPC {

    public Vehicle (String art_asset, String name, int speed) {
        super(art_asset);
        setName(name);
        this.setMovement(speed);
        this.terrainTypesAllowedToMoveOn = new ArrayList<>();
        addTerrainMovement(Terrain.TerrainType.Grass);
    }

    public void addTerrainMovement(Terrain.TerrainType type) {
        this.terrainTypesAllowedToMoveOn.add(type);
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

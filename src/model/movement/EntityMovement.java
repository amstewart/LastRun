package model.movement;

import java.util.ArrayList;
import model.Vector2;
import model.entity.Entity;
import model.map.GameMap;
import model.tile.Tile;
import utility.Direction;
import utility.Util;

public class EntityMovement extends Movement {

    private Entity entity;
    private Vector2 facing_dir;

    public EntityMovement(Entity entity) {
        this(entity, Vector2.zero());
    }
    
    public EntityMovement(Entity entity, GameMap map, Vector2 starting_position){
        this(entity, starting_position);
        this.setMap(map);
    }

    public EntityMovement(Entity entity, Vector2 starting_position) {
        if (entity == null) {
            Util.errOut(new Exception("EntityMovement association initialized with a null entity."));
        }
        if (starting_position == null) {
            Util.errOut(new Exception("EntityMovement association initialized with a null starting position. Defaulting to ZERO vector."));
            starting_position = Vector2.zero();
        }

        initialize(entity, starting_position, Direction.SOUTH);
    }

    public void changeEntity(Entity new_ent) {
        if (new_ent == null) { Util.errOut(new Exception("EntityMovement set to null entity.")); }
        entity = new_ent;
    }

    public Vector2 getFacingDir() { return facing_dir; }

    public Entity getEntity(){
        return entity;
    }

    private void initialize(Entity ent, Vector2 pos_init, Vector2 facing_dir) {
        this.entity = ent;
        this.changePosition(pos_init);
        this.facing_dir = facing_dir;
    }

    public void reface(Vector2 new_facing) {
        this.facing_dir = new Vector2(new_facing);
        Util.dbgOut("Entity " + entity.getName() + " facing = " + facing_dir.toString(), 5);
    }

    public void setAsset(String new_asset) {
        entity.setAssetID(new_asset);
    }
    
    public ArrayList<Tile> getLightMap(GameMap map){
        ArrayList<Tile> tileList = new ArrayList<Tile>();
        
        for(Tile tile : map.createLocalAreaAngular(3, getPosition())){
            tileList.add(tile);
        }
        for(Tile tile : map.createLocalAreaRadial(1, getPosition())){
          tileList.add(tile);
        }
        
        
        return tileList;
    }
    
  
}

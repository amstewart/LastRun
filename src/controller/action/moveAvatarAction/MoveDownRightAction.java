package controller.action.moveAvatarAction;

import controller.action.Action;

import java.util.ArrayList;

import model.Vector2;
import model.entity.Entity;
import model.map.GameMap;
import model.terrain.Terrain;
import model.tile.Tile;
import utility.Direction;
import utility.ImageUtil;
import utility.Util;
import view.viewport.MapViewport;

/**
 *
 * @author ChrisMoscoso
 */
public class MoveDownRightAction extends Action {

    private GameMap map;

    public MoveDownRightAction() {
        Util.dbgOut("Dont forget to set the map for the action.", 3);
    }

    public MoveDownRightAction(GameMap m) {
        map = m;
    }

    public void setMap(GameMap m) {
        map = m;
    }

    public boolean isAreaEffect(Tile tile) {
        if (tile.isAreaEffectOwner()) {
            return true;
        }
        return false;
    }

    public void updateEntityTileLocation(Entity e, Tile source, Tile dest) {
        source.removeEntity(e);
        dest.addEntity(e);
        dest.accept(e);
    }

    public void applyAreaEffect(Entity e, Tile dest) {
        dest.getAreaEffect().apply(e);
    }

    @Override
    public void perform() {
        Vector2 sourceLocation = map.getAvatarMovement().getPosition();
        Vector2 destLocation = map.getTileToTheSouthEast(sourceLocation).getLocation();

        Tile source = map.getTile(sourceLocation);
        Tile dest = map.getTile(destLocation);

        ArrayList<Terrain.TerrainType> avatarsAllowableTerrainTypes = map.getAvatarMovement().getEntity().getTerrainTypesAllowedToMoveOn();
        Terrain.TerrainType destTerrain = map.getTile(destLocation).getTerrain().getTerrainType();
        
        if(avatarsAllowableTerrainTypes.contains(destTerrain)){
        	Entity e=source.getEntity();
        	map.moveAvatarTo(destLocation);
            map.refaceAvatar(Direction.SOUTHEAST, ImageUtil.inEffect[3]);
        	updateEntityTileLocation(e, source, dest);
            if(dest.isAreaEffectOwner()){
            	applyAreaEffect(e,dest);

            }
        } else {
            MapViewport.drawCantMove(destLocation);
        }
        
        map.refaceAvatar(Direction.SOUTHEAST, ImageUtil.inEffect[3]);
    }
}

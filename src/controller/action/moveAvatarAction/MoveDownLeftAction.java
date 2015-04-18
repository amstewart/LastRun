package controller.action.moveAvatarAction;

import controller.action.Action;

import java.util.ArrayList;

import model.Vector2;
import model.entity.Entity;
import model.entity.Status;
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
public class MoveDownLeftAction extends Action {

    private GameMap map;

    public MoveDownLeftAction() {
        Util.dbgOut("Dont forget to set the map for the action.", 3);
    }

    public MoveDownLeftAction(GameMap m) {
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
        Vector2 destLocation = map.getTileToTheSouthWest(sourceLocation).getLocation();

        Tile source = map.getTile(sourceLocation);
        Tile dest = map.getTile(destLocation);

        ArrayList<Terrain.TerrainType> avatarsAllowableTerrainTypes = map.getAvatarMovement().getEntity().getTerrainTypesAllowedToMoveOn();
        Terrain.TerrainType destTerrain = map.getTile(destLocation).getTerrain().getTerrainType();
        Entity e=source.getEntity();
        if(avatarsAllowableTerrainTypes.contains(destTerrain)){
        	
        	map.moveAvatarTo(destLocation);
        	if(!e.is(Status.INVISIBLE)){
                map.refaceAvatar(Direction.SOUTHWEST, ImageUtil.inEffect[1]);
            	}
        	updateEntityTileLocation(e, source, dest);
            if(dest.isAreaEffectOwner()){
            	applyAreaEffect(e,dest);
            }
        } else {
            MapViewport.drawCantMove(destLocation);
        }
        if(!e.is(Status.INVISIBLE)){
            map.refaceAvatar(Direction.SOUTHWEST, ImageUtil.inEffect[1]);
        	}

    }
}

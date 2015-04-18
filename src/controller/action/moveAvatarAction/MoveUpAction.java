package controller.action.moveAvatarAction;

import controller.action.Action;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import model.Vector2;
import model.entity.Entity;
import model.entity.Status;
import model.map.GameMap;
import model.movement.EntityMovement;
import model.terrain.Terrain;
import model.terrain.Terrain.TerrainType;
import model.tile.Tile;
import utility.Direction;
import utility.ImageUtil;
import utility.Util;
import view.viewport.MapViewport;

/**
 *
 * @author ChrisMoscoso
 */
public class MoveUpAction extends Action {

    private GameMap map;
    private EntityMovement avatarMovement;

    public MoveUpAction() {
        Util.dbgOut("Dont forget to set the map for the action.", 3);
    }

    public MoveUpAction(GameMap m) {
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
        Vector2 destLocation = map.getTileToTheNorth(sourceLocation).getLocation();

        Tile source = map.getTile(sourceLocation);
        Tile dest = map.getTile(destLocation);

        ArrayList<Terrain.TerrainType> avatarsAllowableTerrainTypes = map.getAvatarMovement().getEntity().getTerrainTypesAllowedToMoveOn();
        Terrain.TerrainType destTerrain = map.getTile(destLocation).getTerrain().getTerrainType();
        Entity e=source.getEntity();
        if(avatarsAllowableTerrainTypes.contains(destTerrain)){
        	
        	map.moveAvatarTo(destLocation);
        	if(!e.is(Status.INVISIBLE)){
                map.refaceAvatar(Direction.NORTH, ImageUtil.inEffect[8]);
            	}
        	updateEntityTileLocation(e, source, dest);
            if(dest.isAreaEffectOwner()){
            	applyAreaEffect(e,dest);
            }
        } else {
            MapViewport.drawCantMove(destLocation);
        }

        if(!e.is(Status.INVISIBLE)){
            map.refaceAvatar(Direction.NORTH, ImageUtil.inEffect[8]);
        	}
    }
}

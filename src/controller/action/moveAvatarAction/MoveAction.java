package controller.action.moveAvatarAction;

import controller.action.Action;
import model.Vector2;
import model.entity.Entity;
import model.entity.Status;
import model.map.GameMap;
import model.tile.Tile;
import utility.Direction;
import utility.ImageUtil;
import view.viewport.MapViewport;

/**
 * Created by diacopium on 15/04/19.
 */
public abstract class MoveAction extends Action {

    protected GameMap map;

    protected void moveDirection(Vector2 dir) {
        // Get the source tile
        Vector2 sourceLocation = map.getAvatarMovement().getPosition();
        Tile source = map.getTile(sourceLocation);

        // Collect the speed (based on mounted/not-mounted) and get dest tile
        int speed;
        Entity mover;
        if (source.vehicleMounted()) {
            speed = source.getVehicle().getMovement();
            mover = source.getVehicle();
        } else {
            speed = source.getEntity().getMovement();
            mover = source.getEntity();
        }

        for (int s = 0; s < speed; s++) {
            Tile dest = map.getTileInDirection(dir, source);

            // if the mover CANNOT move to the new tile
            if (!mover.getTerrainTypesAllowedToMoveOn().contains(dest.getTerrain().getTerrainType())) {
                MapViewport.drawCantMove(dest.getLocation());
                break;
            } else {
                map.moveTileEntities(source, dest);
            }

            /*if (!mover.is(Status.INVISIBLE)) {
                refaceAvatar();
            }*/
            
            source = dest;
            Entity e= source.getEntity();
            if(source.isAreaEffectOwner()){
            	applyAreaEffect(e,source);
            }
            if(source.isTrapOwner()){
            	applyTrapEffect(e,source);
            }
            
        }
        
        refaceAvatar();
    }
    private void applyAreaEffect(Entity e, Tile dest) {
        dest.getAreaEffect().apply(e);
    }
    private void applyTrapEffect(Entity e, Tile dest){
    	dest.getTrap().apply(e);
    }
    protected abstract void refaceAvatar();
}

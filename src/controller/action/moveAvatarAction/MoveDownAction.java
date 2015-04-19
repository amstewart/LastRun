package controller.action.moveAvatarAction;

import Visitor.EntityVisitor;
import Visitor.VisitorContainer;
import controller.action.Action;

import java.util.ArrayList;

import model.Vector2;
import model.entity.Entity;
import model.entity.Status;
import model.entity.occupation.Occupation;
import model.map.GameMap;
import model.skill.Skill;
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
public class MoveDownAction extends Action {

    private GameMap map;
    EntityVisitor visitor = new EntityVisitor();
    VisitorContainer container = new VisitorContainer();

    public MoveDownAction() {
        Util.dbgOut("Dont forget to set the map for the action.", 3);
    }

    public MoveDownAction(GameMap m) {
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

    private void applyAreaEffect(Entity e, Tile dest) {
        dest.getAreaEffect().apply(e);
    }
    private void applyTrapEffect(Entity e, Tile dest){
    	dest.getTrap().apply(e);
    }

    @Override
    public void perform() {
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
            Tile dest = map.getTileInDirection(Direction.SOUTH, source);

            // if the mover CANNOT move to the new tile
            if (!mover.getTerrainTypesAllowedToMoveOn().contains(dest.getTerrain().getTerrainType())) {
                MapViewport.drawCantMove(dest.getLocation());
                break;
            } else {
                map.moveTileEntities(source, dest);
                //map.moveAvatarTo(dest.getLocation());
            }

            if (!mover.is(Status.INVISIBLE)) {
                map.refaceAvatar(Direction.SOUTH, ImageUtil.inEffect[2]);
            }

            source = dest;
        }
    }
}

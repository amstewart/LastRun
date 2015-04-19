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
public class MoveUpAction extends MoveAction {

    public MoveUpAction() {
        Util.dbgOut("Dont forget to set the map for the action.", 3);
    }

    public MoveUpAction(GameMap m) {
        map = m;
    }

    public void setMap(GameMap m) {
        map = m;
    }

    private boolean isAreaEffect(Tile tile) {
        if (tile.isAreaEffectOwner()) {
            return true;
        }
        return false;
    }
    private void applyTrapEffect(Entity e, Tile dest){
    	dest.getTrap().apply(e);
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
        this.moveDirection(Direction.NORTH);
    }

    @Override
    protected void refaceAvatar() {
        map.refaceAvatar(Direction.NORTH, ImageUtil.inEffect[8]);
    }
}

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
public class MoveUpLeftAction extends MoveAction {

    public MoveUpLeftAction() {
        Util.dbgOut("Dont forget to set the map for the action.", 3);
    }

    public MoveUpLeftAction(GameMap m) {
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
        this.moveDirection(Direction.NORTHWEST);
    }

    @Override
    protected void refaceAvatar() {
        map.refaceAvatar(Direction.NORTHWEST, ImageUtil.inEffect[7]);
    }
}

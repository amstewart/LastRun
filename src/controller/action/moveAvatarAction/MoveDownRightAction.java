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
public class MoveDownRightAction extends MoveAction {

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

    private void applyAreaEffect(Entity e, Tile dest) {
        dest.getAreaEffect().apply(e);
    }
    private void applyTrapEffect(Entity e, Tile dest){
    	dest.getTrap().apply(e);
    }

    @Override
    public void perform() {
        this.moveDirection(Direction.SOUTHEAST);
    }

    @Override
    protected void refaceAvatar() {
        map.refaceAvatar(Direction.SOUTHEAST, ImageUtil.inEffect[3]);
    }
}

package controller.action.moveAvatarAction;

import visitor.EntityVisitor;
import visitor.VisitorContainer;
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
public class MoveDownAction extends MoveAction {

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
        this.moveDirection(Direction.SOUTH);
    }

    @Override
    protected void refaceAvatar() {
        map.refaceAvatar(Direction.SOUTH, ImageUtil.inEffect[2]);
    }
}

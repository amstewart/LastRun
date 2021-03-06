package controller.action.skillAction;

import controller.action.Action;
import model.entity.Entity;
import model.entity.Status;
import model.map.GameMap;
import model.movement.EntityMovement;
import model.tile.Tile;
import utility.Util;

/**
 * Created by diacopium on 15/04/19.
 */
public class MountAction extends Action {

    private GameMap map = null;
    private EntityMovement eMove = null;

    public MountAction(GameMap map, EntityMovement eMove) {
        linkToEntity(map, eMove);
    }

    public void linkToEntity(GameMap map, EntityMovement eMove) {
        this.map = map;
        this.eMove = eMove;
    }

    @Override
    public void perform() {
        if (map == null || eMove == null) {
            Util.errOut(new Exception("Mount action called w/ null entity attached."), false);
            return;
        }

        Tile tt = map.getTile(eMove.getPosition());
        if (tt.isVehicleOwner()) {
            // if a vehicle is here, toggle the entity on the tile to mount or unmount
            tt.toggleMount();
        } else { // if there is no vehicle
            Util.dbgOut("No vehicle to mount here.", 4);
            return;
        }
    }
}

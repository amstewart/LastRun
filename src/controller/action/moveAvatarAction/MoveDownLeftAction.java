package controller.action.moveAvatarAction;

import controller.action.Action2;
import model.Vector2;
import model.map.GameMap;
import utility.Util;

/**
 *
 * @author ChrisMoscoso
 */
public class MoveDownLeftAction extends Action2 {

    private GameMap map;
    
    public MoveDownLeftAction(){
        Util.dbgOut("Dont forget to set the map for the action.", 3);
    }
    
    public MoveDownLeftAction(GameMap m){
        map = m;
    }
    
    public void setMap(GameMap m){
        map = m;
    }

    @Override
    public void perform() {
        Vector2 v2 = map.getAvatarMovement().getPosition();
        v2 = map.getTileToTheSouthWest(v2).getLocation();
        map.moveAvatarTo(v2);
    }
}

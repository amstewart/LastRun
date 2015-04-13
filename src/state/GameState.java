package state;

import model.entity.Avatar;
import model.map.GameMap;
import view.viewport.GameViewport;

public class GameState extends State {
    

    public GameState(){
        GameMap map = new GameMap(); 
        Avatar a = new Avatar();
        map.addEntity(a);
        viewPort =  new GameViewport(map, a.getInventory());
    }

    @Override
    public void update() {
        //MAP MOVEMENT LOGIC
    }

    @Override
    public void onEnter() {
        
    }

    @Override
    public void onExit() {
        
    }

}

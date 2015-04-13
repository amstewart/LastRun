package state;

import model.entity.Avatar;
import model.entity.occupation.Occupation;
import model.item.Inventory;
import model.map.GameMap;
import view.viewport.GameViewport;

public class GameState extends State {
    
    private Inventory inventory;
    private Avatar player;
    private Occupation occupation;

    public GameState(){
        GameMap map = new GameMap(); 
        player = new Avatar();
        map.addEntity(player);
        inventory = player.getInventory();
        occupation = player.getOccupation();
        viewPort =  new GameViewport(map, inventory);
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

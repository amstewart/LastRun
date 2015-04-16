package state;

import controller.KeyController;
import model.entity.Avatar;
import model.entity.occupation.Occupation;
import model.item.Inventory;

import model.map.GameMap;
import view.viewport.GameViewport;


public class GameState extends State {

    // All temporary because stats will get the stuff from game bundle later
    private Inventory inventory;
    private Avatar player;
    private Occupation occupation;
    private GameMap map;

    public GameState(GameMap map, Avatar player){
        this.map = map;
        this.player = player;
        map.addEntity(player);
        inventory = player.getInventory();

        viewPort =  new GameViewport(map, inventory,player.getStats());
    }

    @Override
    public void update() {
        //MAP MOVEMENT LOGIC
    }

    @Override
    public void onEnter() {
        render();

        
        
        getViewport().addKeyListener(new KeyController(map,player));
        
        /*ArrayList<Action> a = new ArrayList<Action>();
        a.add(new MoveUp());
        a.add(new MoveDown());
        a.add(new MoveLU());
        a.add(new MoveLD());
        a.add(new MoveRU());
        a.add(new MoveRD());*/
        

        //getController().setGameSet(a);
        //getViewport().setListeners(a);
    }

    @Override
    public void onExit() {
        
    }

    private void setAllowedMoves(){
        //if(map.getTileToTheNorth().getTerrain().equals(grass)){
          //  mu.
        //}

    }

}

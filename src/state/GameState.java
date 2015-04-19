package state;

import controller.KeyController;
import model.Vector2;
import model.entity.Avatar;
import model.entity.occupation.Occupation;
import model.item.Inventory;
import model.map.GameMap;
import model.map.MapBuilder;
import utility.ImageUtil;
import view.viewport.GViewport;
import view.viewport.MapViewport;


public class GameState extends State {

    // All temporary because stats will get the stuff from game bundle later
    private Inventory inventory;
    private Avatar player;
    private Occupation occupation;
    private GameMap map;
    private MapViewport mapVP;

    public GameState(GameMap map, Avatar player){
        this.map = map;
        this.player = player;

        inventory = player.getInventory();
        mapVP = new MapViewport(map);
        viewPort =  new GViewport(mapVP, inventory, player);
    }

    @Override
    public void update() {
        //MAP MOVEMENT LOGIC
        //UGLY ASS CODE THAT IS TEMPORARY UNTIL VIEWPORTS COMPLETELY IMPLEMENT OBSERVER PATTERN
        GViewport v = (GViewport) viewPort;
        v.updateOccupation(player.getOccupation());
        
    }

    @Override
    public void onEnter() {
        render();

        KeyController kc = new KeyController(map, player, mapVP);
        getViewport().addKeyListener(kc);

        MapBuilder.addVehicle(map, new Vector2(6, 1), "Donkey", ImageUtil.NULL_ASSET, 2);
        //Pet en_puddles = new Pet(ImageUtil.EN_SKEL_S, "Puddles");
        //map.addEntity(en_puddles, new Vector2(1, 3));
        //map.getAvatarMovement().getEntity().addPet(en_puddles);

        
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

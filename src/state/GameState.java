package state;

import controller.KeyController;
import model.Vector2;
import model.entity.Avatar;
import model.entity.npc.pet.Pet;
import model.entity.occupation.Occupation;
import model.item.EquippableItem;
import model.item.Inventory;
import model.item.Item;
import model.item.ItemFactory;
import model.item.NonEquippableItem;
import model.map.GameMap;
import utility.ImageUtil;
import view.viewport.GameViewport;
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
        viewPort =  new GameViewport(mapVP, inventory, player);
    }

    @Override
    public void update() {
        //MAP MOVEMENT LOGIC
        
    }

    @Override
    public void onEnter() {
        render();
        NonEquippableItem i = ItemFactory.getRandomNonEquippableItem();
       
        
        
        getViewport().addKeyListener(new KeyController(map, player, mapVP));
        Pet en_puddles = new Pet(ImageUtil.EN_SKEL_S, "Puddles");
        
        en_puddles.addToInventory(i);
        map.addEntity(en_puddles, new Vector2(1, 3));
        map.getAvatarMovement().getEntity().addPet(en_puddles);

        
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

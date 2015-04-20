package state;

import controller.keyControllers.GameController;
import model.Vector2;
import model.entity.Avatar;
import model.entity.npc.pet.Pet;
import model.entity.occupation.Occupation;
import model.item.Inventory;
import model.item.ItemFactory;
import model.item.NonEquippableItem;
import model.map.GameMap;
import model.map.MapBuilder;
import model.terrain.Terrain;
import utility.ImageUtil;
import view.viewport.GameViewport;
import view.viewport.MapViewport;


public class GameState extends State {

    // All temporary because stats will get the stuff from game bundle later
    private GameController controller;
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
        
        controller = new GameController(map, player, mapVP);
        

        MapBuilder.addVehicle(map, new Vector2(6, 1), "Donkey", ImageUtil.VEH_DONKEY_SMILE, 1);
        NonEquippableItem i = ItemFactory.getRandomNonEquippableItem();

        Pet en_puddles = new Pet(ImageUtil.EN_SKEL_S, "Puddles");
        
        en_puddles.addToInventory(i);
        map.addEntity(en_puddles, new Vector2(1, 3));
        map.getAvatarMovement().getEntity().addPet(en_puddles);
    }

    @Override
    public void update() {
        //MAP MOVEMENT LOGIC
        
    }

    @Override
    public void onEnter() {
    	GameController kc = new GameController(map, player, mapVP);
        getViewport().addKeyListener(kc);
        render();

        
    }

    @Override
    public void onExit() {
        getViewport().removeKeyListener(controller);
        
    }
}

package state;

import controller.keyControllers.GameController;
import model.Vector2;
import model.entity.Avatar;
import model.entity.npc.pet.Pet;
import model.entity.occupation.Occupation;
import model.item.Inventory;
import model.map.GameMap;
import state.stateMachine.RPGStateMachine;
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
    }

    @Override
    public void update() {
        //MAP MOVEMENT LOGIC
        
    }

    @Override
    public void onEnter() {
        render();
        
        getViewport().addKeyListener(controller);
        Pet en_puddles = new Pet(ImageUtil.EN_SKEL_S, "Puddles");
        map.addEntity(en_puddles, new Vector2(1, 3));
        map.getAvatarMovement().getEntity().addPet(en_puddles);

        
    }

    @Override
    public void onExit() {
        getViewport().removeKeyListener(controller);
        
    }
}

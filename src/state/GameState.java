package state;

import controller.KeyController;
import model.Vector2;
import model.action.Action;
import model.entity.Avatar;
import model.entity.occupation.Occupation;
import model.item.Inventory;

import model.item.TakeableItem;
import model.map.GameMap;
import view.viewport.GameViewport;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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

        
        
        getViewport().addKeyListener(new KeyController(map));
        
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

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Actions ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    private class MoveUp extends Action {

        KeyListener kl;
        boolean execute;

        @Override
        public void perform(){
            Vector2 v2 = map.getAvatarMovement().getPosition();
            v2 = map.getTileToTheNorth(v2).getLocation();
            map.moveAvatarTo(v2);
        }
        @Override
        public void setActionListener(ActionListener al) {
        }
        @Override
        public void setKeyListener(KeyListener kl) {
            this.kl = kl;
        }
        @Override
        public void setMouseListener(MouseListener ml) {
        }
        @Override
        public ActionListener getActionListener() {
            return null;
        }
        @Override
        public KeyListener getKeyListener() {
            return this.kl;
        }
        @Override
        public MouseListener getMouseListener() {
            return null;
        }
    }

    private class MoveDown extends Action {

        KeyListener kl;
        boolean execute;

        @Override
        public void perform(){
            Vector2 v2 = map.getAvatarMovement().getPosition();
            v2 = map.getTileToTheSouth(v2).getLocation();
            map.moveAvatarTo(v2);
        }
        @Override
        public void setActionListener(ActionListener al) {
        }
        @Override
        public void setKeyListener(KeyListener kl) {
            this.kl = kl;
        }
        @Override
        public void setMouseListener(MouseListener ml) {
        }
        @Override
        public ActionListener getActionListener() {
            return null;
        }
        @Override
        public KeyListener getKeyListener() {
            return this.kl;
        }
        @Override
        public MouseListener getMouseListener() {
            return null;
        }
    }

    private class MoveLU extends Action {

        KeyListener kl;
        boolean execute;

        @Override
        public void perform(){
            Vector2 v2 = map.getAvatarMovement().getPosition();
            v2 = map.getTileToTheNorthWest(v2).getLocation();
            map.moveAvatarTo(v2);
        }
        @Override
        public void setActionListener(ActionListener al) {
        }
        @Override
        public void setKeyListener(KeyListener kl) {
            this.kl = kl;
        }
        @Override
        public void setMouseListener(MouseListener ml) {
        }
        @Override
        public ActionListener getActionListener() {
            return null;
        }
        @Override
        public KeyListener getKeyListener() {
            return this.kl;
        }
        @Override
        public MouseListener getMouseListener() {
            return null;
        }
    }

    private class MoveLD extends Action {

        KeyListener kl;
        boolean execute;

        @Override
        public void perform(){
            Vector2 v2 = map.getAvatarMovement().getPosition();
            v2 = map.getTileToTheSouthWest(v2).getLocation();
            map.moveAvatarTo(v2);
        }
        @Override
        public void setActionListener(ActionListener al) {
        }
        @Override
        public void setKeyListener(KeyListener kl) {
            this.kl = kl;
        }
        @Override
        public void setMouseListener(MouseListener ml) {
        }
        @Override
        public ActionListener getActionListener() {
            return null;
        }
        @Override
        public KeyListener getKeyListener() {
            return this.kl;
        }
        @Override
        public MouseListener getMouseListener() {
            return null;
        }
    }

    private class MoveRU extends Action {

        KeyListener kl;
        boolean execute;

        @Override
        public void perform(){
            Vector2 v2 = map.getAvatarMovement().getPosition();
            v2 = map.getTileToTheNorthEast(v2).getLocation();
            map.moveAvatarTo(v2);
        }
        @Override
        public void setActionListener(ActionListener al) {
        }
        @Override
        public void setKeyListener(KeyListener kl) {
            this.kl = kl;
        }
        @Override
        public void setMouseListener(MouseListener ml) {
        }
        @Override
        public ActionListener getActionListener() {
            return null;
        }
        @Override
        public KeyListener getKeyListener() {
            return this.kl;
        }
        @Override
        public MouseListener getMouseListener() {
            return null;
        }
    }

    private class MoveRD extends Action {

        KeyListener kl;
        boolean execute;

        @Override
        public void perform(){
            Vector2 v2 = map.getAvatarMovement().getPosition();
            v2 = map.getTileToTheSouthEast(v2).getLocation();
            map.moveAvatarTo(v2);
        }
        @Override
        public void setActionListener(ActionListener al) {
        }
        @Override
        public void setKeyListener(KeyListener kl) {
            this.kl = kl;
        }
        @Override
        public void setMouseListener(MouseListener ml) {
        }
        @Override
        public ActionListener getActionListener() {
            return null;
        }
        @Override
        public KeyListener getKeyListener() {
            return this.kl;
        }
        @Override
        public MouseListener getMouseListener() {
            return null;
        }
    }
}

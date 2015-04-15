package state;

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

    
    private Inventory inventory;
    private Avatar player;
 //   private occupation occupation;
    private GameMap map;

    public GameState(GameMap map, Avatar player){
        this.map = map;
        this.player = player;
        map.addEntity(player);
        inventory = player.getInventory();

        viewPort =  new GameViewport(map, inventory);
    }

    @Override
    public void update() {
        //MAP MOVEMENT LOGIC
    }

    @Override
    public void onEnter() {
        render();

        ArrayList<Action> a = new ArrayList<Action>();
        a.add(new MoveUp());
        a.add(new MoveDown());
        a.add(new MoveLU());
        a.add(new MoveLD());
        a.add(new MoveRU());
        a.add(new MoveRD());
        a.add(new Drop());

        getController().setGameSet(a);
        getViewport().setListeners(a);
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

    private class Drop extends Action {

        ActionListener al;

        @Override
        public void perform(){

        }
        public void perform(TakeableItem ti){
            inventory.removeItem(ti);
        }
        @Override
        public void setActionListener(ActionListener al) {
            this.al = al;
        }
        @Override
        public void setKeyListener(KeyListener kl) {
        }
        @Override
        public void setMouseListener(MouseListener ml) {
        }
        @Override
        public ActionListener getActionListener() {
            return this.al;
        }
        @Override
        public KeyListener getKeyListener() {
            return null;
        }
        @Override
        public MouseListener getMouseListener() {
            return null;
        }

    }
}

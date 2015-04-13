package state;

import model.Vector3;
import model.action.Action;
import model.entity.Avatar;
import model.item.TakeableItem;
import model.map.GameMap;
import state.stateMachine.RPGStateMachine;
import view.viewport.GameViewport;
import view.viewport.MapViewport;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GameState extends State {

    Avatar av;
    GameMap map;

    public GameState(){
        map = new GameMap();
        av = new Avatar();
        map.addEntity(av);
        //viewPort = new MapViewport(map);
        viewPort =  new GameViewport(map, av.getInventory());

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

    private void setAlowedMoves(){
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
            Vector3 v3 = map.getAvatarMovement().getPosition();
            v3 = map.getTileToTheNorth(v3).getLocation();
            map.moveAvatarTo(v3);
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
            Vector3 v3 = map.getAvatarMovement().getPosition();
            v3 = map.getTileToTheSouth(v3).getLocation();
            map.moveAvatarTo(v3);
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
            Vector3 v3 = map.getAvatarMovement().getPosition();
            v3 = map.getTileToTheNorthWest(v3).getLocation();
            map.moveAvatarTo(v3);
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
            Vector3 v3 = map.getAvatarMovement().getPosition();
            v3 = map.getTileToTheSouthwest(v3).getLocation();
            map.moveAvatarTo(v3);
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
            Vector3 v3 = map.getAvatarMovement().getPosition();
            v3 = map.getTileToTheNorthEast(v3).getLocation();
            map.moveAvatarTo(v3);
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
            Vector3 v3 = map.getAvatarMovement().getPosition();
            v3 = map.getTileToTheSouthEast(v3).getLocation();
            map.moveAvatarTo(v3);
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
            av.dropItem(ti);
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

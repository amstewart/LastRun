package state;

import model.action.Action;
import state.stateMachine.RPGStateMachine;
import view.viewport.HUDViewport;
import view.viewport.Viewport;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class HUDState extends State {

    private HUDViewport viewPort;

    public HUDState() {
        viewPort = new HUDViewport();
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {

    }

    @Override
    public void onEnter() {
        //actions in action
        render();
        ArrayList<Action> a = new ArrayList<Action>();
        a.add(new Equip());
        a.add(new Drop());

        getController().setHUDSelectionSet(a);
        getViewport().setListeners(a);
    }

    @Override
    public void onExit() {

    }

    @Override
    public Viewport getViewport() {
        return null;
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~ Actions~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    private class Equip extends Action{


        ActionListener al;

        @Override
        public void perform(){
            RPGStateMachine.getInstance().add("CharacterSelectionState", new CharacterSelectionState());
            RPGStateMachine.getInstance().changeToState("CharacterSelectionState");
        }

        @Override
        public void setActionListener(ActionListener al){
            this.al=al;
        }

        @Override
        public void setKeyListener(KeyListener kl){
        }

        @Override
        public ActionListener getActionListener(){
            return this.al;
        }

        @Override
        public KeyListener getKeyListener(){
            return null;
        }
    }

    private class Drop extends Action{


        ActionListener al;

        @Override
        public void perform(){

        }

        @Override
        public void setActionListener(ActionListener al){
            this.al=al;
        }

        @Override
        public void setKeyListener(KeyListener kl){
        }

        @Override
        public ActionListener getActionListener(){
            return this.al;
        }

        @Override
        public KeyListener getKeyListener(){
            return null;
        }
    }



}

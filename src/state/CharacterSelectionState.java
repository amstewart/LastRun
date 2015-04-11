
package state;

import model.action.Action;
import view.viewport.CharacterSelectionViewport;
import view.viewport.Viewport;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import state.stateMachine.RPGStateMachine;

public class CharacterSelectionState extends State{

    private CharacterSelectionViewport viewPort;

    public CharacterSelectionState(){
        viewPort =  new CharacterSelectionViewport();
    }
    
    @Override
    public void update() {

    }

    @Override
    public void render() {
        viewPort.render();
    }

    @Override
    public void onEnter() {
        render();
        ArrayList<Action> a = new ArrayList<Action>();
        a.add(new BackAct());
        a.add(new toPetSelectionAct());
        a.add(new testKeyAct());

        getController().setCharacterSelectionSet(a);
        getViewport().setListeners(a);
    }

    @Override
    public void onExit() {
        
    }

    @Override
    public Viewport getViewport() {
        return viewPort;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~ Actions ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    private class BackAct extends Action {


        ActionListener al;

        @Override
        public void perform() {
            RPGStateMachine.getInstance().pop();
        }

        @Override
        public void setActionListener(ActionListener al) {
            this.al = al;
        }

        @Override
        public void setKeyListener(KeyListener kl) {
        }

        @Override
        public ActionListener getActionListener() {
            return this.al;
        }

        @Override
        public KeyListener getKeyListener() {
            return null;
        }

    }

    private class toPetSelectionAct extends Action {


        ActionListener al;

        @Override
        public void perform() {

        }

        @Override
        public void setActionListener(ActionListener al) {
            this.al = al;
        }

        @Override
        public void setKeyListener(KeyListener kl) {
        }

        @Override
        public ActionListener getActionListener() {
            return this.al;
        }

        @Override
        public KeyListener getKeyListener() {
            return null;
        }

    }

    private class testKeyAct extends Action {


        KeyListener kl;

        @Override
        public void perform() {
            System.out.println("huzzah");
        }

        @Override
        public void setActionListener(ActionListener al) {}

        @Override
        public void setKeyListener(KeyListener kl) {
            this.kl = kl;
        }

        @Override
        public ActionListener getActionListener() {
            return null;
        }

        @Override
        public KeyListener getKeyListener() {
            return this.kl;
        }

    }
    
}

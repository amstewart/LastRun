
package state;

import view.viewport.CharacterSelectionViewport;
import view.viewport.Viewport;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

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
        ArrayList<Action> a = new ArrayList<Action>();
        a.add(new BackAct());
        a.add(new toPetSelectionAct());

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

            getStateMachine().pop();
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
    
}

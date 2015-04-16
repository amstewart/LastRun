
package state;

import model.action.Action;
import model.entity.Avatar;
import model.entity.OccupationChooser;
import view.viewport.CharacterSelectionViewport;
import view.viewport.Viewport;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import state.stateMachine.RPGStateMachine;

public class CharacterSelectionState extends State{

    private CharacterSelectionViewport viewPort;
    private Avatar avatar;

    public CharacterSelectionState(){
        avatar = new Avatar();
        OccupationChooser occupationChooser = avatar.getOccupationChooser();
        viewPort =  new CharacterSelectionViewport(occupationChooser);
    }

    @Override
    public void update() {

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

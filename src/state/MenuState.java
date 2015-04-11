package state;

import model.action.Action;
import controller.Controller;
import view.viewport.MenuViewport;
import view.viewport.Viewport;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import state.stateMachine.RPGStateMachine;

public class MenuState extends State {

    private MenuViewport viewPort;

    public MenuState() {
        viewPort = new MenuViewport();
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
        a.add(new StartGameAct());
        a.add(new LoadGameAct());
        a.add(new ExitGameAct());
        //take the current state and get the controller reference then pass in array

        // the array can be created as soon as you know the target state
        getController().setMenuLS(a);
        getViewport().setListeners(a);
    }

    @Override
    public void onExit() {

    }

    @Override
    public Viewport getViewport() {
        return viewPort;
    }

    public Controller getController() {
        return super.getController();
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~ Actions~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    private class StartGameAct extends Action {


        ActionListener al;

        @Override
        public void perform() {

            RPGStateMachine.getInstance().changeToCharSelectState();
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

    private class LoadGameAct extends Action {

        ActionListener al;

        public LoadGameAct() {

        }

        @Override
        public void perform() {
            System.out.println("This action was taken from Load Game Action");
        }

        public ActionListener getActionListener() {
            return this.al;
        }

        @Override
        public KeyListener getKeyListener() {
            return null;
        }

        public void setActionListener(ActionListener al) {
            this.al = al;
        }

        @Override
        public void setKeyListener(KeyListener kl) {
        }
    }

    private class ExitGameAct extends Action {

        ActionListener al;

        public ExitGameAct() {

        }

        @Override
        public void perform() {
            System.out.println("This action was taken from Exit Game Action");
        }

        public ActionListener getActionListener() {
            return this.al;
        }

        @Override
        public KeyListener getKeyListener() {
            return null;
        }

        public void setActionListener(ActionListener al) {
            this.al = al;
        }

        @Override
        public void setKeyListener(KeyListener kl) {
        }
    }
}
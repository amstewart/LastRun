package state;

import model.action.Action;
import view.viewport.MenuViewport;
import view.viewport.Viewport;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import state.stateMachine.RPGStateMachine;

public class MenuState extends State {

    public MenuState() {
        viewPort = new MenuViewport();
    }

    @Override
    public void update() {

    }

    @Override
    public void onEnter() {
        //actions in action
        render();
        
    }

    @Override
    public void onExit() {

    }

    @Override
    public Viewport getViewport() {
        return viewPort;
    }

}

package state;

import controller.action.stateMachineAction.GoToCharSelectAction;
import view.viewport.MenuViewport;
import view.viewport.Viewport;


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
        ((MenuViewport)viewPort).listenButton_NewGame(new GoToCharSelectAction());
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

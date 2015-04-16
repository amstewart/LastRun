package state;

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

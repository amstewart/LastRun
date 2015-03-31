
package model.state;

import controller.MenuController;
import view.viewport.MenuViewport;
import view.viewport.Viewport;

/**
 *
 * @author ChrisMoscoso
 */
public class MenuState implements iState{

    MenuViewport view; 
    MenuController controller;
    
    public MenuState(){
        view = new MenuViewport();
        controller = new MenuController();
    }
    
    @Override
    public void update() {
        
    }

    @Override
    public void render() {
        view.render();
    }

    @Override
    public void onExit() {
        
    }

    @Override
    public void onEnter() {
        
    }

    @Override
    public Viewport getViewport() {
        return view;
    }
}

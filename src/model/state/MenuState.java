
package model.state;

import controller.MenuController;
import model.GameBundle;
import view.viewport.MenuViewport;
import view.viewport.Meu;
import view.viewport.Viewport;

/**
 *
 * @author ChrisMoscoso
 */
public class MenuState implements iState{

    MenuViewport view; 
    MenuController controller;
    
    public MenuState(GameBundle bundle, StateMachine stateMachine){
        view = new MenuViewport();
        controller = new MenuController(bundle,stateMachine,view);
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

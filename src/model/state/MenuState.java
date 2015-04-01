
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
public class MenuState extends State{

    
    public MenuState(GameBundle bundle, StateMachine stateMachine){
        viewPort = new MenuViewport();
        controller = new MenuController(bundle,stateMachine,viewPort);
    }
    
    @Override
    public void update() {
        
    }

    @Override
    public void render() {
        viewPort.render();
    }

    @Override
    public void onExit() {
        
    }

    @Override
    public void onEnter() {
        
    }

    @Override
    public Viewport getViewport() {
        return viewPort;
    }
}

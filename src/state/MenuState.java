package state;

import controller.stateController.StateController;
import controller.stateController.stateListeners.ExitGameListener;
import controller.stateController.stateListeners.NewGameListener;
import state.stateMachine.RPGStateMachine;
import model.GameBundle;
import view.viewport.MenuViewport;

public class MenuState extends RPGState {

    StateController controller;
    MenuViewport menuViewport;

    public MenuState(GameBundle bundle, RPGStateMachine stateMachine) {
        this.controller = new StateController(bundle, stateMachine);
        menuViewport = new MenuViewport();
        viewport = menuViewport;
        
        menuViewport.setNewGameListener(new NewGameListener(controller));
        menuViewport.setExitGameListener(new ExitGameListener(controller));
         
        
    }
}

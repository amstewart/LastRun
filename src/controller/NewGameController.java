
package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.GameBundle;
import model.state.StateMachine;
import view.viewport.MenuViewport;
import view.viewport.NewGameViewport;
import view.viewport.Viewport;


public class NewGameController extends Controller{

    private NewGameViewport view;

    public NewGameController(GameBundle bundle, StateMachine stateMachine, NewGameViewport viewPort){
        super(bundle, stateMachine);
        view = viewPort;
        addActionListeners();
    }
    
    private void addActionListeners(){
        view.backButton.addActionListener(goToMainMenu);
   }
}

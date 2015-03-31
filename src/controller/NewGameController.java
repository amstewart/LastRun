
package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.GameBundle;
import model.state.StateMachine;
import view.viewport.MenuViewport;
import view.viewport.NewGameViewport;
import view.viewport.Viewport;

/**
 *
 * @author ChrisMoscoso
 */
public class NewGameController extends Controller{
      
    public NewGameController(GameBundle bundle, StateMachine stateMachine, Viewport viewPort){
        
        super(bundle, stateMachine, viewPort);
        
        addActionListeners();
    }
    
      private void addActionListeners(){
       
       NewGameViewport view = (NewGameViewport)viewPort;
       view.backButton.addActionListener(goToMainMenu);
   }
}

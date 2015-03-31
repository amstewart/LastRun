
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.GameBundle;
import model.state.NewGameState;
import model.state.StateMachine;
import view.viewport.MenuViewport;
import view.viewport.Viewport;

/**
 *
 * @author ChrisMoscoso
 */
public class MenuController extends Controller {
    
    
    public MenuController(GameBundle bundle, StateMachine stateMachine, Viewport viewPort){
        
        super(bundle, stateMachine,viewPort);
        addActionListeners();
    }
    
   private ActionListener goToNewGame = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                System.out.println("Inside Action Listener");
                stateMachine.setCurrentState( new NewGameState(bundle,stateMachine));
        }
    };
   
  
   private void addActionListeners(){
       
       MenuViewport menuView = (MenuViewport)viewPort;
       menuView.continueButton.addActionListener(goToNewGame);
   }
    
}

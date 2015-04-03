
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.GameBundle;
import state.StateMachine;
import view.viewport.MenuViewport;


public class MenuController extends Controller {

    private MenuViewport viewPort;

    public MenuController(GameBundle bundle, StateMachine stateMachine, MenuViewport viewPort){
        super(bundle, stateMachine);
        this.viewPort = viewPort;
        addActionListeners();
    }
    
    private ActionListener goToNewGame = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Continue Button Clicked");
                getStateMachine().changeToState("newGameState", getBundle());
        }
    };
   
  
    private void addActionListeners(){
        viewPort.continueButton.addActionListener(goToNewGame);
    }
    
}

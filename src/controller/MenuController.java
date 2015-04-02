
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.GameBundle;
import model.state.NewGameState;
import model.state.StateMachine;
import view.viewport.MenuViewport;
import view.viewport.Viewport;


public class MenuController extends Controller {

    private MenuViewport view;

    public MenuController(GameBundle bundle, StateMachine stateMachine, MenuViewport viewPort){
        super(bundle, stateMachine);
        view = viewPort;
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
        view.continueButton.addActionListener(goToNewGame);
    }
    
}

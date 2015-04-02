
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GameBundle;
import state.StateMachine;
import view.viewport.NewGameViewport;


public class NewGameController extends Controller{

    private NewGameViewport view;

    public NewGameController(GameBundle bundle, StateMachine stateMachine, NewGameViewport viewPort){
        super(bundle, stateMachine);
        view = viewPort;
        addActionListeners();
    }
    private ActionListener goBack = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            getStateMachine().pop();
        }
    };

    private void addActionListeners(){
        view.backButton.addActionListener(goBack);
   }
}

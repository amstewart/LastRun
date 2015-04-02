
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import model.GameBundle;
import state.StateMachine;
import view.viewport.MenuViewport;


public class MenuController extends Controller{

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
        view.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "forward");
        view.getActionMap().put("forward", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("test");
            }
        });
    }
    
}

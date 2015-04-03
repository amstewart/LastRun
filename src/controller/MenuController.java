
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import model.GameBundle;
import state.StateMachine;
import view.viewport.MenuViewport;


public class MenuController extends Controller{

    private MenuViewport view;
    private AbstractAction north;
    private AbstractAction south;

    public MenuController(GameBundle bundle, StateMachine stateMachine, MenuViewport viewPort){
        super(bundle, stateMachine);
        view = viewPort;
        createActions();
        addActionListeners();
    }
    
    private void createActions() {
    	north = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("north");
            }
        };
        south = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("south");
            }
        };
        
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
        view.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0),KeyBinding.get(KeyEvent.VK_W));
        view.getActionMap().put(KeyBinding.get(KeyEvent.VK_W),getAction(KeyBinding.get(KeyEvent.VK_W)));
        
        view.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_X, 0),KeyBinding.get(KeyEvent.VK_X));
        view.getActionMap().put(KeyBinding.get(KeyEvent.VK_X),getAction(KeyBinding.get(KeyEvent.VK_X)));
    }

	private AbstractAction getAction(Command command) {
		switch(command){
		case NORTH:
			return this.north;
		case SOUTH:
			return this.south;
		}
		return this.north;
	}
    
}

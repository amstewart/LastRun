
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import model.GameBundle;
import state.StateMachine;
import view.viewport.CharacterSelectionViewport;
import view.viewport.GameViewport;


public class GameController extends Controller{

    private GameViewport view;

    public GameController(GameBundle bundle, StateMachine stateMachine, GameViewport viewPort){
        super(bundle, stateMachine);
        view = viewPort;
        addActionListeners();
        addKeyListeners();
        
    }
   
    private void addActionListeners(){
        
        view.pauseMenuButton.addActionListener(goToPause);
    }
    
    private void addKeyListeners(){
        
        System.out.println("Inside addKeyListeners");
        view.areaViewPanel.addKeyListener(goToPauseMenu);
    }
    
     //TODO: add a listener for the pause button since most states can pause
    protected KeyListener goToPauseMenu = new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
           
            System.out.println("Inside key pressed");
           if (e.getKeyCode() == KeyEvent.VK_SPACE) {
               System.out.println("It when inside here");
                getStateMachine().changeToState("pauseGameState", getBundle());
            } 
            
        }
        @Override
        public void keyReleased(KeyEvent e) {}
            
    };
    
    //TODO: add a listener for the pause button since most states can pause
    protected ActionListener goToPause = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                 getStateMachine().changeToState("pauseGameState", getBundle() );
            }
         
    };
}

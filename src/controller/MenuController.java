
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

    private MenuViewport viewPort;

    public MenuController(GameBundle bundle, StateMachine stateMachine, MenuViewport v){
        super(bundle, stateMachine);
        viewPort = v;
        addActionListeners();
    }
   
  
    private void addActionListeners(){

        // viewPort.continueButton.addActionListener(goToCharacterSelection);

        viewPort.continueButton.addActionListener(goToCharacterSelection);
        viewPort.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "forward");
        viewPort.getActionMap().put("forward", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
    
}

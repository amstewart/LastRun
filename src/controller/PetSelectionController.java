
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import src.model.entity.GameBundle;
import state.StateMachine;
import view.viewport.MenuViewport;
import view.viewport.PetSelectionViewport;


public class PetSelectionController extends Controller{

    private PetSelectionViewport viewPort;

    public PetSelectionController(GameBundle bundle, StateMachine stateMachine, PetSelectionViewport v){
        super(bundle, stateMachine);
        viewPort = v;
        addActionListeners();
    }
    
    private void addActionListeners(){
        
        viewPort.getStartGameButton().addActionListener(resumeGame);
        viewPort.getCharacterButton().addActionListener(goToCharacterSelection);
    }
    
}

package view.viewport;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 */
public class MenuViewport extends Viewport {

    private JButton newGame, exitGame;

    public MenuViewport() {
        initComponents();
    }
    private void initComponents() {
        newGame = new JButton("New Game");
        exitGame = new JButton("Exit Game");
        
        this.setBackground(new Color(102, 153, 255));

        this.add(newGame, BorderLayout.CENTER);
        this.add(exitGame, BorderLayout.CENTER);
    }
    
    public void setNewGameListener(ActionListener a){
        newGame.addActionListener(a);
    }
    
    public void setExitGameListener(ActionListener a){
        exitGame.addActionListener(a);
    }
}

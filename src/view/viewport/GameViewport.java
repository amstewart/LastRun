package view.viewport;

import controller.stateController.StateController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ChrisMoscoso
 */
public class GameViewport extends Viewport{

    public GameViewport() {
    }

    private void initComponents() {
       
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawRect(0, 0, 500, 500);
        g.setColor(Color.WHITE);
        g.drawString("GAME", 200, 200);
    }
    
    @Override
    public void render() {
        
    }
}

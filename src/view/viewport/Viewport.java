
package view.viewport;

import javax.swing.JPanel;
import java.awt.Graphics;
/**
 *
 * @author ChrisMoscoso
 */
public abstract class Viewport extends JPanel{
    //Controller controller;
    
    public abstract void render();
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}

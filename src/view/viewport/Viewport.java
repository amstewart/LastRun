
package view.viewport;


import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author ChrisMoscoso
 */
public abstract class Viewport extends JPanel{
    
    protected ImageIcon backgroundImage;
    
    public abstract void render();
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
    
     protected void setButtonBackgroundTransparent(JButton button){
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }
}

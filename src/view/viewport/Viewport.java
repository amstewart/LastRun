
package view.viewport;

import model.action.Action;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;

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

    public abstract void setListeners(ArrayList<Action> a);
}

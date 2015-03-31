
package view.viewport;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author ChrisMoscoso
 */
public class GameViewport extends Viewport{

    public GameViewport() {
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
        this.repaint();
    }
    
    
}

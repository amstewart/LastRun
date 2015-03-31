
package view.viewport;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author ChrisMoscoso
 */
public class Meu extends Viewport {
    
    
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        System.out.println("Painting Menu");
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, 500, 500);
        g.setColor(Color.WHITE);
        g.drawString("MENU", 200, 200);
    }

    @Override
    public void render() {
                System.out.println("Supposed to paimt Menu");

        this.repaint();
    }
}


package view.window;

import javax.swing.JFrame;
import view.viewport.Viewport;

/**
 *
 * @author ChrisMoscoso
 */
public class GameWindow extends JFrame{
    public GameWindow(){
        this.setTitle("Last Run");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
   public void displayState(Viewport viewPort){
          
          System.out.println("Painting Viewport");
          this.getContentPane().removeAll();
          this.getContentPane().add(viewPort);
          viewPort.updateUI();
   }
}

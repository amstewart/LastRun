
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
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(this.getExtendedState()
                | JFrame.NORMAL);
        this.setVisible(true);
    }
    
   public void displayState(Viewport viewPort){
          
          this.getContentPane().removeAll();
          this.getContentPane().add(viewPort);
          viewPort.updateUI();
   }
}


package view.window;

import javax.swing.JFrame;

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
}

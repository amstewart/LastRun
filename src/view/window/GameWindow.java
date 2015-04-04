package view.window;

import javax.swing.JFrame;
import view.viewport.Viewport;

/**
 *
 * @author ChrisMoscoso
 */
public class GameWindow extends JFrame {

    public GameWindow() {
        this.setTitle("Last Run");
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setSize(1, 1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void displayState(Viewport viewport) {

        this.getContentPane().removeAll();
        this.getContentPane().add(viewport);
        viewport.updateUI();
        
    }
}

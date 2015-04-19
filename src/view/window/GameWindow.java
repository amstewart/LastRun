package view.window;

import javax.swing.JFrame;
import view.viewport.Viewport;

import java.awt.*;

/**
 *
 * @author ChrisMoscoso
 */
public class GameWindow extends JFrame {

    public GameWindow() {
        this.setTitle("Last Run");
        //this.setSize(800, 600);
        this.setMinimumSize(new Dimension(400, 300));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(this.getExtendedState()
                //| JFrame.NORMAL
                | JFrame.MAXIMIZED_BOTH
        );
        this.setVisible(true);
        javax.swing.ToolTipManager.sharedInstance().setInitialDelay(0);
    }

    public void displayState(Viewport viewPort) {

        this.getContentPane().removeAll();
        this.getContentPane().add(viewPort);
        viewPort.updateUI();
    }
}

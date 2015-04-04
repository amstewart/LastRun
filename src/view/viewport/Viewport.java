
package view.viewport;

import controller.stateController.StateController;
import javax.swing.JPanel;
/**
 *
 * @author ChrisMoscoso
 */
public abstract class Viewport extends JPanel{
    
    public void render(){
        this.revalidate(); //Will invoke paint component
    }
    
}
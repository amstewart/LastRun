
package controller.action.mapAction;

import controller.action.Action;
import view.viewport.MapViewport;

/**
 *
 * @author ChrisMoscoso
 */
public class ZoomOutMapAction extends Action{
    
    public MapViewport view;

    public ZoomOutMapAction(MapViewport view) {
        this.view = view;
    }
    
    
    @Override
    public void perform() {
        view.zoomOut();
    }
}

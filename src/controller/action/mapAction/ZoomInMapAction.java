
package controller.action.mapAction;

import controller.action.Action;
import view.viewport.MapViewport;

/**
 *
 * @author ChrisMoscoso
 */
public class ZoomInMapAction extends Action {

    public MapViewport view;

    public ZoomInMapAction(MapViewport view) {
        this.view = view;
    }
    
    @Override
    public void perform() {
        view.zoomIn();
    }
    
}

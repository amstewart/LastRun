package view.viewport;

import state.Action;

import java.util.ArrayList;

public class MerchantViewport extends Viewport {

    public MerchantViewport() {
        initComponents();
    }
    // TODO: initialize components for this view
    private void initComponents() {}

    @Override
    public void render() { this.revalidate(); }

    @Override
    public void setListeners(ArrayList<Action> a) {

    }
}

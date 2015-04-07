package state;

import view.viewport.MerchantViewport;
import view.viewport.Viewport;

public class MerchantState extends State {

    private MerchantViewport viewPort;

    public MerchantState() {
        viewPort = new MerchantViewport();
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {

    }

    @Override
    public void onEnter() {

    }

    @Override
    public void onExit() {

    }

    @Override
    public Viewport getViewport() {
        return viewPort;
    }
}

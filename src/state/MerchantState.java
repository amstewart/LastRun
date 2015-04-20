package state;

import controller.keyControllers.GeneralMenuController;
import view.viewport.MerchantViewport;
import view.viewport.Viewport;

public class MerchantState extends State {

    private MerchantViewport viewPort;

    public MerchantState() {
        viewPort = new MerchantViewport();
        controller = new GeneralMenuController();
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {

    }

    @Override
    public Viewport getViewport() {
        return viewPort;
    }
}

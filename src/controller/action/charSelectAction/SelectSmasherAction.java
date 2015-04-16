package controller.action.charSelectAction;

import controller.action.Action;
import model.entity.OccupationChooser;

public class SelectSmasherAction extends Action {

    private OccupationChooser occupationChooser;

    public SelectSmasherAction(OccupationChooser occupationChooser) {
        this.occupationChooser = occupationChooser;
    }

    @Override
    public void perform() {
        occupationChooser.selectSmasher();
    }
}

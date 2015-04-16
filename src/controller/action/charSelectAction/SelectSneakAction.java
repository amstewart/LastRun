package controller.action.charSelectAction;

import controller.action.Action;
import model.entity.OccupationChooser;

public class SelectSneakAction extends Action {

    private OccupationChooser occupationChooser;

    public SelectSneakAction(OccupationChooser occupationChooser) {
        this.occupationChooser = occupationChooser;
    }

    @Override
    public void perform() {
        occupationChooser.selectSneak();
    }
}

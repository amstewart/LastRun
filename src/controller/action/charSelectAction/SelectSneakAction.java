package controller.action.charSelectAction;

import controller.action.Action2;
import model.entity.OccupationChooser;

public class SelectSneakAction extends Action2 {

    private OccupationChooser occupationChooser;

    public SelectSneakAction(OccupationChooser occupationChooser) {
        this.occupationChooser = occupationChooser;
    }

    @Override
    public void perform() {
        occupationChooser.selectSneak();
    }
}

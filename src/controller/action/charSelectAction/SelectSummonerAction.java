package controller.action.charSelectAction;

import controller.action.Action;
import model.entity.OccupationChooser;

public class SelectSummonerAction extends Action {

    private OccupationChooser occupationChooser;

    public SelectSummonerAction(OccupationChooser occupationChooser) {
        this.occupationChooser = occupationChooser;
    }

    @Override
    public void perform() {
        occupationChooser.selectSummoner();
    }
}

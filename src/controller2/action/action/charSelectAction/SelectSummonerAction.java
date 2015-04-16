package controller2.action.action.charSelectAction;

import controller2.action.Action2;
import model.entity.OccupationChooser;

public class SelectSummonerAction extends Action2 {

    private OccupationChooser occupationChooser;

    public SelectSummonerAction(OccupationChooser occupationChooser) {
        this.occupationChooser = occupationChooser;
    }

    @Override
    public void perform() {
        occupationChooser.selectSummoner();
    }
}

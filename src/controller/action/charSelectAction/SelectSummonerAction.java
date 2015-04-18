package controller.action.charSelectAction;

import utility.ImageUtil;
import controller.action.Action;
import model.entity.Avatar;
import model.entity.OccupationChooser;
import model.entity.occupation.Smasher;
import model.entity.occupation.Summoner;

public class SelectSummonerAction extends Action {

	private Avatar avatar;

    public SelectSummonerAction(Avatar avatar) {
        this.avatar = avatar;
    }

    @Override
    public void perform() {
        avatar.setOccupation(new Summoner(avatar.getInventory()));
        ImageUtil.initSummoner();
        avatar.setAssetID(ImageUtil.inEffect[2]);
    }
}

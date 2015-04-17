package controller.action.charSelectAction;

import utility.ImageUtil;
import controller.action.Action;
import model.entity.Avatar;
import model.entity.OccupationChooser;
import model.entity.occupation.Smasher;
import model.entity.occupation.Sneak;

public class SelectSmasherAction extends Action {

	private Avatar avatar;

    public SelectSmasherAction(Avatar avatar) {
        this.avatar = avatar;
    }

    @Override
    public void perform() {
        avatar.setOccupation(new Smasher(avatar.getInventory()));
        ImageUtil.initSmasher();
        avatar.setAssetID(ImageUtil.inEffect[2]); //set Smasher
    }
}


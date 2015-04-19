package controller.action.charSelectAction;

import utility.ImageUtil;
import controller.action.Action;
import model.entity.Avatar;
import model.entity.occupation.Smasher;

public class SelectSmasherAction extends Action {

	private Avatar avatar;

    public SelectSmasherAction(Avatar avatar) {
        this.avatar = avatar;
    }

    @Override
    public void perform() {
        avatar.setOccupation(new Smasher(avatar.getInventory(), avatar.getStats()));
        ImageUtil.initSmasher();
        avatar.setAssetID(ImageUtil.inEffect[1]); //set sneak sprite sheet here
    }
}


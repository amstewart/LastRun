package controller.action.charSelectAction;

import utility.ImageUtil;
import controller.action.Action;
import model.entity.Avatar;
import model.entity.occupation.Sneak;

public class SelectSneakAction extends Action {

    private Avatar avatar;

    public SelectSneakAction(Avatar avatar) {
        this.avatar = avatar;
    }

    @Override
    public void perform() {
        avatar.setOccupation(new Sneak(avatar.getInventory(), avatar.getStats()));
        ImageUtil.initSneak();
        avatar.setAssetID(ImageUtil.inEffect[2]); //set sneak sprite sheet here
    }
}

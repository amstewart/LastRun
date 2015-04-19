package controller.action.charSelectAction;

import controller.action.Action;
import javax.swing.JTextField;
import model.entity.Avatar;

public class AvatarNameAction extends Action {

    private Avatar avatar;
    private String avatarNickName;

    public AvatarNameAction(Avatar avatar, String avatarNickName) {
        this.avatar = avatar;
        this.avatarNickName = avatarNickName;
    }
    
    @Override
    public void perform() {
       avatar.setName(avatarNickName);
    }
}


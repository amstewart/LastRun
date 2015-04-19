package controller.action.charSelectAction;

import model.enums.OcupationCategory;
import controller.action.Action;
import controller.action.stateMachineAction.GoToGameAction;
import model.entity.Avatar;
import model.entity.occupation.Smasher;
import utility.ImageUtil;

public class CreateAvatarAction extends Action {

    private OcupationCategory ocupation;
    private Avatar avatar;
    private Action avatarOcupation;
    private Action nextState;

    public CreateAvatarAction(Avatar avatar, OcupationCategory ocupation) {
        this.avatar = avatar;
        this.ocupation = ocupation;
    }
    
    @Override
    public void perform() {
        switch(ocupation){
            case SUMMONER:
                avatarOcupation = new SelectSummonerAction(avatar);
                avatarOcupation.perform();
                  break;
            case SMASHER:
                avatar.setOccupation(new Smasher(avatar.getInventory(), avatar.getStats()));
                ImageUtil.initSmasher();
                avatar.setAssetID(ImageUtil.inEffect[1]); //set sneak sprite sheet here
                    break;
            default:
                avatarOcupation = new SelectSneakAction(avatar);
                avatarOcupation.perform();
                break;
        }
        
        nextState = new GoToGameAction();
        nextState.perform();
    }
}


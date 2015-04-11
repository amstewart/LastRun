
package model.action;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import model.entity.avatar.Avatar;

/**
 *
 * @author ChrisMoscoso
 */
public class MoveAvatarUp extends Action{
    Avatar avatar;
    
    public MoveAvatarUp(Avatar a){
        avatar = a;
    }
    
    @Override
    public void perform() {
       
    }

    @Override
    public void setActionListener(ActionListener al) {
        
    }

    @Override
    public void setKeyListener(KeyListener kl) {
        
    }

    @Override
    public ActionListener getActionListener() {
        return null;
    }

    @Override
    public KeyListener getKeyListener() {
        return null;
    }
    
}

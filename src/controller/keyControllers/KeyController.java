package controller.keyControllers;

import controller.action.Action;
import controller.action.mapAction.ZoomInMapAction;
import controller.action.mapAction.ZoomOutMapAction;
import controller.action.moveAvatarAction.MoveDownAction;
import controller.action.moveAvatarAction.MoveDownLeftAction;
import controller.action.moveAvatarAction.MoveDownRightAction;
import controller.action.moveAvatarAction.MoveUpAction;
import controller.action.moveAvatarAction.MoveUpLeftAction;
import controller.action.moveAvatarAction.MoveUpRightAction;
import controller.action.skillAction.ExternalSkillAction;
import controller.action.skillAction.InternalSkillAction;
import controller.action.skillAction.MountAction;
import controller.action.skillAction.SpellSkillAction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.entity.Avatar;
import model.map.GameMap;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;
import view.viewport.MapViewport;

/**
 *
 * @author ChrisMoscoso
 */
public class KeyController implements KeyListener {

    protected Map<Integer, Action> actionSet = new HashMap();

    public KeyController() {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (Integer keyCode : actionSet.keySet()) {
            if (e.getKeyCode() == keyCode) {
                actionSet.get(keyCode).perform();
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

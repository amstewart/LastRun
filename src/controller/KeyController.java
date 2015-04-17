
package controller;

import controller.action.Action;
import controller.action.moveAvatarAction.MoveDownAction;
import controller.action.moveAvatarAction.MoveDownLeftAction;
import controller.action.moveAvatarAction.MoveDownRightAction;
import controller.action.moveAvatarAction.MoveUpAction;
import controller.action.moveAvatarAction.MoveUpLeftAction;
import controller.action.moveAvatarAction.MoveUpRightAction;
import controller.action.skillAction.InternalSkillAction;

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

/**
 *
 * @author ChrisMoscoso
 */
public class KeyController implements KeyListener{
    
    Map<Integer, Action> actionSet;
    Map<Integer, Integer> skillSet;
    int skillNumber = 0;

    public KeyController(GameMap map, Avatar avatar){
        actionSet = new HashMap();
        skillSet = new HashMap();
        skillSet.put(0, KeyEvent.VK_1);
        
        actionSet.put(KeyEvent.VK_W, new MoveUpAction(map));
        actionSet.put(KeyEvent.VK_E, new MoveUpRightAction(map));
        actionSet.put(KeyEvent.VK_Q, new MoveUpLeftAction(map));
        actionSet.put(KeyEvent.VK_A, new MoveDownLeftAction(map));
        actionSet.put(KeyEvent.VK_S, new MoveDownAction(map));
        actionSet.put(KeyEvent.VK_D, new MoveDownRightAction(map));
        
       ArrayList <ExternalSkill> eSkills = new ArrayList();
       ArrayList <InternalSkill> iSkills = new ArrayList();
       ArrayList <SpellSkill> sSkills = new ArrayList();
       avatar.sortSkills(eSkills,iSkills,sSkills);
       for(InternalSkill i: iSkills){
    	   if(i != null && !i.isPassive()){
	    	   actionSet.put(skillSet.get(skillNumber), new InternalSkillAction(avatar,i));
	    	   ++skillNumber;
    	   }
       }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        for(Integer keyCode : actionSet.keySet()){
            if(e.getKeyCode() == keyCode){
                actionSet.get(keyCode).perform();
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    
}

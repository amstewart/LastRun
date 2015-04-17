package view.viewport;

import controller.action.Action;
import controller.action.skillAction.AllocateSkillPtAction;
import model.entity.occupation.Occupation;
import model.skill.Skill;
import model.skillset.BasicSkills;
import model.skillset.SkillPtAllocator;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class SkillPtAllocationViewport extends Viewport {
    // TODO: get allotable skill points from game bundle

    private AllocateSkillPtAction allocateSkillPtAction;

    public SkillPtAllocationViewport(BasicSkills basicSkills) {
        basicSkills.registerView(this);
        allocateSkillPtAction = new AllocateSkillPtAction(basicSkills);

        receiveSkillInfo(basicSkills.getSkills(), basicSkills.getSkillPoints());
    }
    
    public void updateOccupation(BasicSkills bs){
    	 bs.registerView(this);
         allocateSkillPtAction = new AllocateSkillPtAction(bs);

         receiveSkillInfo(bs.getSkills(), bs.getSkillPoints());
    }

    public void receiveSkillInfo(Skill[] skills, int skillPoints) {
        this.removeAll();
        this.add(new JLabel("Skill Point Allocation"));
        ActionListener actionListener = Action.getActionListener(allocateSkillPtAction);

        for(Skill s: skills){
        	if(s != null){
	            SkillIncrementButton button = new SkillIncrementButton(s);
	            button.addActionListener(actionListener);
	            add(button);
        	}
        }
      

        this.add(new JLabel(String.valueOf(skillPoints)));
    }



    @Override
    public void render() {

    }


    public class SkillIncrementButton extends JButton {
        private Skill skill;

        public SkillIncrementButton(Skill skill) {
            super(skill.getName());
            this.skill = skill;
            this.addMouseListener(new PointAllocationListener());
        }

        public Skill getSkill() {
            return skill;
        }
    }

    private class PointAllocationListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            try {
                Skill skill = ((SkillIncrementButton) e.getSource()).getSkill();
                allocateSkillPtAction.setSkill(skill);
            } catch (Exception exception) {
                // Horrible to catch a generic exception but oh well
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

	
}

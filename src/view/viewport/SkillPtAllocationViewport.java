package view.viewport;

import controller2.action.Action2;
import controller2.action.action.skillPtAction.AllocateSkillPtAction;
import model.action.Action;
import model.skill.Skill;
import model.skillset.SkillPtAllocator;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class SkillPtAllocationViewport extends Viewport {
    // TODO: get allotable skill points from game bundle

    private AllocateSkillPtAction allocateSkillPtAction;

    public SkillPtAllocationViewport(SkillPtAllocator skillPtAllocator) {
        skillPtAllocator.registerView(this);
        receiveSkills(skillPtAllocator.getSkills());

        allocateSkillPtAction = new AllocateSkillPtAction(skillPtAllocator);

    }

    public void receiveSkills(Skill[] skills) {
        this.removeAll();
        ActionListener actionListener = Action2.getActionListener(allocateSkillPtAction);
        for(int i = 0; i < skills.length; i++) {
            SkillIncrementButton button = new SkillIncrementButton(skills[i]);
            button.addActionListener(actionListener);
            add(button);
        }
    }

    public void receiveSkillPoints(int skillpoints) {
        // TODO:
    }

    @Override
    public void render() {

    }

    @Override
    public void setListeners(ArrayList<Action> a) {

    }

    public class SkillIncrementButton extends JButton {
        private Skill skill;

        public SkillIncrementButton(Skill skill) {

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

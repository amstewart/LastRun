/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;
import controller.action.Action;
import controller.action.skillAction.AllocateSkillPtAction;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import model.skill.Skill;
import model.skillset.BasicSkills;
import utility.ImageUtil;

/**
 *
 * @author Carlos
 */
public class SkillsViewport extends Viewport {

    /**
     * Creates new form SKillsViewport
     */
    private AllocateSkillPtAction allocateSkillPtAction;
    
    public SkillsViewport(BasicSkills basicSkills) {
        
        initComponents();
        basicSkills.registerView(this);
        allocateSkillPtAction = new AllocateSkillPtAction(basicSkills);
        receiveSkillInfo(basicSkills.getSkills(), basicSkills.getSkillPoints());
       
    }
    
    @Override
    public void paintComponent(Graphics g){
    
        super.paintComponent(g);
        
    }
    
    private void addSkillToPanel(String imagePath, String skillName, ActionListener al){
        
       
       if ( buttonsPanel.getHeight() > 0 ){
       
        JButton button = new JButton();
        button.setSize(50, buttonsPanel.getHeight());
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false); 
        buttonsPanel.add(button);
        
        JLabel label = new JLabel();
        label.setFont(new java.awt.Font("Yu Mincho", 3, 18)); // NOI18N
        label.setForeground(new java.awt.Color(240, 240, 240));
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setSize(label.getWidth(), labelsPanel.getHeight());
        label.setText(skillName);
        
        button.addActionListener(al);
        labelsPanel.add(label);
       
       
       }
    }
    
    private void paintButton(JButton button, String imagePathName){
        
        Image image = ImageUtil.getImage(ImageUtil.MAIN_MENU_EXIT_BUTTON, 50, buttonsPanel.getHeight()*2/3).getImage();
        ImageIcon imageIcon = new ImageIcon(image);
        button.setIcon( imageIcon );
        //button.getGraphics().drawImage(image, button.getWidth()/2 - image.getWidth(buttonsPanel)/2, button.getHeight()/6, button);
    }
    
    public void updateOccupation(BasicSkills bs){
    	 bs.registerView(this);
         allocateSkillPtAction = new AllocateSkillPtAction(bs);

         receiveSkillInfo(bs.getSkills(), bs.getSkillPoints());
    }
    
    public void receiveSkillInfo(Skill[] skills, int skillPoints) {
        
        buttonsPanel.removeAll();
        labelsPanel.removeAll();
        ArrayList<String> skillsImagePath = new ArrayList<String>();
        
        ActionListener actionListener = Action.getActionListener(allocateSkillPtAction);

        for(Skill s: skills){
        	
            if(s != null){
               
                addSkillToPanel(s.getName(), s.getName(), actionListener );
            }
        }
        
        for(Component s : buttonsPanel.getComponents() ){
            
            JButton tempButton = (JButton)s;
            //System.out.println("Button Size: " + tempButton.getSize());
            paintButton(tempButton,"a");
        }
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
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonsPanel = new javax.swing.JPanel();
        labelsPanel = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 0, 0));
        setOpaque(false);

        buttonsPanel.setOpaque(false);
        buttonsPanel.setLayout(new java.awt.GridLayout());

        labelsPanel.setOpaque(false);
        labelsPanel.setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel labelsPanel;
    // End of variables declaration//GEN-END:variables

}

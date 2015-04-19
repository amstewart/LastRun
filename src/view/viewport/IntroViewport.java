/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;

import controller.action.Action;
import controller.action.stateMachineAction.GoBackAction;
import controller.action.stateMachineAction.GoToGameAction;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JButton;
import model.entity.occupation.Occupation;
import utility.ImageUtil;

public class IntroViewport extends Viewport {

    Occupation occupation;
    Queue<String> queue = new LinkedList<String>();
    
    public IntroViewport(Occupation occupation) {
        this.occupation = occupation;
        initComponents();
        addActionListeners();
        setButtonTransparent(goToCharacterSelectionButton);
        setButtonTransparent(goToGame);
        setStorieToList();
    }
    
     @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
         
         Image image = ImageUtil.getImage(ImageUtil.INTRO_BACKGROUND, this.getWidth(), this.getHeight()).getImage();
         g.drawImage(image, 0, 0, this);
    }
    
    private void addActionListeners(){
        goToCharacterSelectionButton.addActionListener(Action.getActionListener(new GoBackAction()));
        goToGame.addActionListener(continueButtonAction);
    }
    
    private void setButtonTransparent(JButton button){
        
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }
    
    private void setStorieToList(){
        
        queue.add("Phase 1");
        queue.add("Phase 2");
        queue.add("Phase 3");
    }
    
    private ActionListener continueButtonAction = new ActionListener(){
    
        @Override
        public void actionPerformed(ActionEvent e){
            
            String storyLine = queue.poll();
            if (storyLine == null){
                
                Action action = new GoToGameAction();
                action.perform();
            }
            else {
                
                storyLineLabel.setText(storyLine);
            }
        }
    };

    private void initComponents() {

        goToCharacterSelectionButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        goToGame = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        storyLineLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 0, 255));

        goToCharacterSelectionButton.setFont(new java.awt.Font("Yu Mincho", 3, 36)); // NOI18N
        goToCharacterSelectionButton.setForeground(new java.awt.Color(240, 240, 240));
        goToCharacterSelectionButton.setText("Back");
        goToCharacterSelectionButton.setMaximumSize(new java.awt.Dimension(100, 100));
        goToCharacterSelectionButton.setMinimumSize(new java.awt.Dimension(59, 60));

        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 400));
        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        goToGame.setFont(new java.awt.Font("Yu Mincho", 3, 36)); // NOI18N
        goToGame.setForeground(new java.awt.Color(240, 240, 240));
        goToGame.setText("Continue");
        goToGame.setMaximumSize(new java.awt.Dimension(100, 60));

        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jPanel3.setOpaque(false);

        storyLineLabel.setFont(new java.awt.Font("Yu Mincho", 3, 36)); // NOI18N
        storyLineLabel.setForeground(new java.awt.Color(240, 240, 240));
        storyLineLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        storyLineLabel.setText("WELCOME");
        storyLineLabel.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(storyLineLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 36, Short.MAX_VALUE)
                .addComponent(storyLineLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(goToCharacterSelectionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                        .addGap(205, 205, 205)
                        .addComponent(goToGame, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(goToCharacterSelectionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(goToGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }

    private javax.swing.JButton goToCharacterSelectionButton;
    private javax.swing.JButton goToGame;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel storyLineLabel;

    @Override
    public void render() {
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;


import model.enums.OcupationCategory;
import utility.DoubleLinkedList;
import controller.action.Action;
import controller.action.charSelectAction.SelectSmasherAction;
import controller.action.charSelectAction.SelectSneakAction;
import controller.action.charSelectAction.SelectSummonerAction;
import controller.action.stateMachineAction.GoBackAction;
import controller.action.stateMachineAction.GoToGameAction;
import controller.action.stateMachineAction.GoToIntroAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.entity.Avatar;
import utility.ImageUtil;
import utility.StringUtilEnum;

public class CharacterSelectionViewport extends Viewport {

    /***
     * Creates new form MenuViewport
     */
    Avatar avatar;
    
    private String SUMMONER_DESCRIPTION = StringUtilEnum.SUMMONER_DESCRIPTION.getDescription();
    private String SMASHER_DESCRIPTION = StringUtilEnum.SMASHER_DESCRIPTION.getDescription();
    private String SNEAK_DESCRIPTION = StringUtilEnum.SNEAK_DESCRIPTION.getDescription();
    DoubleLinkedList<OcupationCategory> ocupationList = new DoubleLinkedList();
    
    public CharacterSelectionViewport(Avatar avatar) {
        
        this.avatar = avatar;
        backgroundImage = new ImageIcon(ImageUtil.CHARACTER_SELECTION_BACKGROUND);
        initComponents();
        addAvatarOcupations();
        addActionListeners(avatar);
        
    }
    
    public JButton getStartGameButton(){
        return startGameButton;
    }
    
    public JButton getCharacterButton(){
        return mainMenuButton;
    }
    
    private void addAvatarOcupations(){
        
        ocupationList.add(OcupationCategory.SMASHER);
        ocupationList.add(OcupationCategory.SNEAK);
        ocupationList.add(OcupationCategory.SUMMONER);
    }

    @Override
    public void render() {
        this.revalidate();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
         g.drawImage(backgroundImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
    
    private void paintAvatarOcupation(JPanel panel, Graphics g){
        
        ImageIcon leftImage = getImageFromList(ocupationList.getNextData());
        ImageIcon rightImage = getImageFromList(ocupationList.getPreviousData());
        ImageIcon centerImage = getImageFromList(ocupationList.getData());
      
        centerImage = ImageUtil.rescaleImage(centerImage, panel.getWidth() / 6, panel.getHeight());
        leftImage = ImageUtil.rescaleImage(leftImage, panel.getWidth() / 12, panel.getHeight() / 2);
        rightImage = ImageUtil.rescaleImage(rightImage, panel.getWidth() / 12, panel.getHeight() / 2);
        
        g.drawImage( centerImage.getImage() , panel.getWidth()/2 - centerImage.getImage().getWidth(panel)/2, 0, panel);
        
        g.drawImage( leftImage.getImage() , panel.getWidth()/3 - centerImage.getImage().getWidth(panel)/2, 0, panel);
        g.drawImage( rightImage.getImage() , panel.getWidth()*2/3, 0, panel);
        
        this.updateUI();
    }
    
    public ImageIcon getImageFromList(OcupationCategory ocupation){
        
        Action action;
         if (avatar == null) System.out.println("0000000000000000000000000000000000000000000000000000");
        ImageIcon image;
        switch (ocupation){
        
            case SMASHER:
                image = ImageUtil.getImage(ImageUtil.CHARACTER_SELECTION_SMASHER);
                avatarOcuppationNameLabel.setText("Smasher");
                avatarDescriptionTextArea.setText(SMASHER_DESCRIPTION);
                action = new SelectSmasherAction(avatar);
                break;
            case SUMMONER:
                image = ImageUtil.getImage(ImageUtil.CHARACTER_SELECTION_SUMMONER);
                avatarOcuppationNameLabel.setText("Summoner");
                avatarDescriptionTextArea.setText(SUMMONER_DESCRIPTION);
                action = new SelectSummonerAction(avatar);
                break;
            default:
                image = ImageUtil.getImage(ImageUtil.CHARACTER_SELECTION_SNEAK);
                avatarOcuppationNameLabel.setText("Sneak");
                avatarDescriptionTextArea.setText(SNEAK_DESCRIPTION);
                action = new SelectSneakAction(avatar);
                break;
        }
        action.perform();
        return image;
    }
    
    private final MouseListener changeOcupationAction = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {
            
            Point location  = e.getLocationOnScreen();
            Point panelLocation = ocupationPanel.getLocation();
            
            // 1/3 Left of the panel
            if ( location.x <= ocupationPanel.getWidth()/3+panelLocation.x ){
                
                ocupationList.previous();
                ocupationPanel.repaint();
            }
            // 1/3 to the right
            else if (location.x >= ocupationPanel.getWidth()*2/3+panelLocation.x ){
                
                ocupationList.next();
                ocupationPanel.repaint();
            }
            
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
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
    };
    
    private void addActionListeners(Avatar avatar){
        mainMenuButton.addActionListener(Action.getActionListener(new GoBackAction()));
        startGameButton.addActionListener(Action.getActionListener(new GoToGameAction()));
        ocupationPanel.addMouseListener(changeOcupationAction);
        
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {
        startGameButton = new JButton(){

            @Override
            public void paintComponent(Graphics g){
                Image image = ImageUtil.getImage(ImageUtil.CHARACTER_SELECTION_NEW_GAME_BUTTON, this.getWidth(), this.getHeight()).getImage();
                g.drawImage( image , 0, 0, this);
            }
        };
        mainMenuButton = new JButton(){

            @Override
            public void paintComponent(Graphics g){
                Image image = ImageUtil.getImage(ImageUtil.CHARACTER_SELECTION_MENU_BUTTON, this.getWidth(), this.getHeight()).getImage();
                g.drawImage( image , 0, 0, this);
            }
        };
        jPanel1 = new JPanel();
        ocupationPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g){

                this.removeAll();
                paintAvatarOcupation(this,g);
                //this.updateUI();
            }
        };
        jScrollPane1 = new javax.swing.JScrollPane();
        avatarDescriptionTextArea = new javax.swing.JTextArea();
        avatarOcuppationNameLabel = new JLabel();
        jPanel3 = new JPanel();
        jPanel5 = new JPanel();
        jPanel2 = new JPanel(){

            @Override
            public void paintComponent(Graphics g){
                Image image = ImageUtil.getImage(ImageUtil.CHARACTER_SELECTION_PET, this.getWidth() / 6, this.getHeight()).getImage();
                g.drawImage( image , this.getWidth()/2 - image.getWidth(this)/2, 0, this);
            }
        };
        jPanel4 = new JPanel();
        avatarNickNameLabel = new JLabel();
        avatarNickNameTextField = new javax.swing.JTextField();
        setBackground(new Color(202, 175, 149));

        startGameButton.setText("Start Game");
        startGameButton.setPreferredSize(new java.awt.Dimension(148, 65));

        mainMenuButton.setText("Menu");
        mainMenuButton.setPreferredSize(new java.awt.Dimension(148, 65));

        jPanel1.setBackground(new Color(255, 0, 0));
        jPanel1.setOpaque(false);

        ocupationPanel.setBackground(new Color(0, 0, 204));

        javax.swing.GroupLayout ocupationPanelLayout = new javax.swing.GroupLayout(ocupationPanel);
        ocupationPanel.setLayout(ocupationPanelLayout);
        ocupationPanelLayout.setHorizontalGroup(
            ocupationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 711, Short.MAX_VALUE)
        );
        ocupationPanelLayout.setVerticalGroup(
            ocupationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 103, Short.MAX_VALUE)
        );

        jScrollPane1.setBackground(new Color(0, 0, 0));
        jScrollPane1.setOpaque(false);

        avatarDescriptionTextArea.setBackground(new Color(0, 51, 51));
        avatarDescriptionTextArea.setColumns(20);
        avatarDescriptionTextArea.setForeground(new Color(255, 255, 255));
        avatarDescriptionTextArea.setRows(5);
        avatarDescriptionTextArea.setText("\tAvatar description goes here");
        avatarDescriptionTextArea.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 3, new Color(163, 43, 43)));
        avatarDescriptionTextArea.setMargin(new java.awt.Insets(0, 0, 0, 0));
        avatarDescriptionTextArea.setMaximumSize(new java.awt.Dimension(853, 2147483647));
        jScrollPane1.setViewportView(avatarDescriptionTextArea);

        avatarOcuppationNameLabel.setFont(new java.awt.Font("Yu Mincho", 3, 36)); // NOI18N
        avatarOcuppationNameLabel.setForeground(new Color(128,0,0));
        avatarOcuppationNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        avatarOcuppationNameLabel.setText("Hello");

        jPanel3.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.setOpaque(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ocupationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(avatarOcuppationNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(63, 63, 63))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ocupationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(avatarOcuppationNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jPanel4.setMaximumSize(new java.awt.Dimension(200, 32767));
        jPanel4.setOpaque(false);

        avatarNickNameLabel.setFont(new java.awt.Font("Yu Mincho", 2, 36)); // NOI18N
        avatarNickNameLabel.setForeground(new Color(240, 240, 240));
        avatarNickNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        avatarNickNameLabel.setText("Nickname:");

        avatarNickNameTextField.setFont(new java.awt.Font("Yu Mincho", 3, 36)); // NOI18N
        avatarNickNameTextField.setForeground(new Color(255, 255, 255));
        avatarNickNameTextField.setText("Tubby Lumpkins");
        avatarNickNameTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 3, new Color(163, 43, 43)));
        avatarNickNameTextField.setOpaque(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(avatarNickNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(avatarNickNameTextField)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(avatarNickNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avatarNickNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(78, 78, 78))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(mainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(startGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(mainMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                        .addComponent(startGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }//

    private javax.swing.JTextArea avatarDescriptionTextArea;
    private JLabel avatarNickNameLabel;
    private javax.swing.JTextField avatarNickNameTextField;
    private JLabel avatarOcuppationNameLabel;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private JButton mainMenuButton;
    private JPanel ocupationPanel;
    private JButton startGameButton;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;


import LastRun.src.controller.action.charSelectAction.CreateAvatarAction;
import LastRun.src.model.enums.OcupationCategory;
import LastRun.src.utility.DoubleLinkedList;
import controller.action.Action;
import controller.action.stateMachineAction.GoBackAction;
import controller.action.stateMachineAction.GoToGameAction;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.entity.Avatar;
import utility.ImageUtil;

public class CharacterSelectionViewport extends Viewport {

    /***
     * Creates new form MenuViewport
     */
    Avatar avatar;
    private String SUMMONER_DESCRIPTION = "Summmoner is the best";
    private String SMASHER_DESCRIPTION = "Smasher is the best";
    private String SNEAK_DESCRIPTION = "Sneak is the best";
    
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CharacterSelectionViewport petSelectionView = new CharacterSelectionViewport(new Avatar());
        frame.add(petSelectionView);
        frame.setVisible(true);

    }
    
    DoubleLinkedList<OcupationCategory> ocupationList = new DoubleLinkedList();
    
    public CharacterSelectionViewport(Avatar avatar) {
        
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
        
        Image leftImage = getImageFromList(ocupationList.getNextData());
        Image rightImage = getImageFromList(ocupationList.getPreviousData());
        Image centerImage = getImageFromList(ocupationList.getData());
      
        centerImage = ImageUtil.rescaleImage( new ImageIcon(centerImage), panel.getWidth()/6, panel.getHeight() ).getImage();
        leftImage = ImageUtil.rescaleImage( new ImageIcon(leftImage), panel.getWidth()/12, panel.getHeight()/2 ).getImage();
        rightImage = ImageUtil.rescaleImage( new ImageIcon(rightImage), panel.getWidth()/12, panel.getHeight()/2 ).getImage();
        
        g.drawImage( centerImage , panel.getWidth()/2 - centerImage.getWidth(panel)/2, 0, panel);
        
        g.drawImage( leftImage , panel.getWidth()/3 - centerImage.getWidth(panel)/2, 0, panel);
        g.drawImage( rightImage , panel.getWidth()*2/3, 0, panel);
        
        this.updateUI();
    }
    
    public Image getImageFromList(OcupationCategory ocupation){
        
        Image image;
        switch (ocupation){
        
            case SMASHER:
                image = ImageUtil.getImage( ImageUtil.CHARACTER_SELECTION_SMASHER).getImage();
                avatarOcuppationNameLabel.setText("Smasher");
                avatarDescriptionTextArea.setText(SMASHER_DESCRIPTION);
                break;
            case SUMMONER:
                image = ImageUtil.getImage( ImageUtil.CHARACTER_SELECTION_SUMMONER).getImage();
                avatarOcuppationNameLabel.setText("Summoner");
                avatarDescriptionTextArea.setText(SUMMONER_DESCRIPTION);
                break;
            default:
                image = ImageUtil.getImage( ImageUtil.CHARACTER_SELECTION_SNEAK).getImage();
                avatarOcuppationNameLabel.setText("Sneak");
                avatarDescriptionTextArea.setText(SNEAK_DESCRIPTION);
                break;
        }
        
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
        startGameButton.addActionListener(Action.getActionListener(new CreateAvatarAction(avatar,ocupationList.getData()) ));
        ocupationPanel.addMouseListener(changeOcupationAction);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        startGameButton = new javax.swing.JButton(){

            @Override
            public void paintComponent(Graphics g){
                Image image = ImageUtil.getImage( ImageUtil.CHARACTER_SELECTION_NEW_GAME_BUTTON,this.getWidth(), this.getHeight()).getImage();
                g.drawImage( image , 0, 0, this);
            }
        };
        mainMenuButton = new javax.swing.JButton(){

            @Override
            public void paintComponent(Graphics g){
                Image image = ImageUtil.getImage( ImageUtil.CHARACTER_SELECTION_MENU_BUTTON, this.getWidth(), this.getHeight()).getImage();
                g.drawImage( image , 0, 0, this);
            }
        };
        jPanel1 = new javax.swing.JPanel();
        ocupationPanel = new javax.swing.JPanel() {
            @Override
            public void paintComponent(Graphics g){

                this.removeAll();
                paintAvatarOcupation(this,g);
                //this.updateUI();
            }
        };
        jScrollPane1 = new javax.swing.JScrollPane();
        avatarDescriptionTextArea = new javax.swing.JTextArea();
        avatarOcuppationNameLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel(){

            @Override
            public void paintComponent(Graphics g){
                Image image = ImageUtil.getImage( ImageUtil.CHARACTER_SELECTION_PET,this.getWidth()/6,this.getHeight()).getImage();
                g.drawImage( image , this.getWidth()/2 - image.getWidth(this)/2, 0, this);
            }
        };
        jPanel4 = new javax.swing.JPanel();
        avatarNickNameLabel = new javax.swing.JLabel();
        avatarNickNameTextField = new javax.swing.JTextField(); 
        setBackground(new java.awt.Color(202, 175, 149));

        startGameButton.setText("Start Game");
        startGameButton.setPreferredSize(new java.awt.Dimension(148, 65));

        mainMenuButton.setText("Menu");
        mainMenuButton.setPreferredSize(new java.awt.Dimension(148, 65));

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setOpaque(false);

        ocupationPanel.setBackground(new java.awt.Color(0, 0, 204));

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

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setOpaque(false);

        avatarDescriptionTextArea.setBackground(new java.awt.Color(0, 51, 51));
        avatarDescriptionTextArea.setColumns(20);
        avatarDescriptionTextArea.setForeground(new java.awt.Color(255, 255, 255));
        avatarDescriptionTextArea.setRows(5);
        avatarDescriptionTextArea.setText("\tAvatar description goes here");
        avatarDescriptionTextArea.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 3, new java.awt.Color(163, 43, 43)));
        avatarDescriptionTextArea.setMargin(new java.awt.Insets(0, 0, 0, 0));
        avatarDescriptionTextArea.setMaximumSize(new java.awt.Dimension(853, 2147483647));
        jScrollPane1.setViewportView(avatarDescriptionTextArea);

        avatarOcuppationNameLabel.setFont(new java.awt.Font("Yu Mincho", 1, 18)); // NOI18N
        avatarOcuppationNameLabel.setForeground(new java.awt.Color(240, 240, 240));
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
        avatarNickNameLabel.setForeground(new java.awt.Color(240, 240, 240));
        avatarNickNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        avatarNickNameLabel.setText("Nickname:");

        avatarNickNameTextField.setFont(new java.awt.Font("Yu Mincho", 3, 36)); // NOI18N
        avatarNickNameTextField.setForeground(new java.awt.Color(255, 255, 255));
        avatarNickNameTextField.setText("Marie");
        avatarNickNameTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 3, new java.awt.Color(163, 43, 43)));
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
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea avatarDescriptionTextArea;
    private javax.swing.JLabel avatarNickNameLabel;
    private javax.swing.JTextField avatarNickNameTextField;
    private javax.swing.JLabel avatarOcuppationNameLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mainMenuButton;
    private javax.swing.JPanel ocupationPanel;
    private javax.swing.JButton startGameButton;
    // End of variables declaration//GEN-END:variables

}

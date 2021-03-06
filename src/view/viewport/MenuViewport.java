/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;

import controller.action.Action;
import controller.action.stateMachineAction.GoToCharSelectAction;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import utility.Audio;
import utility.ImageUtil;


public class MenuViewport extends Viewport {

    public MenuViewport() {
        backgroundImage = new ImageIcon(ImageUtil.MAIN_MENU_BACKGROUND);
        initComponents();
        setButtonBackgroundTransparent(newGameButton);
        setButtonBackgroundTransparent(exitGameButton);
        setButtonBackgroundTransparent(loadGameButton);
        addActionListeners();
        
    }
    
    private void addActionListeners(){
        
        newGameButton.addActionListener(Action.getActionListener(new GoToCharSelectAction()));
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }

    public void listenButton_Exit(ActionListener listener) {
        this.exitGameButton.addActionListener(listener);
    }

    public void listenButton_LoadGame(ActionListener listener) {
        this.loadGameButton.addActionListener(listener);
    }

    public void listenButton_NewGame(ActionListener listener) {
        this.newGameButton.addActionListener(listener);
    }

    private void initComponents() {

        newGameButton = new javax.swing.JButton(){

            @Override
            public void paintComponent(Graphics g){
                Image image = ImageUtil.getImage( ImageUtil.MAIN_MENU_NEW_GAME_BUTTON).getImage();
                g.drawImage( image , this.getWidth()/2 - image.getWidth(this)/2, 0, this);
            }
        };
        loadGameButton = new javax.swing.JButton(){

            @Override
            public void paintComponent(Graphics g){
                //Image image = ImageUtil.getImage( ImageUtil.MAIN_MENU_LOAD_BUTTON).getImage();
                //g.drawImage( image , this.getWidth()/2 - image.getWidth(this)/2, 0, this);
            }
        };
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        exitGameButton = new javax.swing.JButton(){

            @Override
            public void paintComponent(Graphics g){
                //Image image = ImageUtil.getImage( ImageUtil.MAIN_MENU_EXIT_BUTTON).getImage();
                //ojectsg.drawImage( image , this.getWidth()/2 - image.getWidth(this)/2, 0, this);
            }
        };

        setBackground(new java.awt.Color(226, 124, 21));

        newGameButton.setText("New Game");
        newGameButton.setMaximumSize(new java.awt.Dimension(500, 500));

        loadGameButton.setText("Load Game");
        loadGameButton.setMaximumSize(new java.awt.Dimension(500, 500));

        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        exitGameButton.setText("Exit Game");
        exitGameButton.setMaximumSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(loadGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                        .addGap(11, 11, 11)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(newGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadGameButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }

    public javax.swing.JButton exitGameButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JButton loadGameButton;
    public javax.swing.JButton newGameButton;

    @Override
    public void render() {
        this.revalidate();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import model.entity.Avatar;
import model.entity.occupation.Occupation;
import model.item.Inventory;
import model.stat.Stats;
import utility.ImageUtil;

public class GameViewport extends Viewport {

    private Viewport mapVP;
    private StatsViewport statsVP;
    private InventoryViewport invVP;
    private EquipmentViewport equipVP;
    private SkillsViewport skillsViewport;
    private DialogueViewport dialogueViewport;
    
    public GameViewport(MapViewport mapVP, Inventory inventory, Avatar a) {
        Occupation occupation = a.getOccupation();
        Stats stats = a.getStats();
        initComponents();
        
        backgroundImage = new ImageIcon(ImageUtil.GAME_BACKGROUND);
        statsPanel.setOpaque(false);
        // This create View ports
        this.mapVP = mapVP;
        invVP = new InventoryViewport(inventory, occupation.getEquipmentHandler(), a.getStats(),a);
        inventory.addObserver(invVP);
        a.addObserver(invVP);
        equipVP = new EquipmentViewport(occupation.getEquipmentHandler(), a.getStats(),a);
        a.addObserver(equipVP);
        statsVP = new StatsViewport(stats);
        dialogueViewport = DialogueViewport.getInstance();
        mapVP.setBackground(Color.lightGray);
        statsVP.setBackground(Color.lightGray);
       
        dialogueViewport.setBackground(Color.yellow);
        skillsViewport = new SkillsViewport(occupation.getSkillBook());
        a.addObserver(skillsViewport);

        
        addViewPorts();
    }
    private void addViewPorts(){
    
        gamePanel.setLayout( new BorderLayout() );
        gamePanel.add( mapVP , BorderLayout.CENTER );
        
        inventoryPanel.setLayout( new BorderLayout() );
        inventoryPanel.add( invVP , BorderLayout.CENTER );
        
        
        statsPanel.setLayout( new BorderLayout() );
        statsPanel.add( statsVP , BorderLayout.CENTER );
        
        skillsPanel.setLayout( new BorderLayout() );
        skillsPanel.add( skillsViewport , BorderLayout.CENTER );
        
        dialoguePanel.setLayout( new BorderLayout() );
        dialoguePanel.add( dialogueViewport , BorderLayout.CENTER );
        
        
        
        this.revalidate();
        this.repaint();
    }
    
     @Override
    public void paintComponent(Graphics g){
    
        super.paintComponent(g);
        g.drawImage(backgroundImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
    
    @Override
    public void render() {
        int width = this.getSize().width;
        int height = this.getSize().height;

        mapVP.setPreferredSize(new Dimension((int) (width * 0.40), (int) (height * 0.70)));
        equipVP.setPreferredSize(new Dimension((int) (width * 0.15), (int) (height * 0.70)));
        invVP.setPreferredSize(new Dimension((int) (width * 0.15), (int) (height * 0.70)));
        dialogueViewport.setPreferredSize(new Dimension((int) (width * 0.4), (int) (height * 0.25)));
        statsVP.setPreferredSize(new Dimension((int) (width * 0.15), (int) (height * 0.70)));
        
        revalidate();
        this.repaint();
        mapVP.render();
        statsVP.render();
        invVP.render();;
        skillsViewport.render();
        dialogueViewport.render();
        this.requestFocusInWindow();
    }

    private void initComponents() {

        gamePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        statsPanel = new javax.swing.JPanel();
        inventoryPanel = new javax.swing.JPanel();
        skillsPanel = new javax.swing.JPanel();
        dialoguePanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 102, 102));

        gamePanel.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 0));
        jPanel2.setOpaque(false);

        javax.swing.GroupLayout statsPanelLayout = new javax.swing.GroupLayout(statsPanel);
        statsPanel.setLayout(statsPanelLayout);
        statsPanelLayout.setHorizontalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        statsPanelLayout.setVerticalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
        );

        inventoryPanel.setBackground(new java.awt.Color(51, 0, 51));

        javax.swing.GroupLayout inventoryPanelLayout = new javax.swing.GroupLayout(inventoryPanel);
        inventoryPanel.setLayout(inventoryPanelLayout);
        inventoryPanelLayout.setHorizontalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );
        inventoryPanelLayout.setVerticalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );

        skillsPanel.setOpaque(false);
        skillsPanel.setPreferredSize(new java.awt.Dimension(300, 203));

        javax.swing.GroupLayout skillsPanelLayout = new javax.swing.GroupLayout(skillsPanel);
        skillsPanel.setLayout(skillsPanelLayout);
        skillsPanelLayout.setHorizontalGroup(
            skillsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        skillsPanelLayout.setVerticalGroup(
            skillsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(inventoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(skillsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(statsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inventoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(skillsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout dialoguePanelLayout = new javax.swing.GroupLayout(dialoguePanel);
        dialoguePanel.setLayout(dialoguePanelLayout);
        dialoguePanelLayout.setHorizontalGroup(
            dialoguePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );
        dialoguePanelLayout.setVerticalGroup(
            dialoguePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dialoguePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dialoguePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    private javax.swing.JPanel dialoguePanel;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JPanel inventoryPanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel skillsPanel;
    private javax.swing.JPanel statsPanel;
}

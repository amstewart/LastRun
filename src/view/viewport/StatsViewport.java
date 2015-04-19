/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.enums.StatsCategory;
import model.stat.Stats;
import utility.ImageUtil;

/**
 *
 * @author Carlos
 */
public class StatsViewport extends Viewport {

    /**
     * Creates new form StatsViewport
     */
    ArrayList<String> stats = new ArrayList<>();
    ArrayList<StatsItemViewPanel> statsViews = new ArrayList<>();
    
    public StatsViewport(Stats stats) {
        initComponents();
        setButtonBackgroundToTranparent(lifeButton);
        setButtonBackgroundToTranparent(livesLeftButton);
        setButtonBackgroundToTranparent(manaButton);
        
        createPanels();
         try{
            stats.registerView(this);
         }
         catch(ConcurrentModificationException ex){}    
    }
    
    @Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawStats(g);
                Image image = ImageUtil.getImage(ImageUtil.STATS_BACKGROUND).getImage();
                g.drawImage(image ,0,0, this);
                
    }
    
    private void drawStats(Graphics g) {
	
    }
    
    public void receive(ArrayList<Integer> stats, ArrayList<StatsCategory> categories) {
        
        for ( int i = 0; i < stats.size(); i++){
          
            
            switch(categories.get(i)){
            
                case LIVES_LEFT:
                    livesLeftProgressBar.setValue(stats.get(i));
                    break;
                case MANA:
                    manaProgressBar.setValue(stats.get(i));
                    break;
                case LIFE:
                    lifeProgressBar.setValue(stats.get(i));
                    break;
                default:
                    statsViews.get(i).setItemNumber( stats.get(i) );
                    break;
            }
        }
     }
    

    
    public void addPanel(JPanel panel){
    
        nonProgressBarPanel.add(panel);
    }
    
    public void createPanels(){
        
        Image image = ImageUtil.getImage(ImageUtil.STATS_STRENGTH_DECAL, 24,24).getImage();
         StatsItemViewPanel strengthView = new StatsItemViewPanel();
         addPanel(strengthView);
         statsViews.add(strengthView);
         statsViews.get(0).drawItem( image);
         
         StatsItemViewPanel agilityView = new StatsItemViewPanel();
         addPanel(agilityView);
         statsViews.add(agilityView);
         statsViews.get(1).drawItem(image = ImageUtil.getImage(ImageUtil.STATS_AGILITY_DECAL, 30,30).getImage());
         
         StatsItemViewPanel intellectView = new StatsItemViewPanel();
         addPanel(intellectView);
         statsViews.add(intellectView);
         statsViews.get(2).drawItem(image = ImageUtil.getImage(ImageUtil.STATS_INTELLECT_DECAL, 30,30).getImage());
         
         StatsItemViewPanel hardinessView = new StatsItemViewPanel();
         addPanel(hardinessView);
         statsViews.add(hardinessView);
         statsViews.get(3).drawItem(image = ImageUtil.getImage(ImageUtil.STATS_HARDINESS_DECAL, 30,30).getImage());
         
         StatsItemViewPanel experienceView = new StatsItemViewPanel();
         addPanel(experienceView);
         statsViews.add(experienceView);
         statsViews.get(4).drawItem(image = ImageUtil.getImage(ImageUtil.STATS_EXPERIENCE_DECAL, 30,30).getImage());;
         
         StatsItemViewPanel movementView = new StatsItemViewPanel();
         addPanel(movementView);
         statsViews.add(movementView);
         statsViews.get(5).drawItem(image = ImageUtil.getImage(ImageUtil.STATS_MOVEMENT_DECAL, 30,30).getImage());
         
         StatsItemViewPanel equippedArmorView = new StatsItemViewPanel();
         addPanel(equippedArmorView);
         statsViews.add(equippedArmorView);
         statsViews.get(6).drawItem(image = ImageUtil.getImage(ImageUtil.STATS_EQUIPPED_WEAPON_DECAL, 30,30).getImage());
         
         StatsItemViewPanel equippedWeaponView = new StatsItemViewPanel();
         addPanel(equippedWeaponView);
         statsViews.add(equippedWeaponView);
         statsViews.get(7).drawItem(image = ImageUtil.getImage(ImageUtil.STATS_EQUIPPED_WEAPON_DECAL, 30,30).getImage());
         
         StatsItemViewPanel levelView = new StatsItemViewPanel();
         addPanel(levelView);
         statsViews.add(levelView);
         statsViews.get(8).drawItem(image = ImageUtil.getImage(ImageUtil.STATS_LEVEL_DECAL, 30,30).getImage());
         
         StatsItemViewPanel offensiveRatingView = new StatsItemViewPanel();
         addPanel(offensiveRatingView);
         statsViews.add(offensiveRatingView);
         statsViews.get(9).drawItem(image = ImageUtil.getImage(ImageUtil.STATS_OFFESIVE_RATING_DECAL, 30,30).getImage());
         
         StatsItemViewPanel defensiveRatingView = new StatsItemViewPanel();
         addPanel(defensiveRatingView);
         statsViews.add(defensiveRatingView);
         statsViews.get(10).drawItem(image = ImageUtil.getImage(ImageUtil.STATS_DEFENSIVE_RATING_DECAL, 30,30).getImage());
         
         StatsItemViewPanel armorRatingView = new StatsItemViewPanel();
         addPanel(armorRatingView);
         statsViews.add(armorRatingView);
         statsViews.get(11).drawItem(image = ImageUtil.getImage(ImageUtil.STATS_ARMOR_RATING_DECAL, 30,30).getImage());
         
         livesLeftButton.setIcon( ImageUtil.getImage(ImageUtil.STATS_LIVES_LEFT_DECAL, 30,30) );
         manaButton.setIcon( ImageUtil.getImage(ImageUtil.STATS_MANA_DECAL, 30,30));
         lifeButton.setIcon( ImageUtil.getImage(ImageUtil.STATS_LIFE_DECAL, 30,30));
                 
    }
    
    public void setButtonBackgroundToTranparent(JButton button ){
        
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }
    
    @Override
	public void render() {
	
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
        livesLeftButton = new javax.swing.JButton();
        livesLeftProgressBar = new javax.swing.JProgressBar();
        lifeButton = new javax.swing.JButton();
        lifeProgressBar = new javax.swing.JProgressBar();
        manaButton = new javax.swing.JButton();
        manaProgressBar = new javax.swing.JProgressBar();
        nonProgressBarPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 0, 51));

        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(manaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(lifeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(livesLeftButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(livesLeftProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lifeProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                    .addComponent(manaProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(livesLeftButton, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(livesLeftProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lifeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lifeProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manaProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        nonProgressBarPanel.setOpaque(false);
        nonProgressBarPanel.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nonProgressBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nonProgressBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton lifeButton;
    private javax.swing.JProgressBar lifeProgressBar;
    private javax.swing.JButton livesLeftButton;
    private javax.swing.JProgressBar livesLeftProgressBar;
    private javax.swing.JButton manaButton;
    private javax.swing.JProgressBar manaProgressBar;
    private javax.swing.JPanel nonProgressBarPanel;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;

<<<<<<< Updated upstream
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import utility.ImageUtil;
=======
import state.Action;

import java.util.ArrayList;
>>>>>>> Stashed changes

public class MenuViewport extends Viewport {

    /**
     * Creates new form MenuViewport
     */
    public MenuViewport() {
        initComponents();
    }
    
    @Override 
     public void paintComponent(Graphics g)
     { 
         super.paintComponent(g);
         Image image = ImageUtil.getImage(ImageUtil.MAIN_MENU_BACKGROUND).getImage();
         g.drawImage(image, 0,0 , this);
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        continueButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(226, 124, 21));

        continueButton.setText("Continue");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(162, Short.MAX_VALUE)
                .addComponent(continueButton)
                .addGap(162, 162, 162))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .addComponent(continueButton)
                .addGap(99, 99, 99))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton continueButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void render() {
        this.revalidate();
    }

    public void setListeners(ArrayList<Action> a){
        continueButton.addActionListener(a.get(0).getActionListener());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;

import model.action.Action;

import javax.swing.JButton;
import java.util.ArrayList;

/**
 *
 * @author darien
 */
public class CharacterSelectionViewport extends Viewport {

    /**
     * Creates new form NewGameViewport
     */
    public CharacterSelectionViewport() {
        initComponents();
    }
    
    public JButton getGoToPetSelectionButton(){
        
        return petSelectionButton;
    }
    
    public JButton getGoToMenuButton(){
        
        return backButton;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        petSelectionButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(125, 246, 34));

        backButton.setText("Back");

        petSelectionButton.setText("Go To Pet Selection");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(petSelectionButton, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(258, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(petSelectionButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton petSelectionButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void render() {
        this.repaint();
    }

    @Override
    public void setListeners(ArrayList<Action> a) {
        backButton.addActionListener(a.get(0).getActionListener());
    }
}

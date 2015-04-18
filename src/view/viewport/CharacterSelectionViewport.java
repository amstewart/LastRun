package view.viewport;

import controller.action.Action;
import controller.action.charSelectAction.SelectSmasherAction;
import controller.action.charSelectAction.SelectSneakAction;
import controller.action.charSelectAction.SelectSummonerAction;
import controller.action.stateMachineAction.GoBackAction;
import controller.action.stateMachineAction.GoToGameAction;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;


import model.entity.Avatar;
import utility.ImageUtil;

/**
 *
 * @author ChrisMoscoso
 */
public class CharacterSelectionViewport extends Viewport {

    public JLabel currentOccupation;
    
    private ImageIcon current, general, summoner, smasher, sneak;

    public CharacterSelectionViewport(Avatar avatar) {
        initComponents(avatar);
        general = new ImageIcon(ImageUtil.CHAR_SELECT_GENERAL);//ImageUtil.getImage(ImageUtil.CHAR_SELECT_GENERAL);
        summoner = new ImageIcon(ImageUtil.CHAR_SELECT_SUMMONER);
        smasher = new ImageIcon(ImageUtil.CHAR_SELECT_SMASHER);
        sneak = new ImageIcon(ImageUtil.CHAR_SELECT_SNEAK);
        
        current = general;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g.create();
        Image i = current.getImage();
        i.setAccelerationPriority(1);
        g2D.drawImage(i, 0, 0,  null);
    }
    
    @Override
    public void render() {
        this.revalidate();
    }
    private void initComponents(Avatar avatar) {

        JButton back = new JButton("Go Back");
        back.addActionListener(Action.getActionListener(new GoBackAction()));

        this.add(back, BorderLayout.EAST);
        currentOccupation = new JLabel("Current Occupation: ");
        currentOccupation.setForeground(Color.white);
        this.add(currentOccupation);

        // These buttons need to add actions that call the correct select function of occupation choose
        JButton summoner = new JButton("summoner");
        summoner.addActionListener(Action.getActionListener(new SelectSummonerAction(avatar)));
        summoner.addActionListener(new BackgroundChanger(0));
        JButton smasher = new JButton("smasher");
        smasher.addActionListener(Action.getActionListener(new SelectSmasherAction(avatar)));
        smasher.addActionListener(new BackgroundChanger(1));
        JButton sneak = new JButton("sneak"); 
        sneak.addActionListener(Action.getActionListener(new SelectSneakAction(avatar)));
        sneak.addActionListener(new BackgroundChanger(2));

        this.add(summoner);
        this.add(smasher);
        this.add(sneak);

        JButton goToGame = new JButton("Go to Game");
        goToGame.addActionListener(Action.getActionListener(new GoToGameAction()));
        this.add(goToGame, BorderLayout.WEST);
        
        
    }
    
    public class BackgroundChanger implements ActionListener{

        int choice;
        
        public BackgroundChanger(int c){
            choice = c;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(choice == 0){
                current = summoner;
            }else if(choice == 1){
                current = smasher;
            }else{
                current = sneak;
            }
        }
        
    }

    public void receiveSelection(String occupationName) {
        currentOccupation.setText("Current occupation selected: " +  occupationName);
    }
}

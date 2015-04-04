
package view.viewport;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ChrisMoscoso
 */
public class CharSelectViewport extends Viewport{
    private JButton summoner, smasher, sneak, goBack, next;
    private JTextField name;
    
    public CharSelectViewport() {
        initComponents();
    }
    private void initComponents() {
        summoner = new JButton("Be a Summoner");
        smasher = new JButton("Be a Smasher");
        sneak = new JButton("Be a Sneak");
        goBack = new JButton("Go Back");
        next = new JButton("Next");
        
        name = new JTextField("Enter your summoner name here");
        
        this.setBackground(new Color(102, 153, 255));
        this.setLayout(new BorderLayout());
        
        JPanel occupations = new JPanel();
        occupations.add(summoner);
        occupations.add(smasher);
        occupations.add(sneak);
        
        this.add(name, BorderLayout.NORTH);
        this.add(occupations, BorderLayout.SOUTH);
        this.add(goBack, BorderLayout.WEST);
        this.add(next, BorderLayout.EAST);
    }
    
    public void setGoBackListener(ActionListener a){
        goBack.addActionListener(a);
    }
}

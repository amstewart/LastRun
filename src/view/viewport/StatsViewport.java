package view.viewport;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import javax.swing.JLabel;

import model.stat.Stats;

public class StatsViewport extends Viewport {
	
	ArrayList<String> stats = new ArrayList<>();
	public StatsViewport(Stats stats) {
            try{
		stats.registerView(this);
            }catch(ConcurrentModificationException ex){}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawStats(g);
	}

	private void drawStats(Graphics g) {
	
	}

	public void receive(ArrayList<String> stats) {
		this.removeAll();
		String print = "<html><div align=center>Stats</div><div align=left>";
		//g.drawString("Stats", 0,20);
		int height = 20;
		int width = 0;
		for (String s : stats) {
			print += s + "<br>";
		}
		//this.repaint();
		print += "</div>";
		print += "</html>";
		add(new JLabel(print));
	}

	@Override
	public void render() {
	
	}

	

}

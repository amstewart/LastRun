package main;

import controller.KeyBinding;
import model.entity.GameBundle;
import state.CharacterSelectionState;
import state.GameState;
import state.LoadSaveState;
import state.MenuState;
import state.PauseGameState;
import state.PetSelectionState;
import state.StateMachine;

public class RunGame {

    public static void main(String[] args) {
//    	Tile tiles[][] = new Tile[10][10];
//    	for(int i = 0; i!=10; ++i){
//    		for(int j = 0; j!=10; ++j){
//    			Position p = new Position(j,i);
//    			Tile tile = new Tile(p);
//    			tiles[i][j] = tile;
//    			
//    		}
//    	}
//    	JFrame frame = new JFrame();
//    	JPanel panel = new JPanel(){
//    		@Override
//    		protected void paintComponent(Graphics g){
//    			g.setColor(java.awt.Color.WHITE);
//    			//g.fillRect(0, 0, 100, 100);
//    			
//    			
//    			
//    			for(int i = 0; i < 10; ++i){
//    				for(int j = 0; j < 10; ++j){   
//    					
//    					int tileWidth = 50; int tileHeight = 50;
//    					int offsetX = 50 ; int offsetY = 40;
//
//    					if(i % 2 != 0){
//    						offsetY += 45;
//    					}
//    					
//    					
//    					int positionX = i * tileWidth * 2;
//    					int positionY = (int) (j * tileHeight * 1.748);
//    					
//    					positionX -= i * tileWidth / 2;
//    					
//    					Polygon p = new Polygon();
//    				    for (int k = 0; k < 6; k++){
//    				      g.setColor(java.awt.Color.BLACK);
//    				      p.addPoint((int) (offsetX + positionX + tileWidth * Math.cos(k * 2 * Math.PI / 6)),
//    				          (int) (offsetY + positionY + tileHeight * Math.sin(k * 2 * Math.PI / 6)));
//    				      if(k > 0){
//    				    	  g.drawLine(p.xpoints[k - 1], p.ypoints[k-1], p.xpoints[k], p.ypoints[k]);
//    				      }
//    				      
//    				    }
//
//    				    int red = (int) 0;//(Math.random() * 255);
//    				    int green = (int) (Math.random() * 255);
//    				    int blue = (int) 0;//(Math.random() * 255);
//    				    
//    				    g.setColor(new Color(red,green,blue));
//    				    g.fillPolygon(p);
//    				    
//    				    g.setColor(java.awt.Color.WHITE);    				    
//    				    String coordinate = "(" + i + "," + j + ")";
//    				    g.drawString(coordinate, offsetX + positionX - g.getFontMetrics().stringWidth(coordinate)/2, offsetY + positionY + g.getFontMetrics().getHeight()/2);
//    				    
//    				}
//    			}
//    		}
//    	};
//    	frame.setTitle("Last Run");
//    	frame.setSize(500, 500);
//    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    	frame.setVisible(true);
//    	frame.getContentPane().add(panel, BorderLayout.CENTER);
//    	panel.setBackground(java.awt.Color.blue);
//    	panel.revalidate();
//    
//    	panel.repaint();

   	KeyBinding keyBinding = new KeyBinding();
        GameBundle bundle = new GameBundle();
        StateMachine s = new StateMachine();
        s.add("menuState", new MenuState(bundle, s));
        s.add("characterSelectionState", new CharacterSelectionState(bundle, s));
        s.add("petSelectionState", new PetSelectionState(bundle,s));
        s.add("gameState", new GameState(bundle,s));
        s.add("pauseGameState", new PauseGameState(bundle,s));
        s.add("loadSaveState", new LoadSaveState(bundle,s));
        
        s.changeToState("menuState", bundle);
        
        while(true){
            s.update();
            s.render();
            //System.out.println(System.currentTimeMillis());
            try {
                Thread.sleep(33);
            } catch (InterruptedException ex) {}
        }

    }

}

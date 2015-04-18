package view.viewport;

import controller.action.Action;
import controller.action.mapAction.ZoomInMapAction;
import controller.action.mapAction.ZoomOutMapAction;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.Vector2;
import model.map.GameMap;
import model.movement.EntityMovement;
import utility.ImageUtil;

/**
 *
 * @author =ChrisMoscoso
 */
public class MapViewport extends Viewport {

    private double scale = 1.0;

    private static double cantMoveTimer = 0;
    private static Vector2 cantMoveLocation = Vector2.zero();

    private GameMap map;
    private int hexRadius = 36;
    private final int defaultHexRadius = hexRadius; //Used for zoom scale


    private int hexWidth = hexRadius * 2;
    private int hexHeight = (int) (hexRadius * 1.75);
    
    private JButton zoomIn, zoomOut;

    public MapViewport(GameMap m) {
        map = m;
        this.setLayout(null);
        initComponents();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //validate();
        drawTiles(g);
        drawEntities(g);
    }

    private void drawTiles(Graphics g) {
       // g.setColor(java.awt.Color.WHITE);

        //g.setColor(Color.ORANGE);
        //g.fillRect(0, 00, getSize().width, getSize().height);
        
        //Calculate which portion of the map to draw based on avatar position.
        int windowWidth = (int) (this.getSize().width);
        int windowHeight = (int) (this.getSize().height);

        int windowWidthInTiles = windowWidth / ((int) (Math.tan(0.5235) * hexRadius) + hexRadius);
        int windowHeightInTiles = (windowHeight / hexHeight);
        
        
        int startX = map.getAvatarMovement().getPosition().X - (windowWidthInTiles / 2);
        int startY = map.getAvatarMovement().getPosition().Y - (windowHeightInTiles / 2);

        int mapWidthInTiles = map.getWidth();
        int mapHeightInTiles = map.getHeight();

        if (startX < 0) {
            startX = 0;
        } else if (startX > mapWidthInTiles - windowWidthInTiles) {
            startX = mapWidthInTiles - windowWidthInTiles;
        }
        if (startY < 0) {
            startY = 0;
        } else if (startY > mapHeightInTiles - windowHeightInTiles) {
            startY = mapHeightInTiles - windowHeightInTiles;
        }

        for (int i = startX; i < Math.min(startX + windowWidthInTiles, mapWidthInTiles); i++) {
            for (int j = startY; j < Math.min(startY + windowHeightInTiles, mapHeightInTiles); j++) {

                int offsetX = hexRadius;
                int offsetY = 0;//(int) (hexRadius * 0.8);

                if (i % 2 != 0) {
                    offsetY += (int) (hexRadius * 0.84);
                }

                int positionX = (i - startX) * hexWidth;
                int positionY = (int) ((j - startY) * hexHeight);

                positionX -= (i - startX) * hexRadius / 2;
                /*
                Polygon p = new Polygon();
                for (int k = 0; k < 6; k++) {
                    g.setColor(java.awt.Color.BLACK);
                    p.addPoint((int) (offsetX + positionX + hexRadius * Math.cos(k * 2 * Math.PI / 6)),
                            (int) (offsetY + positionY + hexRadius * Math.sin(k * 2 * Math.PI / 6)));
                    if (k > 0) {
                        g.drawLine(p.xpoints[k - 1], p.ypoints[k - 1], p.xpoints[k], p.ypoints[k]);
                    }

                }
				*/
               
                 drawTerrain(g, i,j,positionX,positionY, offsetY);
                
                if(map.getTile(i,j).isAreaEffectOwner()){
                	 drawAreaEffect(g, i,j,positionX,positionY, offsetY);
                }
                
                if(map.getTile(i,j).isItemOwner()){
                	 drawItem(g, i,j,positionX,positionY, offsetY);
                }
                
            
                g.setColor(java.awt.Color.WHITE);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
                String coordinate = "(" + i + "," + j + ")";
                if (i == cantMoveLocation.X && j == cantMoveLocation.Y && cantMoveTimer > 0) {
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
                    coordinate = "Cant Go Here";
                    g.drawString(coordinate, offsetX + positionX - g.getFontMetrics().stringWidth(coordinate) / 2, offsetY + positionY + (int)(hexRadius * 0.8) + g.getFontMetrics().getHeight() / 2);
                    cantMoveTimer -= 0.02;
                } else {
                    //g.drawString(coordinate, offsetX + positionX - g.getFontMetrics().stringWidth(coordinate) / 2, offsetY + positionY + g.getFontMetrics().getHeight() / 2);
                }
            }
        }
    }
    
    private void drawTerrain(Graphics g, int i,int j, int positionX, int positionY, int offsetY){
    	 String terrain= map.getTile(i,j).getTerrain().getAssetID();
         ImageIcon image= ImageUtil.getImage(terrain);
         g.drawImage(image.getImage(),positionX,positionY+offsetY, hexWidth, hexHeight, this);
    }
    
    private void drawAreaEffect(Graphics g, int i,int j, int positionX, int positionY, int offsetY){
   	 String img= map.getTile(i,j).getAreaEffect().getAssetID();
        ImageIcon image= ImageUtil.getImage(img);
        g.drawImage(image.getImage(),positionX,positionY+offsetY, hexWidth, hexHeight, this);
   }
    
    private void drawItem(Graphics g, int i,int j, int positionX, int positionY, int offsetY){
    	String img= map.getTile(i,j).getItem().getAssetID();
        ImageIcon image= ImageUtil.getImage(img); //this function has not been tested. Just prematurely made
        g.drawImage(image.getImage(),positionX,positionY+offsetY, hexWidth, hexHeight, this);
   }

    private void drawEntities(Graphics g) {
        int windowWidth = (int) (this.getSize().width);
        int windowHeight = (int) (this.getSize().height);

        int windowWidthInTiles = windowWidth / ((int) (Math.tan(0.5235) * hexRadius) + hexRadius);
        int windowHeightInTiles = windowHeight / (int) (hexHeight);

        int startX = map.getAvatarMovement().getPosition().X - (windowWidthInTiles / 2);
        int startY = map.getAvatarMovement().getPosition().Y - (windowHeightInTiles / 2);

        int mapWidthInTiles = map.getWidth();
        int mapHeightInTiles = map.getHeight();

        if (startX < 0) {
            startX = 0;
        } else if (startX > mapWidthInTiles - windowWidthInTiles) {
            startX = mapWidthInTiles - windowWidthInTiles;
        }
        if (startY < 0) {
            startY = 0;
        } else if (startY > mapHeightInTiles - windowHeightInTiles) {
            startY = mapHeightInTiles - windowHeightInTiles;
        }

        for (EntityMovement e : map.getEntityMovements()) {
            for (int i = startX; i < Math.min(startX + windowWidthInTiles, mapWidthInTiles); i++) {
                for (int j = startY; j < Math.min(startY + windowHeightInTiles, mapHeightInTiles); j++) {
                    if (e.getPosition().X == i && e.getPosition().Y == j) {

                        int offsetX = hexRadius;
                        int offsetY = (int) (hexRadius * 0.8);

                        if (i % 2 != 0) {
                            offsetY += (int) (hexRadius * 0.84);
                        }

                        int positionX = (i - startX) * hexRadius * 2;
                        int positionY = (int) ((j - startY) * hexRadius * 1.748);

                        positionX -= (i - startX) * hexRadius / 2;
                        g.setColor(Color.ORANGE);
                        //g.fillRect(offsetX + positionX - hexRadius / 2, offsetY + positionY - hexRadius / 2, hexRadius, hexRadius);
                        Rectangle rect = new Rectangle(offsetX + positionX - hexRadius/2, offsetY + positionY - hexRadius/2, hexRadius, hexRadius);
                        g.drawImage(ImageUtil.getImage(e.getEntity().getAssetID()).getImage(), rect.x, rect.y, rect.width, rect.height, this);
                    }
                }
            }
        }
    }

    public void zoomIn() {
        scale += 0.10;
        if(scale > 2){
            scale = 2;
        }
        rescaleMap();
    }

    public void zoomOut() {
        scale -= 0.10;
        if(scale < 0.3){
            scale = 0.3;
        }
        rescaleMap();
    }

    private void rescaleMap() {
        hexRadius = (int) (defaultHexRadius * scale);
        hexWidth = hexRadius * 2;
        hexHeight = (int) (hexRadius * 1.748);
    }

    @Override
    public void render() {
        this.repaint();
        if(zoomIn != null && zoomOut != null){
            zoomIn.setBounds(this.getSize().width - 100,0,50,50);
            zoomOut.setBounds(this.getSize().width - 50,0,50,50);

            zoomIn.repaint();
            zoomOut.repaint();
        }
    }

    public static void drawCantMove(Vector2 v2) {
        cantMoveLocation = v2;
        cantMoveTimer = 1.0;
    }

    private void initComponents() {
        ImageIcon zoomInIcon = ImageUtil.rescaleImage(ImageUtil.getImage(ImageUtil.ZOOM_IN), 45, 45);
        zoomIn = new JButton(zoomInIcon);
        zoomIn.addActionListener(Action.getActionListener(new ZoomInMapAction(this)));
        ImageIcon zoomOutIcon = ImageUtil.rescaleImage(ImageUtil.getImage(ImageUtil.ZOOM_OUT), 45, 45);
        zoomOut = new JButton(zoomOutIcon);
        zoomOut.addActionListener(Action.getActionListener(new ZoomOutMapAction(this)));
        
        this.add(zoomIn);
        this.add(zoomOut);
    }

}

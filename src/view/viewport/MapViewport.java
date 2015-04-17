package view.viewport;

import java.awt.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import model.Vector2;
import model.map.GameMap;
import model.movement.EntityMovement;
import utility.ImageUtil;

/**
 *
 * @author =ChrisMoscoso
 */
public class MapViewport extends Viewport {

    static double cantMoveTimer = 0;
    static Vector2 cantMoveLocation = Vector2.zero();
    
    GameMap map;
    int tileWidth = 50;
    int tileHeight = 50;

    public MapViewport(GameMap m) {
        map = m;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTiles(g);
        drawEntities(g);
    }

    private void drawTiles(Graphics g) {
        g.setColor(java.awt.Color.WHITE);
        
        //Calculate which portion of the map to draw based on avatar position.
        int windowWidth = (int) (this.getSize().width);
        int windowHeight = (int) (this.getSize().height);
        
        
        
        int windowWidthInTiles =  (windowWidth /  (tileWidth* 2)) + 2;
        int windowHeightInTiles =  windowHeight / (int) (tileHeight * 1.748);

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


                int offsetX = 50;
                int offsetY = 40;
                
                if (i % 2 != 0) {
                    offsetY += 45;
                }

                int positionX = (i - startX) * tileWidth * 2;
                int positionY = (int) ((j - startY) * tileHeight * 1.748);

                positionX -= (i - startX) * tileWidth / 2;

                Polygon p = new Polygon();
                for (int k = 0; k < 6; k++) {
                    g.setColor(java.awt.Color.BLACK);
                    p.addPoint((int) (offsetX + positionX + tileWidth * Math.cos(k * 2 * Math.PI / 6)),
                            (int) (offsetY + positionY + tileHeight * Math.sin(k * 2 * Math.PI / 6)));
                    if (k > 0) {
                        g.drawLine(p.xpoints[k - 1], p.ypoints[k - 1], p.xpoints[k], p.ypoints[k]);
                    }

                }

                Color c = map.getTile(i, j).getTerrain().getColor();
                g.setColor(c);
                g.fillPolygon(p);

                g.setColor(java.awt.Color.WHITE);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
                String coordinate = "(" + i + "," + j + ")";
                if(i == cantMoveLocation.X && j == cantMoveLocation.Y && cantMoveTimer > 0){
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
                    coordinate = "Cant Go Here";
                    g.drawString(coordinate, offsetX + positionX - g.getFontMetrics().stringWidth(coordinate) / 2, offsetY + positionY + g.getFontMetrics().getHeight() / 2);
                    cantMoveTimer -= 0.02;
                }else{
                    //g.drawString(coordinate, offsetX + positionX - g.getFontMetrics().stringWidth(coordinate) / 2, offsetY + positionY + g.getFontMetrics().getHeight() / 2);
                }
              
                
            }
        }
    }
    
    private void DRAWINGONBIGGERMAP(){
        /* //Calculate which portion of the map to draw based on avatar position.
        int windowWidth = (int) (GameDirector.getSize().width * 0.8);
        int windowHeight = (int) (GameDirector.getSize().height * 0.8);
        //g.drawRect(0, 0, windowWidth, windowHeight);
        
        
        int windowWidthInTiles = ( windowWidth / tileWidth);
        int windowHeightInTiles = ( windowHeight / tileHeight);

        int startX = entityList.get(0).getLocation().x - windowWidthInTiles / 2;
        int startY = entityList.get(0).getLocation().y - windowHeightInTiles / 2;

        if (startX < 0) {
            startX = 0;
        } else if (startX > widthInTiles - windowWidthInTiles) {
            startX = widthInTiles - windowWidthInTiles;
        }
        if (startY < 0) {
            startY = 0;
        } else if (startY > heightInTiles - windowHeightInTiles) {
            startY = heightInTiles - windowHeightInTiles;
        }

        //Start drawing
        for (int i = startX; i < Math.min(startX + windowWidthInTiles, widthInTiles); i++) {
            for (int j = startY; j < Math.min(startY + windowHeightInTiles, heightInTiles); j++) {

                //Draw Coordinates
                g.setColor(Color.blue);
                String coordinate = "(" + i + "," + j + ")";
                int strX = (i - startX) * tileWidth + tileWidth / 2 - g.getFontMetrics().stringWidth(coordinate) / 2;
                int strY = (j - startY) * tileHeight + tileHeight / 2;
                g.drawString(coordinate, strX, strY);

                //Draw Entities
                for (Entity e : entityList) {
                    if (e.getLocation().equals(new Point(i, j))) {
                        Image entityImg = e.getSprite();
                        g.drawImage(entityImg, (i - startX) * tileWidth, (j - startY) * tileHeight, null);

                        //Draw Entity Health Bars for all entities - avatar
                        if (!e.equals(Avatar.getAvatar())) {
                            double percentageOfHealth = (double) e.getPlayerStats().getCurrentHealth() / (double) e.getPlayerStats().getMaxHealth();
                            g.setColor(Color.gray);
                            g.fillRoundRect((i - startX) * tileWidth, (j - startY) * tileHeight, tileWidth, 3, 5, 5);
                            g.setColor(Color.green);
                            g.fillRoundRect((i - startX) * tileWidth, (j - startY) * tileHeight, (int) (tileWidth * percentageOfHealth), 3, 5, 5);
                        }
                    }
                }

                //Draw Projectiles
                try {
                    for (Projectile p : projectileList) {
                        if (p.getLocation().equals(new Point(i, j))) {
                            Image entityImg = p.getSprite();
                            g.drawImage(entityImg, (i - startX) * tileWidth, (j - startY) * tileHeight, null);
                        }
                    }
                } catch (ConcurrentModificationException e) {
                }
            }
        }*/
    }
    

    private void drawEntities(Graphics g) {
        int windowWidth = (int) (this.getSize().width);
        int windowHeight = (int) (this.getSize().height);
        
        
        
        int windowWidthInTiles =  (windowWidth /  (tileWidth*2)) + 2;
        int windowHeightInTiles =  windowHeight / (int) (tileHeight * 1.748);

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

                        int offsetX = 50;
                        int offsetY = 40;

                        if (i % 2 != 0) {
                            offsetY += 45;
                        }

                        int positionX = (i - startX) * tileWidth * 2;
                        int positionY = (int) ((j - startY) * tileHeight * 1.748);

                        positionX -= (i - startX) * tileWidth / 2;
                        g.setColor(Color.ORANGE);
                        Rectangle rect = new Rectangle(offsetX + positionX - tileWidth/2, offsetY + positionY - tileHeight/2, tileWidth, tileHeight);
                        g.drawImage(ImageUtil.getImage(e.getEntity().getAssetID()).getImage(), rect.x, rect.y, rect.width, rect.height, this);
                    }
                }
            }
        }
    }

    @Override
    public void render() {
        this.repaint();
    }

    public static void drawCantMove(Vector2 v2){
        cantMoveLocation = v2;
        cantMoveTimer = 1.0;
    }

}

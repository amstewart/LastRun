package view.viewport;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import model.map.GameMap;
import model.map.MiniMap;
import view.viewport.MapViewport;

/**
 *
 * @author ChrisMoscoso
 */
public class MiniMapViewport extends MapViewport {

    private MapViewport mapVP;
    private MiniMap mmap = null;

    public MiniMapViewport(GameMap m, MapViewport mapVP) {
        super(m);
        this.mapVP = mapVP;
        this.allowMapToZoom(false);
        this.setScale(0.12);
    }

    @Override
    protected void drawTiles(Graphics g) {
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

        if (startX > mapWidthInTiles - windowWidthInTiles) {
            startX = mapWidthInTiles - windowWidthInTiles;
        }

        if (startX < 0) {
            startX = 0;
        }

        if (startY > mapHeightInTiles - windowHeightInTiles) {
            startY = mapHeightInTiles - windowHeightInTiles;
        }

        if (startY < 0) {
            startY = 0;
        }

        for (int i = startX; i < mapWidthInTiles; i++) {
            for (int j = startY; j < mapHeightInTiles; j++) {

                int offsetX = hexRadius;
                int offsetY = 0;//(int) (hexRadius * 0.8);

                if (i % 2 != 0) {
                    offsetY += (int) (hexRadius * 0.84);
                }

                int positionX = (i - startX) * hexWidth;
                int positionY = (int) ((j - startY) * hexHeight);

                positionX -= (i - startX) * hexRadius / 2;

                Polygon p = new Polygon();
                for (int k = 0; k < 6; k++) {
                    g.setColor(java.awt.Color.BLACK);
                    p.addPoint((int) (offsetX + positionX + hexRadius * Math.cos(k * 2 * Math.PI / 6)),
                            (int) (offsetY + positionY + hexRadius * Math.sin(k * 2 * Math.PI / 6)));
                    if (k > 0) {
                        g.drawLine(p.xpoints[k - 1], p.ypoints[k - 1], p.xpoints[k], p.ypoints[k]);
                    }

                }


                drawTerrain(g, i, j, positionX, positionY, offsetY);/*

                 if (map.getTile(i, j).isAreaEffectOwner()) {
                 drawAreaEffect(g, i, j, positionX, positionY, offsetY);
                 }

                 if (map.getTile(i, j).isItemOwner()) {
                 drawItem(g, i, j, positionX, positionY, offsetY);
                 }

                 if (map.getTile(i, j).isProjectileOwner()) {
                 drawProjectile(g, i, j, positionX, positionY, offsetY);
                 }

                 g.setColor(java.awt.Color.WHITE);
                 g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
                 String coordinate = "(" + i + "," + j + ")";
                 if (i == cantMoveLocation.X && j == cantMoveLocation.Y && cantMoveTimer > 0) {
                 g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
                 coordinate = "Cant Go Here";
                 g.drawString(coordinate, offsetX + positionX - g.getFontMetrics().stringWidth(coordinate) / 2, offsetY + positionY + (int) (hexRadius * 0.8) + g.getFontMetrics().getHeight() / 2);
                 cantMoveTimer -= 0.02;
                 } else {
                 //g.drawString(coordinate, offsetX + positionX - g.getFontMetrics().stringWidth(coordinate) / 2, offsetY + positionY + g.getFontMetrics().getHeight() / 2);
                 }*/
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int dx = 50;
        int dy = 50;
        int dwidth = 100;
        int dheight = 100;
        g.drawImage(mmap.getBitmap(), dx, dy, dwidth, dheight, this);
        /*
        int mapVPWidthInTiles = mapVP.getWindowWidthInTiles();
        int mapVPHeightInTiles = mapVP.getWindowHeightInTiles();

        int startX = map.getAvatarMovement().getPosition().X - (mapVPWidthInTiles / 2);
        int startY = map.getAvatarMovement().getPosition().Y - (mapVPHeightInTiles / 2);
        
        int mapWidthInTiles = map.getWidth();
        int mapHeightInTiles = map.getHeight();
        
        if (startX > mapWidthInTiles - mapVPWidthInTiles) {
            startX = mapWidthInTiles - mapVPWidthInTiles;
        }

        if (startX < 0) {
            startX = 0;
        }

        if (startY > mapHeightInTiles - mapVPHeightInTiles) {
            startY = mapHeightInTiles - mapVPHeightInTiles;
        }

        if (startY < 0) {
            startY = 0;
        }
        
        int rectWidth = mapVPWidthInTiles * hexWidth;
        int rectHeight = mapVPHeightInTiles * hexHeight;
        
        System.out.println("startX: "+startX);
        System.out.println("formula= " + (mapWidthInTiles - (mapVPHeightInTiles / 2)));
        System.out.println(startX > mapWidthInTiles - mapVPHeightInTiles / 2);
        if(startX > mapWidthInTiles - (mapVPHeightInTiles / 2)){
            
            rectWidth = (mapWidthInTiles - startX) * hexHeight - 20;
        }
        g.drawRect((int) (startX * hexWidth * 0.84), (int) (startY * hexHeight * 0.80), rectWidth, rectHeight);
        */
    }

    public void linkToMMap(MiniMap mmap) {
        this.mmap = mmap;
    }
}

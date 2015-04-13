package view.viewport;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import model.Vector3;
import model.action.Action;
import model.map.GameMap;
import model.movement.EntityMovement;

/**
 *
 * @author ChrisMoscoso
 */
public class MapViewport extends Viewport {

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
        //g.fillRect(0, 0, 100, 100);

        for (int i = 0; i < map.getWidth(); ++i) {
            for (int j = 0; j < map.getHeight(); ++j) {

                int offsetX = 50;
                int offsetY = 40;

                if (i % 2 != 0) {
                    offsetY += 45;
                }

                int positionX = i * tileWidth * 2;
                int positionY = (int) (j * tileHeight * 1.748);

                positionX -= i * tileWidth / 2;

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
                String coordinate = "(" + i + "," + j + ")";
                g.drawString(coordinate, offsetX + positionX - g.getFontMetrics().stringWidth(coordinate) / 2, offsetY + positionY + g.getFontMetrics().getHeight() / 2);

            }
        }
    }

    private void drawEntities(Graphics g) {
        for (EntityMovement e : map.getEntityMovements()) {
            for (int i = 0; i < map.getWidth(); ++i) {
                for (int j = 0; j < map.getHeight(); ++j) {
                    if (e.getPosition().X == i && e.getPosition().Y == j) {

                        int offsetX = 50;
                        int offsetY = 40;

                        if (i % 2 != 0) {
                            offsetY += 45;
                        }

                        int positionX = i * tileWidth * 2;
                        int positionY = (int) (j * tileHeight * 1.748);

                        positionX -= i * tileWidth / 2;
                        g.setColor(Color.ORANGE);
                        g.fillRect(offsetX + positionX - tileWidth/2, offsetY + positionY - tileHeight/2, tileWidth, tileHeight);
                    }
                }
            }
        }
    }

    @Override
    public void render() {
        this.repaint();
    }

    @Override
    public void setListeners(ArrayList<Action> a) {

    }

}

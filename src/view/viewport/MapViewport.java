package view.viewport;

import controller.action.Action;
import controller.action.mapAction.ZoomInMapAction;
import controller.action.mapAction.ZoomOutMapAction;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
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
    private int hexRadius = 50;

    private int hexWidth = hexRadius * 2;
    private int hexHeight = (int) (hexRadius * 1.75);

    public MapViewport(GameMap m) {
        map = m;
        initComponents();
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

        int windowWidthInTiles = (windowWidth / hexWidth) + 2;
        int windowHeightInTiles = windowHeight / hexHeight;

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
                int offsetY = (int) (hexRadius * 0.8);

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

                Color c = map.getTile(i, j).getTerrain().getColor();
                g.setColor(c);
                g.fillPolygon(p);

                g.setColor(java.awt.Color.WHITE);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
                String coordinate = "(" + i + "," + j + ")";
                if (i == cantMoveLocation.X && j == cantMoveLocation.Y && cantMoveTimer > 0) {
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
                    coordinate = "Cant Go Here";
                    g.drawString(coordinate, offsetX + positionX - g.getFontMetrics().stringWidth(coordinate) / 2, offsetY + positionY + g.getFontMetrics().getHeight() / 2);
                    cantMoveTimer -= 0.02;
                } else {
                    g.drawString(coordinate, offsetX + positionX - g.getFontMetrics().stringWidth(coordinate) / 2, offsetY + positionY + g.getFontMetrics().getHeight() / 2);
                }

            }
        }
    }

    private void drawEntities(Graphics g) {
        int windowWidth = (int) (this.getSize().width);
        int windowHeight = (int) (this.getSize().height);

        int windowWidthInTiles = (windowWidth / (hexRadius * 2)) + 2;
        int windowHeightInTiles = windowHeight / (int) (hexRadius * 1.748);

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
        if(scale < 0.2){
            scale = 0.2;
        }
        rescaleMap();
    }

    private void rescaleMap() {
        int defaultHexRadius = 50;

        hexRadius = (int) (defaultHexRadius * scale);
        hexWidth = hexRadius * 2;
        hexHeight = (int) (hexRadius * 1.748);
    }

    @Override
    public void render() {
        this.repaint();
    }

    public static void drawCantMove(Vector2 v2) {
        cantMoveLocation = v2;
        cantMoveTimer = 1.0;
    }

    private void initComponents() {
        JButton zoomIn = new JButton("Zoom In");
        zoomIn.addActionListener(Action.getActionListener(new ZoomInMapAction(this)));

        JButton zoomOut = new JButton("Zoom Out");
        zoomOut.addActionListener(Action.getActionListener(new ZoomOutMapAction(this)));

        this.add(zoomIn);
        this.add(zoomOut);
    }

}

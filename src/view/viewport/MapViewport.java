package view.viewport;

import controller.action.Action;
import controller.action.mapAction.ZoomInMapAction;
import controller.action.mapAction.ZoomOutMapAction;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.Vector2;
import model.map.GameMap;
import model.movement.EntityMovement;
import model.tile.Tile;
import utility.ImageUtil;

public class MapViewport extends Viewport {

    private double scale = 1.0;
    private static final double MMAP_PERC = .15;

    private static double cantMoveTimer = 0;
    private static Vector2 cantMoveLocation = Vector2.zero();

    protected GameMap map;
    protected int hexRadius = 36;
    protected int mmap_min_xy = hexRadius * 2;
    protected final int defaultHexRadius = hexRadius; //Used for zoom scale

    protected int hexWidth = hexRadius * 2;
    protected int hexHeight = (int) (hexRadius * 1.75);

    private int windowWidthInTiles, windowHeightInTiles;

    private JButton zoomIn, zoomOut;
    private boolean isAllowedToZoom = true;

    public MapViewport(GameMap m) {
        map = m;
        this.setLayout(null);
        initComponents();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        revalidate();
        drawTiles(g);
        drawEntities(g);
        drawMiniMap(g);
    }

    protected void drawTiles(Graphics g) {
       // g.setColor(java.awt.Color.WHITE);

        //g.setColor(Color.ORANGE);
        //g.fillRect(0, 00, getSize().width, getSize().height);
        //Calculate which portion of the map to draw based on avatar position.
        int windowWidth = (int) (this.getSize().width);
        int windowHeight = (int) (this.getSize().height);

        windowWidthInTiles = windowWidth / ((int) (Math.tan(0.5235) * hexRadius) + hexRadius);
        windowHeightInTiles = (windowHeight / hexHeight);

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

        for (int i = startX; i < Math.min(startX + windowWidthInTiles, mapWidthInTiles); i++) {
            for (int j = startY; j < Math.min(startY + windowHeightInTiles, mapHeightInTiles); j++) {

                int offsetX = hexRadius;
                int polygonOffsetY = (int) (hexRadius * 0.8);
                int offsetY = 0;//(int) (hexRadius * 0.8);

                if (i % 2 != 0) {
                    polygonOffsetY += (int) (hexRadius * 0.84);
                    offsetY += (int) (hexRadius * 0.84);
                }

                int positionX = (i - startX) * hexWidth;
                int positionY = (int) ((j - startY) * hexHeight);

                positionX -= (i - startX) * hexRadius / 2;

                drawTerrain(g, i, j, positionX, positionY, offsetY);

                ArrayList<Tile> lightTiles = map.getAvatarMovement().getLightMap(map);
                
                ArrayList<Tile> ringAround = map.getAvatarMovement().getRingAroundAvatar(map);

                boolean currentTileShouldBeDark = true;

                for (Tile t : lightTiles) {
                    if (t.getLocation().X == i && t.getLocation().Y == j) {
                        currentTileShouldBeDark = false;
                        break;
                    }
                }
                
                for(Tile t : ringAround){
                	 if (t.getLocation().X == i && t.getLocation().Y == j) {
                         currentTileShouldBeDark = false;
                         break;
                     }
                }

                Polygon p = new Polygon();
                for (int k = 0; k < 6; k++) {
                    g.setColor(new Color(0, 0, 0, 128));
                    p.addPoint((int) (offsetX + positionX + hexRadius * Math.cos(k * 2 * Math.PI / 6)),
                            (int) (polygonOffsetY + positionY + hexRadius * Math.sin(k * 2 * Math.PI / 6)));
                    if (k > 0) {
                        g.drawLine(p.xpoints[k - 1], p.ypoints[k - 1], p.xpoints[k], p.ypoints[k]);
                    }

                }
                if (currentTileShouldBeDark) {
                    g.fillPolygon(p);
                }

                if (!currentTileShouldBeDark) {
                    if (map.getTile(i, j).isAreaEffectOwner()) {
                        drawAreaEffect(g, i, j, positionX, positionY, offsetY);
                    }

                    if (map.getTile(i, j).isItemOwner()) {
                        drawItem(g, i, j, positionX, positionY, offsetY);
                    }

                    if (map.getTile(i, j).isProjectileOwner()) {
                        drawProjectile(g, i, j, positionX, positionY, offsetY);
                    }
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
                   // g.drawString(coordinate, offsetX + positionX - g.getFontMetrics().stringWidth(coordinate) / 2, offsetY + positionY + g.getFontMetrics().getHeight() / 2);
                }
            }
        }
    }

    private void drawProjectile(Graphics g, int i, int j, int positionX,
            int positionY, int offsetY) {
        String img = map.getTile(i, j).getProjectile().getAssetID();
        ImageIcon image = ImageUtil.getImage(img);
        g.drawImage(image.getImage(), positionX, positionY + offsetY, hexWidth, hexHeight, this);

    }

    protected void drawTerrain(Graphics g, int i, int j, int positionX, int positionY, int offsetY) {
        String pro = map.getTile(i, j).getTerrain().getAssetID();
        ImageIcon image = ImageUtil.getImage(pro);
        g.drawImage(image.getImage(), positionX, positionY + offsetY, hexWidth, hexHeight, this);
    }

    private void drawAreaEffect(Graphics g, int i, int j, int positionX, int positionY, int offsetY) {
        String img = map.getTile(i, j).getAreaEffect().getAssetID();
        ImageIcon image = ImageUtil.getImage(img);
        g.drawImage(image.getImage(), positionX, positionY + offsetY, hexWidth, hexHeight, this);
    }

    private void drawItem(Graphics g, int i, int j, int positionX, int positionY, int offsetY) {
        String img = map.getTile(i, j).getItem().getAssetID();
        ImageIcon image = ImageUtil.getImage(img); //this function has not been tested. Just prematurely made
        g.drawImage(image.getImage(), positionX, positionY + offsetY, hexWidth, hexHeight, this);
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
                        Rectangle rect = new Rectangle(offsetX + positionX - hexRadius / 2, offsetY + positionY - hexRadius / 2, hexRadius, hexRadius);
                        g.drawImage(ImageUtil.getImage(e.getEntity().getAssetID()).getImage(), rect.x, rect.y, rect.width, rect.height, this);
                    }
                }
            }
        }
    }

    private void drawMiniMap(Graphics g) {
        int draw_x = this.getWidth() - (int) (MMAP_PERC * this.getWidth());
        int draw_y = 0;
        int draw_width = (int) (this.getWidth() * MMAP_PERC);
        if (draw_width < mmap_min_xy) {
            draw_width = mmap_min_xy;
        }
        int draw_height = draw_width;

        g.drawImage(this.map.getMiniMap().getBitmap(), draw_x, draw_y, draw_width, draw_height, this);
    }

    public void zoomIn() {
        if (isAllowedToZoom) {
            scale += 0.10;
            if (scale > 2) {
                scale = 2;
            }
            rescaleMap();
        }
    }

    public void zoomOut() {
        if (isAllowedToZoom) {

            scale -= 0.10;
            if (scale < 0.5) {
                scale = 0.5;
            }
            rescaleMap();
        }
    }

    private void rescaleMap() {
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
        ImageIcon zoomInIcon = ImageUtil.rescaleImage(ImageUtil.getImage(ImageUtil.ZOOM_IN), 45, 45);
        zoomIn = new JButton(zoomInIcon);
        zoomIn.addActionListener(Action.getActionListener(new ZoomInMapAction(this)));
        ImageIcon zoomOutIcon = ImageUtil.rescaleImage(ImageUtil.getImage(ImageUtil.ZOOM_OUT), 45, 45);
        zoomOut = new JButton(zoomOutIcon);
        zoomOut.addActionListener(Action.getActionListener(new ZoomOutMapAction(this)));

        zoomIn.setBounds(this.getSize().width - 100, 0, 50, 50);
        zoomOut.setBounds(this.getSize().width - 50, 0, 50, 50);

        zoomIn.repaint();
        zoomOut.repaint();

        this.add(zoomIn);
        this.add(zoomOut);
    }

    public void setScale(double d) {
        scale = d;
        rescaleMap();
    }

    public void allowMapToZoom(boolean b) {
        if (b) {
            this.add(zoomIn);
            this.add(zoomOut);
        } else if (b) {
            this.remove(zoomIn);
            this.remove(zoomOut);
        }

        isAllowedToZoom = b;
    }

    public int getWindowWidthInTiles() {
        return windowWidthInTiles;
    }

    public int getWindowHeightInTiles() {
        return windowHeightInTiles;
    }

}

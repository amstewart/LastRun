package model.map;

import model.Vector2;
import model.movement.EntityMovement;
import model.observer.MapObserver;
import model.terrain.GrassTerrain;
import model.terrain.MountainTerrain;
import model.terrain.TerrainVisitor;
import model.terrain.WaterTerrain;
import model.tile.Tile;
import utility.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Alex Stewart on 15/04/18.
 */
public class MiniMap implements TerrainVisitor, MapObserver {

    private static final Color C_AVATAR = Color.RED;
    private static final Color C_GRASS = new Color(0, 200, 0);
    private static final Color C_ITEM = Color.YELLOW;
    private static final Color C_MOUNTAIN = Color.LIGHT_GRAY;
    private static final Color C_PET = Color.MAGENTA;
    private static final Color C_TRAP = Color.ORANGE;
    private static final Color C_VEHICLE = Color.CYAN;
    private static final Color C_WATER = Color.BLUE;


    private Color[][] mmap = null;
    private Vector2 iter = Vector2.zero();

    public Image getBitmap() {
        BufferedImage ret_im = new BufferedImage(mmap.length, mmap[0].length, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < mmap.length; i ++) {
            for (int j = 0; j < mmap[0].length; j++) {
                ret_im.setRGB(i, j, mmap[i][j].getRGB());
            }
        }
        return ret_im;
    }

    public Color[][] getMMap() {
        return mmap;
    }

    @Override
    public void receiveMap(GameMap map) {
        translateMap(map);
    }
    @Override
    public void receiveNonStealthAvatarPosition(Vector2 v) {}

    public void translateMap(GameMap map) {
        int map_width = map.getWidth();
        int map_height = map.getHeight();

        mmap = new Color[map_width][map_height];
        for (iter.X = 0; iter.X < map_width; iter.X++) {
            for (iter.Y = 0; iter.Y < map_height; iter.Y++) {
                translateTile(map);
            }
        }
        iter = Vector2.zero();
    }

    private void translateTile(GameMap map) {
        if (mmap == null) return;
        Tile t = map.getTile(iter.X, iter.Y);

        t.getTerrain().accept(this); // Color Terrain

        // Color Avatar
        EntityMovement av = map.getAvatarMovement();
        if (av != null && av.getPosition().equals(iter)) {
            mmap[iter.X][iter.Y] = C_AVATAR;
            return; // exit now because we don't want to draw anything on top of the avatar
        }

        if (t.isPetOwner()) {
            mmap[iter.X][iter.Y] = C_PET;
            return;
        }

        if (t.isVehicleOwner()) {
            mmap[iter.X][iter.Y] = C_VEHICLE;
            return;
        }

        if (t.isAreaEffectOwner()) {
            mmap[iter.X][iter.Y] = C_TRAP;
            return;
        }

        if (t.isItemOwner()) {
            mmap[iter.X][iter.Y] = C_ITEM;
        }
    }

    public void visit(GrassTerrain t_grass) {
        mmap[iter.X][iter.Y] = C_GRASS;
    }

    public void visit(MountainTerrain t_mount) {
        mmap[iter.X][iter.Y] = C_MOUNTAIN;
    }

    public void visit(WaterTerrain t_water) {
        mmap[iter.X][iter.Y] = C_WATER;
    }
}
package model.map;

import java.util.ArrayList;
import model.Vector3;
import model.entity.Entity;
import model.item.Item;
import model.movement.EntityMovement;
import model.movement.ItemMovement;
import model.tile.Tile;

import java.util.LinkedList;

/**
 *
 * @author
 */
public class GameMap {

    private Tile[][] map;
    private LinkedList<EntityMovement> entityMovements = new LinkedList<>();
    private LinkedList<ItemMovement> itemMovements = new LinkedList<>();

    private MapBuilder m;

    public static final int WARP_MODE = 0;
    public static final int BOUND_MODE = 1;

    private int boundaryMode = 0;

    public GameMap() {
        m = new MapBuilder();
        map = m.getMap();
    }

    public void addEntity(Entity e, Vector3 location) {
        getTile(location).addEntity(e);
        entityMovements.add(new EntityMovement(e, location));
    }
    
    public ArrayList<Entity> getEntities(){
        ArrayList<Entity> arrayList = new ArrayList<>(); 
        for(EntityMovement e : entityMovements){
            arrayList.add(e.getEntity());
        }
        return arrayList;
    }
    
    public void addItem(Item item, Vector3 location) {
        getTile(location).addItem(item);
        itemMovements.add(new ItemMovement(item, location));
    }

    public Tile getTileToTheNorth(Vector3 location) {
        int newX = location.X;
        int newY = location.Y - 1;
        return map[newX][newY];
    }

    public Tile getTileToTheNorth(Tile t) {
        return getTileToTheNorth(t.getLocation());
    }

    public Tile getTileToTheNorthEast(Vector3 location) {
        int newX = location.X + 1;
        int newY = location.Y - 1;
        return map[newX][newY];
    }

    public Tile getTileToTheNorthEast(Tile t) {
        return getTileToTheNorthEast(t.getLocation());
    }

    public Tile getTileToTheNorthWest(Vector3 location) {
        int newX = location.X - 1;
        int newY = location.Y - 1;
        return map[newX][newY];
    }

    public Tile getTileToTheNorthWest(Tile t) {
        return getTileToTheNorthWest(t.getLocation());
    }

    public Tile getTileToTheSouth(Vector3 location) {
        int newX = location.X;
        int newY = location.Y + 1;
        return map[newX][newY];
    }

    public Tile getTileToTheSouth(Tile t) {
        return getTileToTheSouth(t.getLocation());
    }

    public Tile getTileToTheSouthEast(Vector3 location) {
        int newX = location.X;
        int newY = location.Y + 1;
        return map[newX][newY];
    }

    public Tile getTileToTheSouthEast(Tile t) {
        return getTileToTheSouthEast(t.getLocation());
    }

    public Tile getTileToTheSouthwest(Vector3 location) {
        int newX = location.X - 1;
        int newY = location.Y + 1;
        return map[newX][newY];
    }

    public Tile getTileToTheSouthwest(Tile t) {
        return getTileToTheSouthwest(t.getLocation());
    }

    public Tile getTile(Vector3 location) {
        return map[location.X][location.Y];
    }

    public Tile getTile(int i, int j) {
        return map[i][j];
    }

    public boolean removeEntity(EntityMovement ent_mov) {
        return entityMovements.remove(ent_mov);
    }

    public boolean removeItem(ItemMovement item_mov) { return itemMovements.remove(item_mov); }

    private int applyBoundaryX(int x) {
        switch (boundaryMode) {
            case WARP_MODE:
                return warpX(x);
            case BOUND_MODE:
                return boundX(x);
            default:
                return warpX(x);
        }
    }

    private int applyBoundaryY(int y) {
        switch (boundaryMode) {
            case WARP_MODE:
                return warpY(y);
            case BOUND_MODE:
                return boundY(y);
            default:
                return warpY(y);
        }
    }

    private int boundX(int x) {
        if (x < 0) {
            x = 0;
        } else if (x > map.length) {
            x = map.length - 1;
        }
        return x;
    }

    private int boundY(int y) {
        if (y < 0) {
            y = 0;
        } else if (y > map[0].length) {
            y = map[0].length - 1;
        }
        return y;
    }

    private int warpX(int x) {
        if (x < 0) {
            x = map.length - 1;
        } else if (x > map.length) {
            x = 0;
        }
        return x;
    }

    private int warpY(int y) {
        if (y < 0) {
            y = map[0].length - 1;
        } else if (y > map[0].length) {
            y = 0;
        }
        return y;
    }

    public int getWidth() {
        return map.length;
    }

    public int getHeight() {
        return map[0].length;
    }
}

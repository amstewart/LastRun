package model.map;

import java.util.ArrayList;

import model.Vector2;
import model.entity.Entity;
import model.item.Item;
import model.movement.EntityMovement;
import model.movement.ItemMovement;
import model.tile.Tile;

import java.util.LinkedList;
import model.entity.Avatar;
import utility.Direction;
import utility.Util;

public class GameMap {

    private static int DELTA_ODD_Y = 1;

    private Tile[][] map;
    private LinkedList<EntityMovement> entityMovements = new LinkedList<>();
    private LinkedList<ItemMovement> itemMovements = new LinkedList<>();

    private MapBuilder m;

    public static final int WARP_MODE = 0;
    public static final int BOUND_MODE = 1;

    private int boundaryMode = 0;
    private EntityMovement avatarMovement;

    public GameMap() {
        m = new MapBuilder();
        map = m.getMap();
    }

    public void addEntity(Avatar a) {
        this.addEntity(a, new Vector2());
    }

    public void addEntity(Avatar a, Vector2 location) {
        getTile(location).addEntity(a);
        avatarMovement = new EntityMovement(a, this, location);
        entityMovements.add(avatarMovement);
    }

    public void addEntity(Entity e) {
        this.addEntity(e, new Vector2());
    }

    public void addEntity(Entity e, Vector2 location) {
        getTile(location).addEntity(e);
        entityMovements.add(new EntityMovement(e, this, location));
    }

    public ArrayList<Entity> getEntities() {
        ArrayList<Entity> arrayList = new ArrayList<>();
        for (EntityMovement e : entityMovements) {
            arrayList.add(e.getEntity());
        }
        return arrayList;
    }

    public void addItem(Item item, Vector2 location) {
        getTile(location).addItem(item);
        itemMovements.add(new ItemMovement(item, location));
    }

    public void changeAvatarSprite(String new_asset) {
        avatarMovement.setAsset(new_asset);
    }

    public EntityMovement getAvatarMovement() {
        return avatarMovement;
    }

     public Tile getTileToTheNorth(Vector2 location) {
        int newX = location.X;
        int newY = location.Y  - 1;
        newX = this.applyBoundaryX(newX);
        newY = this.applyBoundaryY(newY);
        return map[newX][newY];
    }
    
    public Tile getTileToTheNorthEast(Vector2 location) {
        int newX = location.X + 1;
        int newY = location.Y - 1;

        if (isOdd(location.X)) {
            newY += DELTA_ODD_Y;
        }

        newX = this.applyBoundaryX(newX);
        newY = this.applyBoundaryY(newY);
        return map[newX][newY];
    }

    public Tile getTileToTheNorthEast(Tile t) {
        return getTileToTheNorthEast(t.getLocation());
    }

    public Tile getTileToTheNorthWest(Vector2 location) {
        int newX = location.X - 1;
        int newY = location.Y - 1;

        if (isOdd(location.X)) {
            newY += DELTA_ODD_Y;
        }

        newX = this.applyBoundaryX(newX);
        newY = this.applyBoundaryY(newY);
        return map[newX][newY];
    }

    public Tile getTileToTheNorthWest(Tile t) {
        return getTileToTheNorthWest(t.getLocation());
    }

    public Tile getTileToTheSouth(Vector2 location) {
        int newX = location.X;
        int newY = location.Y + 1;
        newX = this.applyBoundaryX(newX);
        newY = this.applyBoundaryY(newY);
        return map[newX][newY];
    }

    public Tile getTileToTheSouth(Tile t) {
        return getTileToTheSouth(t.getLocation());
    }

    public Tile getTileToTheSouthEast(Vector2 location) {
        int newX = location.X + 1;
        int newY = location.Y;

        if (isOdd(location.X)) {
            newY += DELTA_ODD_Y;
        }

        newX = this.applyBoundaryX(newX);
        newY = this.applyBoundaryY(newY);
        return map[newX][newY];
    }

    public Tile getTileToTheSouthEast(Tile t) {
        return getTileToTheSouthEast(t.getLocation());
    }

    public Tile getTileToTheSouthWest(Vector2 location) {
        int newX = location.X - 1;
        int newY = location.Y;

        if (isOdd(location.X)) {
            newY += DELTA_ODD_Y;
        }

        newX = this.applyBoundaryX(newX);
        newY = this.applyBoundaryY(newY);
        return map[newX][newY];
    }

    public Tile getTileToTheSouthWest(Tile t) {
        return getTileToTheSouthWest(t.getLocation());
    }

    public Tile getTile(Vector2 location) {
        return map[location.X][location.Y];
    }

    public Tile getTile(int i, int j) {
        return map[i][j];
    }

    private boolean isOdd(int num) {
        if (num % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean removeEntity(EntityMovement ent_mov) {
        return entityMovements.remove(ent_mov);
    }

    public boolean removeItem(ItemMovement item_mov) {
        return itemMovements.remove(item_mov);
    }

    private Vector2 applyBoundaryV(Vector2 location) {
        switch (boundaryMode) {
            case WARP_MODE:
                return new Vector2(warpX(location.X), warpY(location.Y));
            case BOUND_MODE:
                return new Vector2(boundX(location.X), boundY(location.Y));
            default:
                Util.errOut(new Exception("Invalid boundary mode"), false);
                return location;
        }
    }

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
        } else if (x >= map.length) {
            x = map.length - 1;
        }
        return x;
    }

    private int boundY(int y) {
        if (y < 0) {
            y = 0;
        } else if (y >= map[0].length) {
            y = map[0].length - 1;
        }
        return y;
    }

    private int warpX(int x) {
        if (x < 0) {
            x = map.length - 1;
        } else if (x >= map.length) {
            x = 0;
        }
        return x;
    }

    private int warpY(int y) {
        if (y < 0) {
            y = map[0].length - 1;
        } else if (y >= map[0].length) {
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

    public Iterable<EntityMovement> getEntityMovements() {
        return entityMovements;
    }

    public void moveAvatarTo(Vector2 dest) {
        Util.dbgOut("GameMap: Move avatar to " + dest.toString(), 4);
        Vector2 source = avatarMovement.getPosition();
        avatarMovement.changePosition(dest);
        avatarMovement.reface(Direction.getDirection(source, dest));
    }
}

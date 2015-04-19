package model.map;

import java.util.ArrayList;
import java.util.Queue;

import model.Vector2;
import model.entity.Entity;
import model.entity.Status;
import model.entity.vehicle.Vehicle;
import model.item.Item;
import model.movement.EntityMovement;
import model.movement.ItemMovement;
import model.tile.Tile;

import java.util.LinkedList;

import model.entity.Avatar;
import model.observer.MapObserver;
import utility.Direction;
import utility.Util;

public class GameMap {

    private ArrayList<MapObserver> observers = new ArrayList<>();
    private static int DELTA_ODD_Y = 1;

    private Tile[][] map;
    private MiniMap miniMap;
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
        miniMap = new MiniMap();
        addMapObserver(miniMap);
    }

    public void addEntity(Avatar a, Vector2 location) {
        getTile(location).addEntity(a);
        avatarMovement = new EntityMovement(a, this, location);
        entityMovements.add(avatarMovement);
    }

    public void addEntity(Entity e, Vector2 location) {
        getTile(location).addEntity(e);
        entityMovements.add(new EntityMovement(e, this, location));
        notifyObserversMapHasChanged();
    }

    public void addVehicle(Vehicle vic, Vector2 location) {
        getTile(location).addVehicle(vic);
        entityMovements.add(new EntityMovement(vic, this, location));
        notifyObserversMapHasChanged();
    }

    public ArrayList<Entity> getEntities() {
        ArrayList<Entity> arrayList = new ArrayList<>();
        for (EntityMovement e : entityMovements) {
            arrayList.add(e.getEntity());
        }
        return arrayList;
    }

    public void refaceAvatar(Vector2 facing, String new_asset) {
        avatarMovement.reface(facing);
        if (new_asset != null) {
            avatarMovement.setAsset(new_asset);
        }
        notifyObserversMapHasChanged();
    }

    public void addItem(Item item, Vector2 location) {
        getTile(location).addItem(item);
        itemMovements.add(new ItemMovement(item, location));
        notifyObserversMapHasChanged();
    }

    public EntityMovement getAvatarMovement() {
        return avatarMovement;
    }

    public MiniMap getMiniMap() {
        return miniMap;
    }

    public Tile getTileInDirection(Vector2 dir, Tile source) {
        if (dir.X == Direction.NORTH.X && dir.Y == Direction.NORTH.Y) {
            return getTileToTheNorth(source.getLocation());
        } else if (dir.X == Direction.SOUTH.X && dir.Y == Direction.SOUTH.Y) {
            return getTileToTheSouth(source);
        }
        if (dir.X == Direction.NORTHEAST.X && dir.Y == Direction.NORTHEAST.Y) {
            return getTileToTheNorthEast(source);
        }
        if (dir.X == Direction.NORTHWEST.X && dir.Y == Direction.NORTHWEST.Y) {
            return getTileToTheNorthWest(source);
        }
        if (dir.X == Direction.SOUTHEAST.X && dir.Y == Direction.SOUTHEAST.Y) {
            return getTileToTheSouthEast(source);
        }
        if (dir.X == Direction.SOUTHWEST.X && dir.Y == Direction.SOUTHWEST.Y) {
            return getTileToTheSouthWest(source);
        }
        return null;
    }

    public Tile getTileInDirection(Vector2 dir, Tile source, int distance) {
        if (distance < 0) {
            // fatally error if the distance is < 0
            Util.errOut(new Exception("Requested tile at negative distance"), true);
            return null;
        }

        Tile ret_tile = source;
        for (int i = 0; i < distance; i++) {
            ret_tile = this.getTileInDirection(dir, ret_tile);
        }
        return ret_tile;
    }

    public Tile getTileToTheNorth(Vector2 location) {
        int newX = location.X;
        int newY = location.Y - 1;
        newX = this.applyBoundaryX(newX);
        newY = this.applyBoundaryY(newY);
        return map[newX][newY];
    }

    public Tile getTileToTheNorth(Tile t) {
        return getTileToTheNorth(t.getLocation());
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
        notifyObserversMapHasChanged();
        return entityMovements.remove(ent_mov);
    }

    public boolean removeItem(ItemMovement item_mov) {
        notifyObserversMapHasChanged();
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
        Util.dbgOut("GameMap: Move avatar to " + dest.toString(), 5);
        Entity av = avatarMovement.getEntity();
        Vector2 source = avatarMovement.getPosition();
        avatarMovement.changePosition(dest);

        notifyObserversMapHasChanged();
        if (avatarMovement.getEntity().is(Status.INVISIBLE)) {
            notifyHostileNPC();
        }
    }

    public void moveEntityTo(Entity entity, Vector2 dest) {
        for (EntityMovement em : this.entityMovements) {
            if (em.getEntity() == entity) {
                this.getTile(em.getPosition()).removeEntity(entity);
                this.getTile(dest).addEntity(entity);
                this.getTile(dest).accept(entity);
                em.changePosition(dest);
            }
        }
        notifyObserversMapHasChanged();
    }

    public void moveEntityTo(Vehicle vehicle, Vector2 dest, boolean mounted) {
        for (EntityMovement em : this.entityMovements) {
            if (em.getEntity() == vehicle) {
                this.getTile(em.getPosition()).removeVehicle(vehicle);
                this.getTile(dest).addVehicle(vehicle);
                this.getTile(dest).toggleMount();
                em.changePosition(dest);
            }
        }
        notifyObserversMapHasChanged();
    }

    public void moveTileEntities(Tile source, Tile destination) {
        Entity e = source.getEntity();
        Vehicle v = null;
        if (source.vehicleMounted()) {
            v = source.getVehicle();
        }

        moveEntityTo(e, destination.getLocation());
        if (v != null) {
            moveEntityTo(v, destination.getLocation(), true);
        }
    }

    public void addMapObserver(MapObserver o) {
        observers.add(o);
        notifyObserversMapHasChanged();
    }

    private void notifyHostileNPC() {
        for (MapObserver o : observers) {
            o.receiveNonStealthAvatarPosition(avatarMovement.getPosition());
        }
    }

    private void notifyObserversMapHasChanged() {
        for (MapObserver o : observers) {
            o.receiveMap(this);
        }
    }

    public ArrayList<Tile> createLocalAreaAngular(int radius, Vector2 center) {
        ArrayList<Tile> tileList = new ArrayList<Tile>();
        boolean[][] visited = new boolean[getHeight()][getWidth()];
        Vector2 facingDir = getAvatarMovement().getFacingDir();
        ArrayList<Integer> list = returnIndex(facingDir);
        Queue<Tile> queue = new LinkedList<Tile>();
        Queue<Integer> ind = new LinkedList<Integer>();
        tileList.add(getTile(center));
        Tile currTile = getTileInDirection(facingDir, getTile(center));
        queue.add(currTile);
        ind.add(Direction.dirNum(Direction.facingDir(facingDir)));
        int count = 0;
        Tile tileToAdd = null;
        int tileOrientation = 0;
        int loops = 0;
        if (radius == 0) {
            return tileList;
        }
        if (radius == 1) {
            loops = 1;
        }
        if (radius == 2) {
            loops = 4;
        }
        if (radius == 3) {
            loops = 7;
        }
        if (radius == 4) {
            loops = 12;
        }
        if (radius == 5) {
            loops = 17;
        }
        if (radius == 6) {
            loops = 24;
        }
        if (radius == 7) {
            loops = 31;
        }
        while (!queue.isEmpty() && count < loops) {
            currTile = queue.remove();
            tileOrientation = ind.remove();
            tileList.add(currTile);
            for (int i = 0; i < list.size(); i++) {
                int index = list.get(i);
                if (count % 2 == 0) {
                    if (index == 0) {
                        tileToAdd = getTileToTheNorth(currTile);
                    }
                    if (index == 1) {
                        tileToAdd = getTileToTheNorthEast(currTile);
                    }
                    if (index == 2) {
                        tileToAdd = getTileToTheSouthEast(currTile);
                    }
                    if (index == 3) {
                        tileToAdd = getTileToTheSouth(currTile);
                    }
                    if (index == 4) {
                        tileToAdd = getTileToTheSouthWest(currTile);
                    }
                    if (index == 5) {
                        tileToAdd = getTileToTheNorthWest(currTile);
                    }
                } else {
                    if (index != tileOrientation || tileOrientation == 0 || tileOrientation == 3) {
                        if (index == 0) {
                            tileToAdd = getTileToTheNorth(currTile);
                        }
                        if (index == 1) {
                            tileToAdd = getTileToTheNorthEast(currTile);
                        }
                        if (index == 2) {
                            tileToAdd = getTileToTheSouthEast(currTile);
                        }
                        if (index == 3) {
                            tileToAdd = getTileToTheSouth(currTile);
                        }
                        if (index == 4) {
                            tileToAdd = getTileToTheSouthWest(currTile);
                        }
                        if (index == 5) {
                            tileToAdd = getTileToTheNorthWest(currTile);
                        }
                    }
                }
                int x = tileToAdd.getLocation().X;
                int y = tileToAdd.getLocation().Y;
                if (!visited[x][y]) {
                    queue.add(tileToAdd);
                    ind.add(index);
                    visited[x][y] = true;
                }

            }
            count++;
        }
        return tileList;
    }

    private ArrayList<Integer> returnIndex(Vector2 facingDir) {
        String s = Direction.facingDir(facingDir);
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (s == "NORTH") {
            list.add(0);
            list.add(1);
            list.add(5);
        }
        if (s == "NORTHEAST") {
            list.add(1);
            list.add(0);
            list.add(2);
        }
        if (s == "SOUTHEAST") {
            list.add(2);
            list.add(1);
            list.add(3);
        }

        if (s == "SOUTH") {
            list.add(3);
            list.add(2);
            list.add(4);
        }
        if (s == "SOUTHWEST") {
            list.add(4);
            list.add(3);
            list.add(5);
        }
        if (s == "NORTHWEST") {
            list.add(5);
            list.add(4);
            list.add(0);
        }
        return list;
    }

    public ArrayList<Tile> createLocalAreaRadial(int radius, Vector2 center) {
        ArrayList<Tile> list = new ArrayList();
        Tile t = getTile(center);
        Tile oldt = null;
        boolean addTile = true;
        list.add(t);
        for (int i = 0; i != radius; ++i) {
            for (int j = 0; j != i + 1; ++j) {
                oldt = t;
                t = getTileToTheNorth(center);
                if (oldt == t) {
                    addTile = false;
                    break;
                }
            }
            if (addTile) {
                list.add(t);
            } else {
                addTile = true;
            }
            t = getTile(center);

            for (int j = 0; j != i + 1; ++j) {
                oldt = t;
                t = getTileToTheNorthEast(center);
                if (oldt == t) {
                    addTile = false;
                    break;
                }
            }
            if (addTile) {
                list.add(t);
            } else {
                addTile = true;
            }
            t = getTile(center);

            for (int j = 0; j != i + 1; ++j) {
                oldt = t;
                t = getTileToTheSouthEast(center);
                if (oldt == t) {
                    addTile = false;
                    break;
                }
            }
            if (addTile) {
                list.add(t);
            } else {
                addTile = true;
            }
            t = getTile(center);

            for (int j = 0; j != i + 1; ++j) {
                oldt = t;
                t = getTileToTheSouth(center);
                if (oldt == t) {
                    addTile = false;
                    break;
                }
            }
            if (addTile) {
                list.add(t);
            } else {
                addTile = true;
            }
            t = getTile(center);

            for (int j = 0; j != i + 1; ++j) {
                oldt = t;
                t = getTileToTheSouthWest(center);
                if (oldt == t) {
                    addTile = false;
                    break;
                }
            }
            if (addTile) {
                list.add(t);
            } else {
                addTile = true;
            }
            t = getTile(center);

            for (int j = 0; j != i + 1; ++j) {
                oldt = t;
                t = getTileToTheSouthEast(center);
                if (oldt == t) {
                    addTile = false;
                    break;
                }
            }
            if (addTile) {
                list.add(t);
            } else {
                addTile = true;
            }
            t = getTile(center);//added
        }

        return list;

    }

}

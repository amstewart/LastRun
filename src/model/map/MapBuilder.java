package model.map;

import model.areaEffect.TeleportAreaEffect;
import model.entity.vehicle.Vehicle;
import model.terrain.Terrain;
import utility.ImageUtil;
import model.Vector2;
import model.tile.Tile;
import model.areaEffect.HealDamageAreaEffect;
import model.areaEffect.LevelUpAreaEffect;
import model.areaEffect.TakeDamageAreaEffect;
import model.item.ItemFactory;
import model.terrain.GrassTerrain;
import model.terrain.MountainTerrain;
import model.terrain.WaterTerrain;

import java.util.LinkedList;

public class MapBuilder {
    private Tile[][] tiles;
    private int width=30;
    private int height=30;
    private GameMap gameMap;

    public MapBuilder(GameMap gameMap){
        this.gameMap = gameMap;
    	//generateMapDebug();
    	//generateMapRandom();
        generateMapDemo();
    }

    public static void addVehicle(GameMap map, Vector2 pos, String name, String art_asset, int speed) {
        Vehicle vic = new Vehicle(art_asset, name, speed);
        vic.addTerrainMovement(Terrain.TerrainType.Mountain);
        map.addVehicle(vic, pos);
    }

    public void generateMapDemo() {
        tiles = new Tile[width][height];
        GrassTerrain grassTerrain = new GrassTerrain(ImageUtil.TERRAIN_GRASS);
        MountainTerrain mountainTerrain = new MountainTerrain(ImageUtil.TERRAIN_MOUNTAIN);
        WaterTerrain waterTerrain = new WaterTerrain(ImageUtil.TERRAIN_WATER);

        TakeDamageAreaEffect takeDamageAreaEffect = new TakeDamageAreaEffect(ImageUtil.CROSSBONE);
        LevelUpAreaEffect levelUpAreaEffect = new LevelUpAreaEffect(ImageUtil.GOLDSTAR);

        TeleportAreaEffect teleportAreaEffect = new TeleportAreaEffect(new Vector2(10,10));
        teleportAreaEffect.setAssetID(ImageUtil.REDCROSS);
        teleportAreaEffect.setGame(gameMap);

        for(int i = 0; i < width; i ++) {
            for(int j = 0; j < height; j++) {
                tiles[i][j] = new Tile(new Vector2(i, j));
                if ( j % 5 == 0 && i != j) {
                    tiles[i][j].addTerrain(mountainTerrain);
                } else if ( j > 5 && j < 10) {
                    tiles[i][j].addTerrain(waterTerrain);
                } else {
                    tiles[i][j].addTerrain(grassTerrain);
                }
                double chance = Math.random();
                if(chance > 0.90) {
                    tiles[i][j].addItem(ItemFactory.getRandomItem());
                }
            }
        }

        tiles[4][3].addAreaEffect(teleportAreaEffect);
        tiles[26][4].addItem(ItemFactory.newKey1());
        tiles[4][4].addItem(ItemFactory.newWaterWine());
        tiles[8][13].addItem(ItemFactory.newClosedChest());
    }

    public void generateMapDebug() {
        tiles = new Tile[width][height];

        LinkedList<Vector2> lmm = new LinkedList<>(); // list of mountain tile locations
        lmm.add(new Vector2(3,4));
        lmm.add(new Vector2(3,5));
        lmm.add(new Vector2(3,6));
        lmm.add(new Vector2(0,6));
        lmm.add(new Vector2(1,6));
        lmm.add(new Vector2(1,5));

        LinkedList<Vector2> lww = new LinkedList<>(); // list of water tile locations
        lww.add(new Vector2(4,5));
        lww.add(new Vector2(4,6));
        lww.add(new Vector2(5,5));
        lww.add(new Vector2(6,6));
        lww.add(new Vector2(6,7));
        lww.add(new Vector2(7,3));
        lww.add(new Vector2(8,4));

        for (int i = 0; i < width; i++) { // Init all tiles to grass
            for (int j = 0; j < height; j++) {
                tiles[i][j] = new Tile(new Vector2(i, j));
                tiles[i][j].addTerrain(new GrassTerrain(ImageUtil.TERRAIN_GRASS));
                double chance = Math.random();
                if(i != j && chance < 0.05){
                    tiles[i][j].addItem(ItemFactory.getRandomItem());
                }

            }
        }

        tiles[25][25].addItem(ItemFactory.newClosedChest());
        
        for (Vector2 loc : lmm) { // Add mountain terrains to map
            tiles[loc.X][loc.Y].addTerrain(new MountainTerrain(ImageUtil.TERRAIN_MOUNTAIN));
        }

        for (Vector2 loc : lww) { // Add water terrains to map
            tiles[loc.X][loc.Y].addTerrain(new WaterTerrain(ImageUtil.TERRAIN_WATER));
        }

        for (int i = 0; i < width; i++) { // Add items to grass tiles
            for (int j = 0; j < height; j++) {
                double chance = Math.random();
                if(tiles[i][j].getTerrain().getTerrainType().equals(Terrain.TerrainType.Grass) && chance < 0.05){
                    tiles[i][j].addItem(ItemFactory.getRandomItem());
                }
            }
        }

        tiles[2][2].addAreaEffect(new TakeDamageAreaEffect(ImageUtil.CROSSBONE));
        tiles[1][1].addAreaEffect(new LevelUpAreaEffect(ImageUtil.GOLDSTAR));
        tiles[6][4].addAreaEffect(new HealDamageAreaEffect(ImageUtil.REDCROSS));
        tiles[3][3].addTrap(new SpikeTrap(ImageUtil.SPIKETRAP));
    }
    
    public void generateMapRandom(){
        tiles= new Tile[width][height];
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                    Vector2 loc= new Vector2(i,j);
                    tiles[i][j]= new Tile(loc);
                    double randomTerrain = Math.random();
                    if(randomTerrain < 0.70){
                        tiles[i][j].addTerrain(new GrassTerrain(ImageUtil.TERRAIN_GRASS));
                    }else if(randomTerrain < 0.85){
                        tiles[i][j].addTerrain(new WaterTerrain(ImageUtil.TERRAIN_WATER));
                    }else{
                        tiles[i][j].addTerrain(new MountainTerrain(ImageUtil.TERRAIN_MOUNTAIN));
                    }
                    
                    double chance = Math.random();
                    if(chance < 0.05){
                        tiles[i][j].addItem(ItemFactory.getRandomItem());
                    }
            }
        }

        tiles[2][2].addAreaEffect(new TakeDamageAreaEffect(ImageUtil.CROSSBONE));
        tiles[1][1].addAreaEffect(new LevelUpAreaEffect(ImageUtil.GOLDSTAR));
        tiles[3][4].addAreaEffect(new HealDamageAreaEffect(ImageUtil.REDCROSS));

     
    }

    public Tile[][] getMap(){
    	return tiles;
    }
}

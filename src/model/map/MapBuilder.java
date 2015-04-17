/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

import model.Vector2;
import model.tile.Tile;
import model.areaEffect.TakeDamageAreaEffect;
import model.terrain.GrassTerrain;
import model.terrain.MountainTerrain;
import model.terrain.WaterTerrain;

import java.util.LinkedList;

/**
 *
 * @author
 */
public class MapBuilder {
    private Tile[][] tiles;
    private int width=30;
    private int height=30;

    public MapBuilder(){
    	generateMapDebug();
    	//generateMapRandom();
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

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                tiles[i][j] = new Tile(new Vector2(i, j));
                tiles[i][j].addTerrain(new GrassTerrain());
            }
        }

        for (Vector2 loc : lmm) {
            tiles[loc.X][loc.Y].addTerrain(new MountainTerrain());
        }
    }
    
    
    public void generateMapRandom(){
        tiles= new Tile[width][height];
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                    Vector2 loc= new Vector2(i,j);
                    tiles[i][j]= new Tile(loc);
                    double randomTerrain = Math.random();
                    if(randomTerrain < 0.70){
                        tiles[i][j].addTerrain(new GrassTerrain());
                    }else if(randomTerrain < 0.85){
                        tiles[i][j].addTerrain(new WaterTerrain());
                    }else{
                        tiles[i][j].addTerrain(new MountainTerrain());
                    }
            }
        }

        //tiles[0][0][0].setItem(new Item()); a type of item
        tiles[2][2].addAreaEffect(new TakeDamageAreaEffect());
    }

    public Tile[][] getMap(){
    	return tiles;
    }
    
   
}

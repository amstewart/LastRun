/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

import model.Vector2;
import model.tile.Tile;
import model.areaEffect.LevelUpAreaEffect;
import model.terrain.GrassTerrain;
import model.terrain.MountainTerrain;
import model.terrain.WaterTerrain;

/**
 *
 * @author
 */
public class MapBuilder {
    private Tile[][] tiles;
    private int width=30;
    private int height=30;



    public MapBuilder(){
    	generateMap();
    }
    
    
    public void generateMap(){
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
        tiles[0][0].addAreaEffect(new LevelUpAreaEffect());
    }

    public Tile[][] getMap(){
    	return tiles;
    }
    
   
}

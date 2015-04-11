/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

import model.Vector3;
import model.tile.Tile;
import model.areaEffect.LevelUpAreaEffect;
import model.terrain.GrassTerrain;
import model.terrain.MountainTerrain;
import model.terrain.RiverTerrain;

/**
 *
 * @author
 */
public class MapBuilder {
    private Tile[][] tiles;
    private int width=5;
    private int height=5;



    public MapBuilder(){
    	generateMap();
    }
    
    
    public void generateMap(){
        tiles= new Tile[width][height];
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                for(int k=0;k<height;k++){
                    Vector3 loc= new Vector3(i,j,k);
                    tiles[i][j]= new Tile(loc);
                    double randomTerrain = Math.random();
                    if(randomTerrain < 0.60){
                        tiles[i][j].addTerrain(new GrassTerrain());
                    }else if(randomTerrain < 0.85){
                        tiles[i][j].addTerrain(new RiverTerrain());
                    }else{
                        tiles[i][j].addTerrain(new MountainTerrain());
                    }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

import model.items.Item;

/**
 *
 * @author
 */
public class MapBuilder {
    private Tile[][][] tiles;
    private int length=10;
    private int width=10;
    private int height=10;



    public MapBuilder(){
    	generateMap();
    }
    
    
    public void generateMap(){
        tiles= new Tile[length][width][height];
        for(int i=0;i<length;i++){
            for(int j=0;j<width;j++){
                for(int k=0;k<height;k++){
                    Location loc= new Location(i,j,k);
                    tiles[i][j][k]= new Tile(new GrassTerrain(),loc);
                }
            }
        }

        //tiles[0][0][0].setItem(new Item()); a type of item
        tiles[0][0][0].setAreaEffect(new LevelUpAreaEffect());
    }

    public Tile[][][] getMap(){
    	return tiles;
    }
    
   
}

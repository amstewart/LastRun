/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

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
                        tiles[i][j].addTerrain(new GrassTerrain(ImageUtil.GrassTerrain));
                    }else if(randomTerrain < 0.85){
                        tiles[i][j].addTerrain(new WaterTerrain(ImageUtil.WaterTerrain));
                    }else{
                        tiles[i][j].addTerrain(new MountainTerrain(ImageUtil.MountainTerrain));
                    }
                    
                    double chance = Math.random();
                    if(chance < 0.05){
                        tiles[i][j].addItem(ItemFactory.getRandomItem());
                    }
            }
        }

      tiles[2][2].addAreaEffect(new TakeDamageAreaEffect(ImageUtil.Crossbone));
      tiles[1][1].addAreaEffect(new LevelUpAreaEffect(ImageUtil.GoldStar));
      tiles[3][4].addAreaEffect(new HealDamageAreaEffect(ImageUtil.RedCross));
    }

    public Tile[][] getMap(){
    	return tiles;
    }
    
   
}

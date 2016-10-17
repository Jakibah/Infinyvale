package com.jakibah.infinyvale;

import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.opengl.Display;

import com.jakibah.infinyvale.enums.ItemType;
import com.jakibah.infinyvale.enums.TileType;

public class Chunk {

	   public Tile[][] map;
	   private int TilesWide, TileHeight;
	   public ArrayList<Item> items = new ArrayList<Item>();
	   public ArrayList<Item> itemstoremove = new ArrayList<Item>();
	   private int ID;
	   private int[][] newMap;

	   public Chunk(int ID) {
	        this.ID = ID;
	      this.TilesWide = Display.getWidth() / 32;
	      this.TileHeight = Display.getHeight() / 32;
	      map = new Tile[TilesWide][TileHeight];
	      Random r = new Random();
	      //TODO Item in chunk system 
	      //items.add(new Item(ItemType.Weapon, Canvas.QuickLoad("testitem32"), r.nextInt(Display.getWidth() - 32), r.nextInt(Display.getHeight() - 32), this, 32, 100, 1));
	      
	      for (int i = 0; i < map.length; i++) {
	         for (int j = 0; j < map[i].length; j++) {
	            //TODO map generation
	        	//int test = r.nextInt(2);
	        	 int test = 0;
	            switch(test){
	            case 0:
	            	 map[i][j] = new Tile(TileType.Grass, i * 32, j * 32, 32);
	            	 break;
	            case 1:  
	            	map[i][j] = new Tile(TileType.Test2, i * 32, j * 32, 32);
	                 break;
	            }
	        	
	         }
	      }
	   }

	   public Chunk(int[][] newMap, int ID) {
	      this.ID = ID;
	      this.TilesWide = newMap.length;
	      this.TileHeight = newMap[0].length;
	      this.newMap = newMap;
	      map = new Tile[TilesWide][TileHeight];
	      Random r = new Random();
	      //TODO Item in chunk system 
	      //items.add(new Item(ItemType.Weapon, Canvas.QuickLoad("testitem32"), r.nextInt(Display.getWidth() - 32), r.nextInt(Display.getHeight() - 32), this, 32, 100, 1));
	      for (int i = 0; i < map.length; i++) {
	         for (int j = 0; j < map[i].length; j++) {
	            switch (newMap[i][j]) {
	            case 0:
	               map[i][j] = new Tile(TileType.Grass, i * 32, j * 32, 32);
	               break;
	            case 1:
	               map[i][j] = new Tile(TileType.Test2, i * 32, j * 32, 32);
	               break;
	            }

	         }
	      }
	   }

	   public void HandleItems() {
	      items.removeAll(itemstoremove);
	      itemstoremove.clear();
	      if (!items.isEmpty()) {
	         for (Item i : items) {
	            i.Update();
	         }
	      }
	   }

	   public Tile GetTile(int xplace, int yplace) {

	      if (xplace < TilesWide && yplace < TileHeight && xplace > -1
	            && yplace > -1)
	         return map[xplace][yplace];
	      else
	         return null;
	   }

	   public void Update() {
	      for (int i = 0; i < map.length; i++) {
	         for (int j = 0; j < map[i].length; j++) {
	            Tile t = map[i][j];
	            t.Update();
	         }
	      }
	      HandleItems();
	   }

	   public Tile[][] getMap() {
	      return map;
	   }

	   public void setMap(Tile[][] map) {
	      this.map = map;
	   }

	   public int getTilesWide() {
	      return TilesWide;
	   }

	   public void setTilesWide(int tilesWide) {
	      TilesWide = tilesWide;
	   }

	   public int getTileHeight() {
	      return TileHeight;
	   }

	   public void setTileHeight(int tileHeight) {
	      TileHeight = tileHeight;
	   }

	   public ArrayList<Item> getItems() {
	      return items;
	   }

	   public void setItems(ArrayList<Item> items) {
	      this.items = items;
	   }

	   public int getID() {
	      return ID;
	   }

	   public void setID(int iD) {
	      ID = iD;
	   }

	   public int[][] getNewMap() {
	      return newMap;
	   }

	   public void setNewMap(int[][] newMap) {
	      this.newMap = newMap;
	   }

}

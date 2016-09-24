package com.jakibah.infinyvale;

import com.jakibah.infinyvale.enums.TileType;

public class Chunk {

	public Tile[][] map;
	private int TilesWide, TileHeight;
	public Item[] items;

	public Chunk() {
		this.TilesWide = 20;
		this.TileHeight = 15;
		map = new Tile[TilesWide][TileHeight];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = new Tile(TileType.Test, i * 32, j * 32, 32);
			}
		}
	}

	public Chunk(int[][] newMap) {
		this.TilesWide = newMap[0].length;
		this.TileHeight = newMap.length;
		map = new Tile[TilesWide][TileHeight];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				switch (newMap[j][i]) {
				case 0:
					map[i][j] = new Tile(TileType.Test, i * 32, j * 32, 32);
					break;
				}

			}
		}
	}

	public void HandleItems() {
		for (Item i : items) {
			i.Update();
		}
	}

	public Tile GetTile(int xplace, int yplace) {

		if (xplace < TilesWide && yplace < TileHeight && xplace > -1 && yplace > -1)
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
	}

}
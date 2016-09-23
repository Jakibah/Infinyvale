package com.jakibah.infinyvale;

import org.newdawn.slick.opengl.Texture;

import com.jakibah.infinyvale.enums.TileType;

public class Tile {
	
	private Texture tex;
	private boolean solid;
	private int x;
	private int y;
	private int texturefactor;
	private TileType type;

	public Tile(TileType type,int x, int y, int texturefactor){
		this.tex = type.tex;
		this.solid = type.solid;
		this.x = x;
		this.y = y;
		this.texturefactor= texturefactor;
	}
	
	public void Draw(){
		Canvas.DrawQuadTex(tex, x, y, texturefactor, texturefactor);
		//System.out.println("Drawing tile");
	}
	
	public void Update(){
		Draw();
	}

}

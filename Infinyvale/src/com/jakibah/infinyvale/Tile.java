package com.jakibah.infinyvale;

import org.newdawn.slick.opengl.Texture;

public class Tile {
	
	private Texture tex;
	private boolean solid;
	private int x;
	private int y;
	private int texturefactor;

	public Tile(Texture tex, boolean solid, int x, int y, int texturefactor){
		this.tex = tex;
		this.solid = solid;
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

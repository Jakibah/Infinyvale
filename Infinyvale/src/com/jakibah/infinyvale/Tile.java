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

	public Tile(TileType type, int x, int y, int texturefactor) {
		this.tex = type.tex;
		this.solid = type.solid;
		this.x = x;
		this.y = y;
		this.texturefactor = texturefactor;
	}

	public void Draw() {
		Canvas.DrawQuadTex(tex, x, y, texturefactor, texturefactor);
		// System.out.println("Drawing tile");
	}

	public void Update() {
		Draw();
	}

	public Texture getTex() {
		return tex;
	}

	public void setTex(Texture tex) {
		this.tex = tex;
	}

	public boolean isSolid() {
		return solid;
	}

	public void setSolid(boolean solid) {
		this.solid = solid;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getTexturefactor() {
		return texturefactor;
	}

	public void setTexturefactor(int texturefactor) {
		this.texturefactor = texturefactor;
	}

	public TileType getType() {
		return type;
	}

	public void setType(TileType type) {
		this.type = type;
	}

}

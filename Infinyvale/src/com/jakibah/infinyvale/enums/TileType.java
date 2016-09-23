package com.jakibah.infinyvale.enums;

import org.newdawn.slick.opengl.Texture;

import com.jakibah.infinyvale.Canvas;

public enum TileType {

	Test(Canvas.QuickLoad("testtile32"), false);

	public Texture tex;
	public boolean solid;

	TileType(Texture texturename, boolean solid) {
		this.tex = texturename;
		this.solid = solid;
	}
}

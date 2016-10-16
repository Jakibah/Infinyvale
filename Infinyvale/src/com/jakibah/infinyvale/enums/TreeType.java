package com.jakibah.infinyvale.enums;

import org.newdawn.slick.opengl.Texture;

import com.jakibah.infinyvale.Canvas;

public enum TreeType {
	
	AppleTree(Canvas.QuickLoad("testplayer32"), Canvas.QuickLoad("testitem32"), Canvas.QuickLoad("test2tile32"));
	
	public Texture lowertrunk;
	public Texture trunk;
	public Texture leaves;
	
	TreeType(Texture lowertrunk, Texture trunk, Texture leaves) {
		this.lowertrunk = lowertrunk;
		this.trunk = trunk;
		this.leaves = leaves;
	}

}

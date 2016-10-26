package com.jakibah.infinyvale.enums;

import org.newdawn.slick.opengl.Texture;

import com.jakibah.infinyvale.Canvas;

public enum TreeType {
	
	AppleTree(Canvas.QuickLoad("flora/appletree/appletreeleaves"), Canvas.QuickLoad("flora/appletree/appletreetrunk"), Canvas.QuickLoad("flora/appletree/appletreelowertrunk"));
	
	public Texture lowertrunk;
	public Texture trunk;
	public Texture leaves;
	
	TreeType(Texture leaves, Texture trunk, Texture lowertrunk) {
		this.lowertrunk = lowertrunk;
		this.trunk = trunk;
		this.leaves = leaves;
	}

}

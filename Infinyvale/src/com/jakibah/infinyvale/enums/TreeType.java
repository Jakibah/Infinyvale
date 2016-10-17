package com.jakibah.infinyvale.enums;

import org.newdawn.slick.opengl.Texture;

import com.jakibah.infinyvale.Canvas;

public enum TreeType {
	
	AppleTree(Canvas.QuickLoad("appletreeleaves3264"), Canvas.QuickLoad("appletreetrunk32"), Canvas.QuickLoad("appletreelowertrunk32"));
	
	public Texture lowertrunk;
	public Texture trunk;
	public Texture leaves;
	
	TreeType(Texture lowertrunk, Texture trunk, Texture leaves) {
		this.lowertrunk = lowertrunk;
		this.trunk = trunk;
		this.leaves = leaves;
	}

}

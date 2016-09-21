package com.jakibah.infinyvale;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Canvas {

	public static void CreateCanvas(int width, int height, String title){
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
		    Display.setTitle(title);
		    Display.create();
		    
		
		} catch (LWJGLException e) {
			e.printStackTrace();
		    Display.destroy();
		    System.exit(1);
		}
		Game.Start();
		while(!Display.isCloseRequested()) {
			Display.update();
			Display.sync(60);
			Game.Update();
		}
		Game.Stop();
		Display.destroy();
		System.exit(0);
	}
}

package com.jakibah.infinyvale;

import java.io.IOException;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import com.jakibah.infinyvale.debug.Debug;

public class Game {

	

	public static Player p = null;
	public static Inventory i = null;
	public static World world = null;
	public static Textdrawer Cardinal = new Textdrawer("Cardinal"); 
	public static Textdrawer VCR_OSD_MONO = new Textdrawer("VCR_OSD_MONO", 15);
	
	
	

	

	public static void Start() {
		System.out.println("Starting...");
		//TODO set health from save
		Speech.Start();
		p = new Player(Canvas.QuickLoad("character/testplayer"),
				(Display.getWidth() / 2) - 16, (Display.getHeight() / 2) - 32,
				32, 2, 4, 3, 5);
		
		i = new Inventory(p);

		try {
			world = new World("testworld");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			world.Update();
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	
	}

	public static void Update() {
        Debug.Update();
		try {
			world.Update();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		p.Update();
		
		//System.out.println(Time.CurrentSeconds());
        //System.out.println(world.getChunktoLoad().GetTile(0, 0).getX());
	}

	public static void Stop() {
		//FIXME stop auto world reset
		world.getFile().delete();
		
		System.out.println("Stopping...");
       
	}

}

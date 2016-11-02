package com.jakibah.infinyvale;

import java.io.IOException;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import com.jakibah.infinyvale.enums.ItemType;
import com.jakibah.infinyvale.enums.TreeType;
import com.jakibah.infinyvale.flora.Tree;

public class Game {

	

	public static Player p = null;
	public static Inventory i = null;
	public static World world = null;
	public static Item item = null;
	public static Item item2 = null;
	
	

	

	public static void Start() {
		System.out.println("Starting...");
		p = new Player(Canvas.QuickLoad("character/testplayer"),
				(Display.getWidth() / 2) - 16, (Display.getHeight() / 2) - 32,
				32, 2, 4);
		
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
		
		
		
		item2 = new Item(ItemType.Weapon, Canvas.QuickLoad("tiles/test2tile"), 150, 142, 32, 100, 3);
		item = new Item(ItemType.Weapon, Canvas.QuickLoad("items/testitem"), 360, 420, 32, 100, 3);
		
		
	
	}

	public static void Update() {
        
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

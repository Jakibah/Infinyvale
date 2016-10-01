package com.jakibah.infinyvale;

import org.lwjgl.opengl.Display;

import com.jakibah.infinyvale.enums.ItemType;

public class Game {

	static Player p = null;
	static Inventory i = null;
	static World world = null;
	static Item testitem = null;

	public static void main(String[] args) {
		Canvas.CreateCanvas(640, 480, "Infinyvale", 60);

	}

	public static void Start() {
		System.out.println("Starting...");
		p = new Player(Canvas.QuickLoad("testplayer32"),
				(Display.getWidth() / 2) - 16, (Display.getHeight() / 2) - 32,
				32, 2, 4);
		i = new Inventory(p);
		world = new World(40);
		testitem = new Item(ItemType.Weapon, Canvas.QuickLoad("testitem32"),
				103, 320, world, 32, 99, 1);
	}

	public static void Update() {
		world.Update();
		p.Update();

	}

	public static void Stop() {
		System.out.println("Stopping...");

	}

}

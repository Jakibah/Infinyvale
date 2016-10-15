package com.jakibah.infinyvale;

import java.io.IOException;

import org.lwjgl.opengl.Display;

public class Game {

	static Player p = null;
	static Inventory i = null;
	static World world = null;

	public static void main(String[] args) {
		Canvas.CreateCanvas(640, 480, "Infinyvale", 60);

	}

	public static void Start() {
		System.out.println("Starting...");
		p = new Player(Canvas.QuickLoad("testplayer32"),
				(Display.getWidth() / 2) - 16, (Display.getHeight() / 2) - 32,
				32, 2, 4);
		
		i = new Inventory(p);

		try {
			world = new World("testworld");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void Update() {

		try {
			world.Update();
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.Update();

	}

	public static void Stop() {
		System.out.println("Stopping...");

	}

}

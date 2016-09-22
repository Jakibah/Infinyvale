package com.jakibah.infinyvale;

import org.lwjgl.opengl.Display;

public class Game {
	
	static Player p1 = null;
	

	public static void main(String[] args) {
		Canvas.CreateCanvas(640, 480, "Infinyvale", 60);

	}

	public static void Start() {
		System.out.println("Starting...");
		p1 = new Player(Canvas.QuickLoad("testplayer32"), Display.getWidth() / 2, Display.getHeight() / 2, 32, 2, 4);
		
		

	}

	public static void Update() {
		
		p1.Update();
		
	}

	public static void Stop() {
		System.out.println("Stopping...");

	}

}

package com.jakibah.infinyvale;

import org.lwjgl.input.Mouse;

public class Game {

	static Player p1 = null;
	static Chunk c1 = null;

	public static void main(String[] args) {
		Canvas.CreateCanvas(640, 480, "Infinyvale", 60);

	}

	public static void Start() {
		System.out.println("Starting...");
		p1 = new Player(Canvas.QuickLoad("testplayer32"), 0, 0, 32, 2, 4);
		c1 = new Chunk();

	}

	public static void Update() {
		c1.Update();
		p1.Update();
		System.out.println("Mouse: " + Mouse.getY());
		System.out.println("Player: " + p1.getY());
        System.out.println(Canvas.isColliding(p1.getX(), p1.getY(), p1.getX() + 32, p1.getY() + 32, Mouse.getX(), Mouse.getY()));
	}

	public static void Stop() {
		System.out.println("Stopping...");

	}

}

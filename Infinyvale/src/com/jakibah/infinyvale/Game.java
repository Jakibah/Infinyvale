package com.jakibah.infinyvale;

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

	}

	public static void Stop() {
		System.out.println("Stopping...");

	}

}

package com.jakibah.infinyvale;

public class Game {
	
	static Player p1 = null;
	static InputHandler p1handler = null;

	public static void main(String[] args) {
		Canvas.CreateCanvas(640, 480, "Infinyvale", 60);

	}

	public static void Start() {
		System.out.println("Starting...");
		p1 = new Player(Canvas.QuickLoad("test32"), 0, 0, 32, 2, 4);
		p1handler = new InputHandler(p1);

	}

	public static void Update() {
		p1handler.Update();
		p1.Update();
	}

	public static void Stop() {
		System.out.println("Stopping...");

	}

}

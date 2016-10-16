package com.jakibah.infinyvale;

import java.io.IOException;

import org.lwjgl.opengl.Display;

import com.jakibah.infinyvale.enums.TreeType;
import com.jakibah.infinyvale.flora.Tree;

public class Game {

	static Player p = null;
	static Inventory i = null;
	static World world = null;
	static Tree t = null;
	

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
		t = new Tree(TreeType.AppleTree, 150, 136, 32, true, 0, null);

	}

	public static void Update() {

		try {
			world.Update();
		} catch (IOException e) {
			e.printStackTrace();
		}
		t.Update();
		
		p.Update();

	}

	public static void Stop() {
		System.out.println("Stopping...");

	}

}

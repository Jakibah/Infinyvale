package com.jakibah.infinyvale;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Inventory {
	private ArrayList<BagItem> inventory;
	private Player p;
	private BagItem equiped;
	private boolean open = false;
	private boolean Idown = false;

	public Inventory(Player p) {
		this.p = p;
		inventory = new ArrayList<BagItem>(216);
		p.setI(this);
	}

	public void Update() {
		//Draw();
		if (inventory.isEmpty()) {

		} else {
			setEquiped(inventory.get(0));

		}

	}

	int columns = 6;
	int rows = 5;
	int[][] inventorygui = new int[rows][columns];

	public void Draw() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < inventorygui[i].length; j++) {
				Canvas.DrawQuadTex(Canvas.QuickLoad("itemholder32"), i * 32, j * 32, 32, 32);
			}
		}
	}

	public ArrayList<BagItem> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<BagItem> inventory) {
		this.inventory = inventory;
	}

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

	public BagItem getEquiped() {
		return equiped;
	}

	public void setEquiped(BagItem equiped) {
		this.equiped = equiped;
	}

}

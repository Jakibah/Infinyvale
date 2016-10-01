package com.jakibah.infinyvale;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<BagItem> inventory;
	private Player p;
	private BagItem equiped;

	public Inventory(Player p) {
		this.p = p;
		inventory = new ArrayList<BagItem>(216);
		p.setI(this);
	}

	public void Update() {
		if (inventory.isEmpty()) {
			// i do nothing
		} else {
			setEquiped(inventory.get(0));
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

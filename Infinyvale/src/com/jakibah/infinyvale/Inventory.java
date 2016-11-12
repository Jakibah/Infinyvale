package com.jakibah.infinyvale;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Inventory {

	private BagItem[] inventory = new BagItem[60];
	private BagItem equiped;
	private boolean open = false;
	private boolean keydown = false;
	private Player p;

	public Inventory(Player p) {
		this.p = p;
		p.setI(this);
	}

	public void Remove(BagItem bagItem) {
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] == bagItem) {
				inventory[i] = null;
				for(int j = 0; j < inventory.length; j++){
					if(j+1 < 60){
					inventory[j] = inventory[j + 1];
					inventory[j + 1] = null;
				}
				}
				break;
			}
		}

	}

	public void Add(BagItem bagItem) {
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] == null) {
				inventory[i] = bagItem;
				break;
			}
		}

	}

	public void Update() {
		if (inventory[0] != null) {
			setEquiped(inventory[0]);

		}
		for (BagItem i : inventory) {
			if (i != null) {
				i.Update();
			}

		}
		if (!keydown && Keyboard.isKeyDown(Keyboard.KEY_I)) {
			open = true;
			keydown = true;
		}
		if (!Keyboard.isKeyDown(Keyboard.KEY_I)) {

			keydown = false;
		}

		while (open) {

			Display.update();
			Draw();
			if (!keydown && Keyboard.isKeyDown(Keyboard.KEY_I)) {
				keydown = true;
				open = false;
			}
			if (!Keyboard.isKeyDown(Keyboard.KEY_I)) {
				keydown = false;

			}

		}

	}

	private void setEquiped(BagItem bagItem) {
		this.equiped = bagItem;

	}

	public void Draw() {
        int drawtime = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 6; j++) {
				
				Canvas.DrawQuadTex(Canvas.QuickLoad("inventory/itemholder"), Display.getWidth() / 4 + i * 32, Display.getHeight() / 4 + j * 32, 32, 32);
				if(inventory[drawtime] != null){
					Canvas.DrawQuadTex(inventory[drawtime].getTex(), Display.getWidth() / 4 + i * 32, Display.getHeight() / 4 + j * 32, 32, 32);
				    //System.out.println("drawn: " + drawtime);
				}
				drawtime ++;
				//System.out.println(drawtime);
			}
		}

	}

	public BagItem getEquiped() {
		return equiped;
	}

	public BagItem[] getInventory() {
		return inventory;
	}

	public void setInventory(BagItem[] inventory) {
		this.inventory = inventory;
	}

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

}
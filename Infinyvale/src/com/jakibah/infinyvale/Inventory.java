package com.jakibah.infinyvale;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Inventory {

	int columns = 10;
	int rows = 6;
	private Player p;
	private BagItem equiped;
	private boolean open = false;
	private boolean keydown = false;
	private BagItem[][] inventory = new BagItem[columns][rows];
	
	
	public Inventory(Player p) {
		
		this.p = p;
		p.setI(this);
	}

	public void Update() {
		for(int i = 0; i < inventory.length; i++){
			for(int j = 0; j < inventory[i].length; j++){
				if(inventory[i][j] != null){
					inventory[i][j].Update();
				}
			}
			}
		
		if (inventory[0][0] == null) {
            inventory[0][0] = null;
		} else {
			setEquiped(inventory[0][0]);

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

	public void Add(BagItem ToAdd){
		outerloop:
		for(int i = 0; i < inventory.length; i++){
			for(int j = 0; j < inventory[i].length; j++){
				if(inventory[i][j] == null){
					inventory[i][j] = ToAdd;
					break outerloop;
				
				
				}
			}
		}
	}
	public void Remove(BagItem ToRemove){
		outerloop:
		for(int i = 0; i < inventory.length; i++){
			for(int j = 0; j < inventory[i].length; j++){
				if(inventory[i][j] == ToRemove){
					inventory[i][j] = null;
					inventory[i][j] = inventory[i][j + 1];
					inventory[i][j + 1] = null;
					break outerloop;
				
				
				}
			}
		}
	}
	
	

	public void Draw() {
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				Canvas.DrawQuadTex(Canvas.QuickLoad("inventory/itemholder"), Display.getWidth() / 4 + i * 32, Display.getHeight() / 4 + j * 32, 32, 32);
				if(inventory[i][j] != null){
					Canvas.DrawQuadTex(inventory[i][j].getTex(), Display.getWidth() / 4 + i * 32, Display.getHeight() / 4 + j * 32, inventory[i][j].getTexturefactor(), inventory[i][j].getTexturefactor());
				}
			}
		}
		Canvas.DrawQuadTex(Canvas.QuickLoad("inventory/itemholder"), Display.getWidth() / 4 * 3, Display.getHeight() / 4, columns * 32 / 2, rows  * 32);
	}

	public BagItem[][] getInventory() {
		return inventory;
	}

	public void setInventory(BagItem[][] inventory) {
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

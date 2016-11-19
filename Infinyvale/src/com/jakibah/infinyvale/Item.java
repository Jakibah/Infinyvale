package com.jakibah.infinyvale;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.opengl.Texture;

import com.jakibah.infinyvale.lists.Items;

public class Item {
	private Texture tex;
	private int x, y;
	private int texturefactor;
	private String name;
	private Textdrawer td = Game.Cardinal;
	private Rectangle Collider;
	

	public Item(String name, Texture tex, int x, int y, int texturefactor) {
		this.tex = tex;
		this.name = name;
		this.x = x;
		this.y = y;
		this.texturefactor = texturefactor;
		Collider = new Rectangle(x, y, texturefactor, texturefactor);
	}

	public void Draw() {
		Canvas.DrawQuadTex(tex, x, y, texturefactor, texturefactor);
	}

	public void Update() {
		Draw();
		CheckPickUp();

	}

	public void CheckPickUp() {
		Inventory i = null;
		i = Game.p.getI();
		
			if (Canvas.isColliding(Game.p.getCollider(), this.getCollider())) {
				// System.out.println("Colliding");
				if (i.getInventory()[59] == null) {
				td.Draw(0, 0, "Press E to pick up.");
				if (Keyboard.isKeyDown(Keyboard.KEY_E)) {
					this.ToBag();
				}
			}else{
				td.Draw(0, 0, "Inventory is full.");
			}
		} 
	}

	public void ToBag() {
		Inventory i = null;
		i = Game.p.getI();
		RemoveFromList();
		i.Add(Items.get(this.getName()));
	}

	public void RemoveFromList() {
		Game.world.getChunktoLoad().itemstoremove.add(this);
	}

	

	public Texture getTex() {
		return tex;
	}

	public void setTex(Texture tex) {
		this.tex = tex;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getTexturefactor() {
		return texturefactor;
	}

	public void setTexturefactor(int texturefactor) {
		this.texturefactor = texturefactor;
	}

	public Rectangle getCollider() {
		return Collider;
	}

	public String getName() {
		return name;
	}

	public void setName(String nametoset) {
		name = nametoset;
	}

}

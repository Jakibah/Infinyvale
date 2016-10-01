package com.jakibah.infinyvale;

import org.newdawn.slick.opengl.Texture;

import com.jakibah.infinyvale.enums.ItemType;

public class Item {
	private ItemType type;
	private Texture tex;
	private int x, y;
	private World w;
	private int texturefactor;
	private int durability;
	private int power;

	public Item(ItemType type, Texture tex, int x, int y, World w,int texturefactor, int durability, int power) {
		this.type = type;
		this.tex = tex;
		this.x = y;
		this.y = y;
		this.w = w;
		this.texturefactor = texturefactor;
		this.durability = durability;
		this.power = power;
		this.w.getItems().add(this);
	}

	public void Draw() {
		Canvas.DrawQuadTex(tex, x, y, texturefactor, texturefactor);
	}

	public void Update() {
		Draw();
		CheckPickUp();
	}
	public void CheckPickUp(){
		if(Canvas.isColliding(Game.p.getX(), Game.p.getY(), Game.p.getX() + 32, Game.p.getY() - 32, x, y));
	    System.out.println("Colliding");
		this.ToBag();
	}

	public void ToBag() {
		Inventory i = null;
		i = Game.p.getI();
		Game.world.getItems().remove(this);
		i.getInventory().add(new BagItem(type, i, tex, texturefactor, durability, power));
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
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

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

}

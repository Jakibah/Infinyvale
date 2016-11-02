package com.jakibah.infinyvale;

import org.newdawn.slick.opengl.Texture;

import com.jakibah.infinyvale.enums.ItemType;

public class BagItem {

	private ItemType type;
	private Texture tex;
	private int texturefactor;
	private int durability;
	private int power;
	private Inventory i;

	public BagItem(ItemType type, Inventory i, Texture tex, int texturefactor,
			int durability, int power) {
		this.i = i;
		this.type = type;
		this.tex = tex;
		this.texturefactor = texturefactor;
		this.durability = durability;
		this.power = power;
	}

	public void Update() {
		DurabilityCheck();
	}

	public void DurabilityCheck() {
		if (this.getDurability() <= 0) {
			Destroy();
		}
	}

	public void Use() {
		this.setDurability(this.getDurability() - 1);
		System.out.println("Used Item durability is now: " + this.getDurability());
		// override me
	}

	public void Destroy() {
		this.getI().Remove(this);
		System.out.println("Destroyed equiped");
		// override me
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

	public Inventory getI() {
		return i;
	}

	public void setI(Inventory i) {
		this.i = i;
	}

}

package com.jakibah.infinyvale.items;

import org.newdawn.slick.opengl.Texture;

import com.jakibah.infinyvale.BagItem;
import com.jakibah.infinyvale.Canvas;
import com.jakibah.infinyvale.Game;
import com.jakibah.infinyvale.Inventory;
import com.jakibah.infinyvale.enums.ItemType;

public class HealPotion extends BagItem{

	public HealPotion(ItemType type, Inventory i, Texture tex, int texturefactor, int durability, int power) {
		super(type, i, tex, texturefactor, durability, power);
		this.setType(ItemType.Consumable);
		this.setI(Game.p.getI());
		this.setTex(Canvas.QuickLoad("items/healpotion"));
		//this.setTex(Canvas.QuickLoad("items/testitem"));
		this.setTexturefactor(32);
		this.setDurability(1);
		this.setPower(3);
		
	}
	@Override
	public void Destroy(){
		super.Destroy();
		//TODO Heal Player
		System.out.println("healed: " + this.getPower() + " hearts");
	}
	

	

}

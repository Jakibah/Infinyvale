package com.jakibah.infinyvale.monsters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.opengl.Texture;

import com.jakibah.infinyvale.Canvas;
import com.jakibah.infinyvale.Chunk;
import com.jakibah.infinyvale.Game;
import com.jakibah.infinyvale.Item;
import com.jakibah.infinyvale.Monster;
import com.jakibah.infinyvale.World;

public class Wasp extends Monster {
	private Texture tex;
	private Rectangle Collider;
    private int goalx = 0;
    private int goaly = 0;
    private Audio Walk = Canvas.QuickLoadAudio("monsters/beewalk");
	//set only x,y
	public Wasp(Texture tex, int x, int y, int texturefactor, int basedamage, int health, Item drop) {
		super(x, y, texturefactor, basedamage, health, drop);
		this.setBasedamage(1);
		drop = (new Item("HealPotion", Canvas.QuickLoad("items/healpotion"), this.x, this.y, 32));
		//TODO change wasp drop.
		this.setDrop(drop);
		this.setHealth(2);
		this.setTexturefactor(64);
		tex = (Canvas.QuickLoad("monsters/wasp"));
		this.tex = tex;
		Collider = new Rectangle(x, y, texturefactor / 2, texturefactor / 2);
		
		
		
	}
	
	public void Draw(){
		float angle = Canvas.LookAt(this.x, this.y, goalx, goaly);
		Canvas.DrawQuadTexRot(tex, this.x, this.y, texturefactor, texturefactor, angle);
		if(!Walk.isPlaying()){
		Walk.playAsSoundEffect(1, 1, false);
	}
	}
	@Override
	public void Update(){
		super.Update();
		Draw();
	}
	
	@Override
	public void Die(){
		this.getDrop().setX(this.x);
		this.getDrop().setY(this.y);
		this.getDrop().getCollider().setX(this.x);
		this.getDrop().getCollider().setY(this.y);
		Game.world.getChunktoLoad().items.add(drop);
		Game.world.getChunktoLoad().monstertoremove.add(this);
	}
	boolean retreat = false;
	int ranx = 0, rany = 0;
	@Override
	public void AI(){
		super.AI();
		Collider = new Rectangle(x, y, texturefactor / 2, texturefactor / 2);
		
		
		Random r = new Random();
		if(!retreat && this.x < Game.p.getX()){
			this.setX(this.getX()+2);
		}
		if(!retreat && this.x > Game.p.getX()){
			this.setX(this.getX()-2);
		}
		if(!retreat && this.y > Game.p.getY()){
			this.setY(this.getY()-2);
		}
		if(!retreat && this.y < Game.p.getY()){
			this.setY(this.getY()+2);
		}
		goalx = Game.p.getX();
		goaly = Game.p.getY();
		if(!retreat && Canvas.isColliding(this.Collider, Game.p.getCollider())){
			retreat = true;
			ranx = r.nextInt(Display.getWidth() + 1);
			rany = r.nextInt(Display.getHeight() + 1);
			Game.p.Damage(basedamage);
			//System.out.println("ranx: " + ranx + " rany: " + rany);
		}
		if(retreat){
			if(this.x < ranx){
				this.setX(this.getX()+1);
			}
			if(this.x > ranx){
				this.setX(this.getX()-1);
			}
			if(this.y > rany){
				this.setY(this.getY()-1);
			}
			if(this.y < rany){
				this.setY(this.getY()+1);
			}
			goalx = ranx;
			goaly = rany;
			if(this.x == ranx && this.y == rany){
				retreat = false;
				System.out.println("reached " + "ranx: " + ranx + " rany: " + rany);
			}
		}
		
	}

	public Texture getTex() {
		return tex;
	}

	public void setTex(Texture tex) {
		this.tex = tex;
	}
   
}

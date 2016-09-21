package com.jakibah.infinyvale;

import org.newdawn.slick.opengl.Texture;

public class Player {
	
	private Texture tex;
	private int x, y, texturefactor, walkspeed, runspeed, speed;
	
	
	public Player(Texture tex, int x, int y, int texturefactor, int walkspeed, int runspeed){
		this.tex = tex;
		this.x = x;
		this.y = y;
		this.texturefactor = texturefactor;
		this.walkspeed = walkspeed;
		this.runspeed = runspeed;
		speed = this.walkspeed;
	}
	
	public void Draw(){
		Canvas.DrawQuadTex(tex, x, y, texturefactor, texturefactor);
	}
	
	public void Update(){
		Draw();
		
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getRunspeed() {
		return runspeed;
	}

	public void setRunspeed(int runspeed) {
		this.runspeed = runspeed;
	}

	public int getWalkspeed() {
		return walkspeed;
	}

	public void setWalkspeed(int walkspeed) {
		this.walkspeed = walkspeed;
	}

}

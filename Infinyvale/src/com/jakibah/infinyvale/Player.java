package com.jakibah.infinyvale;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.opengl.Texture;

public class Player {

	private Texture tex;
	private int x, y, texturefactor, walkspeed, runspeed, speed;
	private int direction = 2;
	private boolean walking = false;
	private boolean running = false;
	private Inventory i;
	private Rectangle Collider;
	public boolean blocknorth = false, blockeast = false, blocksouth = false, blockwest = false;
	private boolean click0down = false;
	private int Health;
	private int maxHealth;
	private Texture EmptyHeart, Heart;

	public Player(Texture tex, int x, int y, int texturefactor, int walkspeed, int runspeed, int health, int maxhealth) {
		this.tex = tex;
		this.x = x;
		this.y = y;
		this.setHealth(health);
		this.setMaxHealth(maxhealth);
		this.texturefactor = texturefactor;
		this.walkspeed = walkspeed;
		this.runspeed = runspeed;
		speed = this.walkspeed;
		Collider = new Rectangle(x, y, texturefactor, texturefactor);
		EmptyHeart = Canvas.QuickLoad("gui/emptyheart");
		Heart = Canvas.QuickLoad("gui/heart");

	}
	
	public void DrawHealth(){
	  
		for(int i = 0; i < maxHealth; i++){
			Canvas.DrawQuadTex(EmptyHeart, i * 35, 4, 32, 32);
			}
		for(int i = 0; i < Health; i++){
			Canvas.DrawQuadTex(Heart, i * 35, 4, 32, 32);
	   
		}
		
		
	}

	public void HandleControls() {
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			running = true;
			this.setSpeed(this.getRunspeed());
		} else {
			running = false;
			this.setSpeed(this.getWalkspeed());
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			direction = 0;
			walking = true;
			WalkUp();
		}

		else if (Keyboard.isKeyDown(Keyboard.KEY_D) || Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			direction = 1;
			walking = true;
			WalkRight();
		}

		else if (Keyboard.isKeyDown(Keyboard.KEY_S) || Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			direction = 2;
			walking = true;
			WalkDown();
		}

		else if (Keyboard.isKeyDown(Keyboard.KEY_A) || Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			direction = 3;
			walking = true;
			WalkLeft();
		} else {
			walking = false;
		}
		// System.out.println(getSpeed());
	}

	private void WalkLeft() {
		this.setX(this.getX() - this.getSpeed());

	}

	private void WalkDown() {
		this.setY(this.getY() + this.getSpeed());

	}

	private void WalkRight() {
		this.setX(this.getX() + this.getSpeed());

	}

	private void WalkUp() {
		this.setY(this.getY() - this.getSpeed());

	}

	public void Draw() {
		Canvas.DrawQuadTex(tex, x, y, texturefactor, texturefactor);
		DrawHealth();
		// System.out.println("Drawing player");
	}

	public void HandleInventory() {
		this.getI().Update();
	}

	public void HandleItemUse() {
		if (this.getI().getEquiped() != null) {
			if (!click0down && Mouse.isButtonDown(0)) {
				click0down = true;
				this.getI().getEquiped().Use();
			}
		}
	}

	public void Update() {
		if (!Mouse.isButtonDown(0)) {

			click0down = false;
		}
		HandleItemUse();
		HandleInventory();
		HandleControls();
		HandleHealth();
		Collider = new Rectangle(x, y, texturefactor, texturefactor);
		Draw();

	}

	private void HandleHealth() {
		//TODO add death
		if(Health > maxHealth){
			Health = maxHealth;
		}
		
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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isWalking() {
		return walking;
	}

	public void setWalking(boolean walking) {
		this.walking = walking;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public Inventory getI() {
		return i;
	}

	public void setI(Inventory i) {
		this.i = i;
	}

	public Rectangle getCollider() {
		return Collider;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getHealth() {
		return Health;
	}

	public void setHealth(int health) {
		Health = health;
	}
	public void Damage(int damage){
		Health = Health - damage;
	}
	public void Heal(int heal){
		Health = Health + heal;
	}

}

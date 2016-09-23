package com.jakibah.infinyvale;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.opengl.Texture;

public class Player {

	private Texture tex;
	private int x, y, texturefactor, walkspeed, runspeed, speed;
	private int direction = 2;
	private boolean walking = false;
	private boolean running = false;

	public Player(Texture tex, int x, int y, int texturefactor, int walkspeed,
			int runspeed) {
		this.tex = tex;
		this.x = x;
		this.y = y;
		this.texturefactor = texturefactor;
		this.walkspeed = walkspeed;
		this.runspeed = runspeed;
		speed = this.walkspeed;
	}

	public void HandleControls() {
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			running = true;
			this.setSpeed(this.getRunspeed());
		} else {
			running = false;
			this.setSpeed(this.getWalkspeed());
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_W)
				|| Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			direction = 0;
			walking = true;
			WalkUp();
		} else if (Keyboard.isKeyDown(Keyboard.KEY_D)
				|| Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			direction = 1;
			walking = true;
			WalkRight();
		} else if (Keyboard.isKeyDown(Keyboard.KEY_S)
				|| Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			direction = 2;
			walking = true;
			WalkDown();
		} else if (Keyboard.isKeyDown(Keyboard.KEY_A)
				|| Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			direction = 3;
			walking = true;
			WalkLeft();
		} else {
			walking = false;
		}
		// System.out.println("Direction: " + direction + " Walking: " + walking
		// + " Running: " + running);
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
		// System.out.println("Drawing player");
	}

	public void Update() {
		HandleControls();
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

}

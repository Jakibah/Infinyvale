package com.jakibah.infinyvale;

import org.lwjgl.input.Keyboard;

public class InputHandler {

	private Player p;
	private int direction = 2;
	private boolean walking = false;
	private boolean running = false;

	public InputHandler(Player p) {
		this.p = p;
	}

	public void HandleControls() {
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			running = true;
			p.setSpeed(p.getRunspeed());
		}else{
			running = false;
			p.setSpeed(p.getWalkspeed());
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			direction = 0;
			walking = true;
			WalkUp();
		} else if (Keyboard.isKeyDown(Keyboard.KEY_D) || Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			direction = 1;
			walking = true;
			WalkRight();
		} else if (Keyboard.isKeyDown(Keyboard.KEY_S) || Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			direction = 2;
			walking = true;
			WalkDown();
		} else if (Keyboard.isKeyDown(Keyboard.KEY_A) || Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			direction = 3;
			walking = true;
			WalkLeft();
		}else{
			walking = false;
		}
		System.out.println("Direction: " + direction + " Walking: " + walking +   " Running: " + running);
	}

	private void WalkLeft() {
		p.setX(p.getX() - p.getSpeed());
		
	}

	private void WalkDown() {
		p.setY(p.getY() + p.getSpeed());
		
	}

	private void WalkRight() {
		p.setX(p.getX() + p.getSpeed());
		
	}

	private void WalkUp() {
		p.setY(p.getY() - p.getSpeed());
		
	}

	public void Update() {
		HandleControls();
	}

	public Player getPlayer() {
		return p;
	}

	public void setPlayer(Player p) {
		this.p = p;
	}

	public int getDirection() {
		return direction;
	}

	public boolean isWalking() {
		return walking;
	}

}

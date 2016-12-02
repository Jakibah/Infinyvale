package com.jakibah.infinyvale;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.opengl.Texture;

import com.jakibah.infinyvale.enums.Race;

public class NPC {

	private int x, y, texturefactor;
	private String name, gender;
	private ArrayList<String> text;
	private boolean solid;
	private Rectangle Collider;
	private Texture tex;
	private Race r;
	private Texture Balloon = Canvas.QuickLoad("gui/textballoon");
	//private Texture Balloon = Canvas.QuickLoad("items/testitem");

	public NPC(int x, int y, int texturefactor, Texture tex, boolean solid, Race r, String gender) {
		this.tex = tex;
		this.x = x;
		this.y = y;
		this.r = r;
		this.texturefactor = texturefactor;
		this.setGender(gender);
		name = r.getName(r, gender);
		this.text = Speech.get(r, gender);
		this.solid = solid;
	}

	public void Update() {
		this.Collider = new Rectangle(x, y, texturefactor, texturefactor * 2);
		Draw();
		if (Canvas.isColliding(this.Collider, Game.p.getCollider(), solid)) {
			if (!Keyboard.isKeyDown(Keyboard.KEY_E)) {
				Game.Cardinal.Draw(0, 0, "Press E to interact.");
			} else {
				Talk();
			}
		}

	}

	public void Draw() {
		Canvas.DrawQuadTex(tex, x, y, texturefactor, texturefactor * 2);
	}

	
	public void Talk() {
		boolean talking = true;
		int mouseclick = 0;
		boolean click0down = true;
		
		// GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		while (talking) {
			Canvas.DrawQuadTex(Balloon, 0, ((Display.getHeight() / 4) * 3) - 5, Display.getWidth(),
					(Display.getHeight() / 4) + 5);
			Canvas.DrawQuadTex(Balloon, 90, ((Display.getHeight() / 4) * 3) - 37, 190, 32);
			System.out.println((Display.getHeight() / 4) + 5);
			if (mouseclick == text.size()) {
				talking = false;
			} else {
				Game.VCR_OSD_MONO.Draw(79, ((Display.getHeight() / 4) * 3) + 17, text.get(mouseclick));
				Game.VCR_OSD_MONO.Draw(120, ((Display.getHeight() / 4) * 3) - 32, name);
			}

			if (!Mouse.isButtonDown(0)) {
				click0down = false;
			}
			if (!click0down && Mouse.isButtonDown(0)) {
				mouseclick++;
				click0down = true;
			}
			Display.update();

		}
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getText() {
		return text;
	}

	public void setText(ArrayList<String> text) {
		this.text = text;
	}

	public boolean isSolid() {
		return solid;
	}

	public void setSolid(boolean solid) {
		this.solid = solid;
	}

	public Rectangle getCollider() {
		return Collider;
	}

	public void setCollider(Rectangle collider) {
		Collider = collider;
	}

	public Texture getTex() {
		return tex;
	}

	public void setTex(Texture tex) {
		this.tex = tex;
	}

	public Race getR() {
		return r;
	}

	public void setR(Race r) {
		this.r = r;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}

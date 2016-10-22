package com.jakibah.infinyvale;

import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import static org.lwjgl.opengl.GL11.*;

public class Canvas {

	public static void CreateCanvas(int width, int height, String title, int fps) {

		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle(title);

			Display.create();

		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, width, height, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

		Game.Start();
		while (!Display.isCloseRequested()) {
			Display.update();
			Display.sync(fps);
			Game.Update();
		}
		Game.Stop();
		Display.destroy();
		System.exit(0);
	}

	public static void DrawQuadTex(Texture tex, float x, float y, float width, float height) {
		tex.bind();
		glTranslatef(x, y, 0);
		// GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1, 0);
		glVertex2f(width, 0);
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		glEnd();
		glLoadIdentity();

	}

	public static Texture loadTexture(String path, String fileType) {
		Texture tex = null;
		InputStream in = ResourceLoader.getResourceAsStream(path);
		try {
			tex = TextureLoader.getTexture(fileType, in);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return tex;
	}

	public static Texture QuickLoad(String name) {
		Texture tex = null;
		tex = loadTexture("com/jakibah/infinyvale/resources/textures/" + name + ".png", "PNG");
		return tex;

	}

	public static boolean isColliding(Rectangle a, Rectangle b) {

		if (a.intersects(b)) {
			return true;
		}

		else {
			return false;
		}
	}

	static int locked = 0;

	public static boolean isColliding(Rectangle a, Rectangle b, boolean solid) {
		if (a.intersects(b)) {
			switch(Game.p.getDirection()){
			case 0:
				Game.p.setY(Game.p.getY() + Game.p.getSpeed());
				break;
			case 1:
				Game.p.setX(Game.p.getX() - Game.p.getSpeed());
				break;
			case 2:
				Game.p.setY(Game.p.getY() - Game.p.getSpeed());
				break;
			case 3:
				Game.p.setX(Game.p.getX() + Game.p.getSpeed());
				break;
			}
			return true;
		}else{
			return false;
		}
	}
}

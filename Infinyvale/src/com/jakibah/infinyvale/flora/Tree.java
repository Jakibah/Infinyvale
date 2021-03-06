package com.jakibah.infinyvale.flora;




import org.lwjgl.input.Keyboard;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.opengl.Texture;

import com.jakibah.infinyvale.Canvas;
import com.jakibah.infinyvale.Flora;
import com.jakibah.infinyvale.Game;
import com.jakibah.infinyvale.Item;
import com.jakibah.infinyvale.Textdrawer;
import com.jakibah.infinyvale.enums.TreeType;

public class Tree extends Flora {

	private Texture[] tex;
	private Rectangle TreeCollider;
	private Rectangle LeafCollider;
	private Textdrawer td = Game.Cardinal;

	public Tree(TreeType type, int x, int y, int texturefactor, boolean solid, int collecttime,
			Item drop) {
		super(x, y, texturefactor, solid, collecttime, drop);
		this.tex = new Texture[3];
		tex[0] = type.lowertrunk;
		tex[1] = type.trunk;
		tex[2] = type.leaves;
		TreeCollider = new Rectangle(x, y + 32, texturefactor, texturefactor * 2);
		LeafCollider = new Rectangle(x - 16, y, texturefactor * 2, texturefactor);
		
		
	}

	@Override
	public void Update() {
		super.Update();
		Collision();
		Draw();
	}

	@Override
	public void Destroy() {
		super.Destroy();
	}

	public void Draw() {
		Canvas.DrawQuadTex(tex[2], x - 16, y, texturefactor * 2, texturefactor);
		Canvas.DrawQuadTex(tex[1], x, y + 32, texturefactor, texturefactor);
		Canvas.DrawQuadTex(tex[0], x, y + 64, texturefactor, texturefactor);
	}
	
	int debug = 0;
	public void Collision(){
		if (this.isSolid()){
			if(Canvas.isColliding(Game.p.getCollider(), this.getTreeCollider(), true)){
				td.Draw(0, 0, "Press E to cut down.");
				if(Keyboard.isKeyDown(Keyboard.KEY_E)){
					Destroy();
				}
				}else if(Canvas.isColliding(Game.p.getCollider(), this.getLeafCollider(), true)){
				
			}
		}
	}

	public Texture[] getTex() {
		return tex;
	}

	public void setTex(Texture[] tex) {
		this.tex = tex;
	}

	public Rectangle getTreeCollider() {
		return TreeCollider;
	}

	public Rectangle getLeafCollider() {
		return LeafCollider;
	}

}

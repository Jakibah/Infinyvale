package com.jakibah.infinyvale.flora;

import org.newdawn.slick.opengl.Texture;

import com.jakibah.infinyvale.Canvas;
import com.jakibah.infinyvale.Flora;
import com.jakibah.infinyvale.Game;
import com.jakibah.infinyvale.Item;
import com.jakibah.infinyvale.enums.TreeType;

public class Tree extends Flora {

	private Texture[] tex;

	public Tree(TreeType type, int x, int y, int texturefactor, boolean solid, int collecttime,
			Item drop) {
		super(x, y, texturefactor, solid, collecttime, drop);
		this.tex = new Texture[3];
		tex[0] = type.lowertrunk;
		tex[1] = type.trunk;
		tex[2] = type.leaves;
	}

	@Override
	public void Update() {
		super.Update();
		Draw();
	}

	@Override
	public void Destroy() {
		super.Destroy();
	}

	public void Draw() {
		Canvas.DrawQuadTex(tex[0], x, y, texturefactor, texturefactor);
		Canvas.DrawQuadTex(tex[1], x, y + 32, texturefactor, texturefactor);
		Canvas.DrawQuadTex(tex[2], x, y + 64, texturefactor, texturefactor);
	}
	
	int debug = 0;
	public void Collision(){
		//TODO add collision to trees
		if (this.isSolid()){
			if(Canvas.isColliding(this.x, this.y, this.x + 32, this.y + 96, Game.p.getX(), Game.p.getY())){
				System.out.println("Colliding " + debug);
				debug++;
			}
		}
	}

	public Texture[] getTex() {
		return tex;
	}

	public void setTex(Texture[] tex) {
		this.tex = tex;
	}

}

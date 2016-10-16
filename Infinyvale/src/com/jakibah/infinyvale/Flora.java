package com.jakibah.infinyvale;

public abstract class Flora {
	
	
	protected int x;
	protected int y;
	protected int texturefactor;
	private boolean solid;
	private int collectime;
	private Item drop;

	public Flora(int x, int y, int texturefactor, boolean solid, int collecttime, Item drop){
		this.x = x;
		this.y = y;
		this.texturefactor = texturefactor;
		this.solid = solid;
		this.collectime = collecttime;
		this.drop = drop;
	}
	
	public void Update(){
		
	}
	
	public void Destroy(){
		
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

	public boolean isSolid() {
		return solid;
	}

	public void setSolid(boolean solid) {
		this.solid = solid;
	}

	public int getCollectime() {
		return collectime;
	}

	public void setCollectime(int collectime) {
		this.collectime = collectime;
	}

	public Item getDrop() {
		return drop;
	}

	public void setDrop(Item drop) {
		this.drop = drop;
	}

}
